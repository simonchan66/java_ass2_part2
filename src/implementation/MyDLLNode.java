package implementation;

/**
 * Node class for a doubly-linked list.
 *
 * @param <E> the type of element held in the linked list
 */
public class MyDLLNode<E> {
    E element;
    MyDLLNode<E> next;
    MyDLLNode<E> prev;

    public MyDLLNode(E element, MyDLLNode<E> prev, MyDLLNode<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public MyDLLNode<E> getPrev() {
        return prev;
    }

    public MyDLLNode<E> getNext() {
        return next;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setPrev(MyDLLNode<E> prev) {
        this.prev = prev;
    }

    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }
}