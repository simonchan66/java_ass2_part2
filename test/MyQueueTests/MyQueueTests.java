package MyQueueTests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utilities.QueueADT;
import utilities.EmptyQueueException;
import utilities.Iterator;
import implementation.MyQueue;

public class MyQueueTests {
    // Attributes
    private QueueADT<Integer> myQueue;
    private Integer one;
    private Integer two;
    private Integer three;
    private Integer four;
    private Integer five;

    /**
     * Sets up the test environment before each test method.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        myQueue = new MyQueue<>();
        one = Integer.valueOf(1);
        two = Integer.valueOf(2);
        three = Integer.valueOf(3);
        four = Integer.valueOf(4);
        five = Integer.valueOf(5);
    }

    /**
     * Tears down the test environment after each test method.
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        myQueue = null;
        one = null;
        two = null;
        three = null;
        four = null;
        five = null;
    }

    /**
     * Test method for {@link implementation.MyQueue#MyQueue()}.
     */
    @Test
    public void testMyQueueConstructor() {
        assertNotNull("Queue was not created.", myQueue);
    }

    /**
     * Test method for {@link implementation.MyQueue#enqueue(Object)}.
     * @throws EmptyQueueException 
     */
    @Test
    public void testEnqueue() throws EmptyQueueException {
        myQueue.enqueue(one);
        assertEquals("Front element is not correct after enqueue.", one, myQueue.peek());
    }

    /**
     * Test method for {@link implementation.MyQueue#dequeue()}.
     * @throws EmptyQueueException 
     */
    @Test
    public void testDequeue() throws EmptyQueueException {
        myQueue.enqueue(one);
        myQueue.enqueue(two);
        Integer dequeuedElement = myQueue.dequeue();
        assertEquals("Dequeued element is not correct.", one, dequeuedElement);
        assertEquals("Front element is not correct after dequeue.", two, myQueue.peek());
    }

    /**
     * Test method for {@link implementation.MyQueue#peek()}.
     * @throws EmptyQueueException 
     */
    @Test
    public void testPeek() throws EmptyQueueException {
        myQueue.enqueue(one);
        myQueue.enqueue(two);
        Integer frontElement = myQueue.peek();
        assertEquals("Front element is not correct.", one, frontElement);
    }

    /**
     * Test method for {@link implementation.MyQueue#dequeueAll()}.
     */
    @Test
    public void testDequeueAll() {
        myQueue.enqueue(one);
        myQueue.enqueue(two);
        myQueue.dequeueAll();
        assertTrue("Queue should be empty after dequeueAll.", myQueue.isEmpty());
    }

    /**
     * Test method for {@link implementation.MyQueue#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        assertTrue("Queue should be empty initially.", myQueue.isEmpty());
        myQueue.enqueue(one);
        assertFalse("Queue should not be empty after enqueue.", myQueue.isEmpty());
    }

    /**
     * Test method for {@link implementation.MyQueue#iterator()}.
     */
    @Test
    public void testIterator() {
        myQueue.enqueue(one);
        myQueue.enqueue(two);
        myQueue.enqueue(three);
        Iterator<Integer> iterator = myQueue.iterator();
        assertTrue("Iterator should have next element.", iterator.hasNext());
        assertEquals("Iterator should return the correct next element.", one, iterator.next());
        assertTrue("Iterator should have next element.", iterator.hasNext());
        assertEquals("Iterator should return the correct next element.", two, iterator.next());
        assertTrue("Iterator should have next element.", iterator.hasNext());
        assertEquals("Iterator should return the correct next element.", three, iterator.next());
        assertFalse("Iterator should not have next element.", iterator.hasNext());
    }

    /**
     * Test method for {@link implementation.MyQueue#equals(QueueADT)}.
     */
    @Test
    public void testEqualsQueueADT() {
        myQueue.enqueue(one);
        myQueue.enqueue(two);
        QueueADT<Integer> otherQueue = new MyQueue<>();
        otherQueue.enqueue(one);
        otherQueue.enqueue(two);
        assertTrue("Queues should be equal.", myQueue.equals(otherQueue));
        otherQueue.enqueue(three);
        assertFalse("Queues should not be equal.", myQueue.equals(otherQueue));
    }

    /**
     * Test method for {@link implementation.MyQueue#toArray()}.
     */
    @Test
    public void testToArray() {
        myQueue.enqueue(one);
        myQueue.enqueue(two);
        myQueue.enqueue(three);
        Object[] array = myQueue.toArray();
        assertArrayEquals("Array should contain the elements of the queue.", new Integer[]{one, two, three}, array);
    }

    /**
     * Test method for {@link implementation.MyQueue#toArray(Object[])}.
     */
    @Test
    public void testToArrayWithArgument() {
        myQueue.enqueue(one);
        myQueue.enqueue(two);
        myQueue.enqueue(three);
        Integer[] array = new Integer[3];
        Integer[] result = myQueue.toArray(array);
        assertArrayEquals("Array should contain the elements of the queue.", new Integer[]{one, two, three}, result);
    }

    /**
     * Test method for {@link implementation.MyQueue#isFull()}.
     */
    @Test
    public void testIsFull() {
        // Assuming the queue has no fixed capacity
        myQueue.enqueue(one);
        myQueue.enqueue(two);
        myQueue.enqueue(three);
        assertFalse("Queue should not be full.", myQueue.isFull());
    }

    /**
     * Test method for {@link implementation.MyQueue#size()}.
     */
    @Test
    public void testSize() {
        myQueue.enqueue(one);
        myQueue.enqueue(two);
        myQueue.enqueue(three);
        assertEquals("Size should be equal to the number of elements enqueued.", 3, myQueue.size());
    }
}