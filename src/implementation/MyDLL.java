package implementation;

import java.util.NoSuchElementException;
import utilities.Iterator;
import utilities.ListADT;

/**
 * A doubly-linked list implementation of the ListADT interface.
 *
 * @param <E> the type of elements held in this list
 */
public class MyDLL<E> implements ListADT<E> {
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;

    public MyDLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) throw new NullPointerException();
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd, null, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            MyDLLNode<E> current = head;
            for (int i = 0; i < index; i++) current = current.getNext();
            
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }

        size++;
        return true;
    }

    public boolean add(E toAdd) throws NullPointerException {
        return add(size, toAdd);
    }

    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException();
        boolean result = false;
        if (toAdd instanceof Iterable) {
            for (E item : (Iterable<? extends E>) toAdd) {
                result |= add(item); // |= is used to ensure all add operations are attempted
            }
        }
        return result;
    }

    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) current = current.getNext();
        return current.getElement();
    }

    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) current = current.getNext();

        if (current == head) {
            head = head.getNext();
            if (head != null) head.prev = null;
        } else if (current == tail) {
            tail = tail.getPrev();
            if (tail != null) tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
        return current.getElement();
    }

    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) throw new NullPointerException();

        MyDLLNode<E> current = head;
        while (current != null && !current.getElement().equals(toRemove)) {
            current = current.getNext();
        }

        if (current == null) {
            return null;
        }

        if (current == head) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
        } else if (current == tail) {
            tail = tail.getPrev();
            if (tail != null) {
                tail.setNext(null);
            }
        } else {
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }

        size--;
        return current.getElement();
    }

    public Iterator<E> iterator() {
        return new DLLIterator();
    }

    private class DLLIterator implements Iterator<E> {
        private MyDLLNode<E> current = head;

        public boolean hasNext() {
            return current != null;
        }

        public E next() throws NoSuchElementException {
            if (!hasNext()) throw new NoSuchElementException();
            E element = current.getElement();
            current = current.getNext();
            return element;
        }
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) throw new NullPointerException();
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    
        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) current = current.getNext();
    
        E oldElement = current.getElement();
        current.setElement(toChange);
    
        return oldElement;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) throw new NullPointerException();
    
        MyDLLNode<E> current = head;
        while (current != null) {
            if (current.getElement().equals(toFind)) {
                return true;
            }
            current = current.getNext();
        }
    
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) throw new NullPointerException();
    
        if (toHold.length < size) {
            toHold = (E[]) java.lang.reflect.Array.newInstance(toHold.getClass().getComponentType(), size);
        }
    
        MyDLLNode<E> current = head;
        for (int i = 0; i < size; i++) {
            toHold[i] = current.getElement();
            current = current.getNext();
        }
    
        if (toHold.length > size) {
            toHold[size] = null;
        }
    
        return toHold;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
    
        MyDLLNode<E> current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.getElement();
            current = current.getNext();
        }
    
        return array;
    }
}