package implementation;

import utilities.Iterator;
import utilities.StackADT;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyStack<E> implements StackADT<E> {
    private MyArrayList<E> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    @Override
    public void push(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null element to the stack");
        }
        list.add(toAdd);
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    @Override
    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        int index = size() - 1;
        for (int i = 0; i < list.size(); i++) {
            array[index--] = list.get(i);
        }
        return array;
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        if (holder == null) {
            throw new NullPointerException("Array cannot be null");
        }
        if (holder.length < size()) {
            holder = Arrays.copyOf(holder, size());
        }
        int index = size() - 1;
        Iterator<E> iterator = list.iterator();
        while (iterator.hasNext()) {
            holder[index--] = iterator.next();
        }
        if (holder.length > size()) {
            holder[size()] = null;
        }
        return holder;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return list.contains(toFind);
    }

    @Override
    public int search(E toFind) {
        int index = list.size() - 1;
        Iterator<E> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(toFind)) {
                return list.size() - index;
            }
            index--;
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    @Override
    public boolean equals(StackADT<E> that) {
        if (this == that) {
            return true;
        }
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        MyStack<E> other = (MyStack<E>) that;
        if (size() != other.size()) {
            return false;
        }
        Iterator<E> thisIterator = iterator();
        Iterator<E> thatIterator = other.iterator();
        while (thisIterator.hasNext() && thatIterator.hasNext()) {
            if (!thisIterator.next().equals(thatIterator.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return list.size();
    }

    private class StackIterator implements Iterator<E> {
        private int current;

        public StackIterator() {
            current = list.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return current >= 0;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            return list.get(current--);
        }
    }
}