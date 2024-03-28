package MyStackTests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utilities.StackADT;
import utilities.Iterator;
import implementation.MyStack;

public class MyStackTests {
    // Attributes
    private StackADT<Integer> myStack;
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
        myStack = new MyStack<>();
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
        myStack = null;
        one = null;
        two = null;
        three = null;
        four = null;
        five = null;
    }

    /**
     * Test method for {@link implementation.MyStack#MyStack()}.
     */
    @Test
    public void testMyStackConstructor() {
        assertNotNull("Stack was not created.", myStack);
    }

    /**
     * Test method for {@link implementation.MyStack#push(Object)}.
     */
    @Test
    public void testPush() {
        myStack.push(one);
        assertEquals("Top element is not correct after push.", one, myStack.peek());
    }

    /**
     * Test method for {@link implementation.MyStack#pop()}.
     */
    @Test
    public void testPop() {
        myStack.push(one);
        myStack.push(two);
        Integer poppedElement = myStack.pop();
        assertEquals("Popped element is not correct.", two, poppedElement);
        assertEquals("Top element is not correct after pop.", one, myStack.peek());
    }

    /**
     * Test method for {@link implementation.MyStack#peek()}.
     */
    @Test
    public void testPeek() {
        myStack.push(one);
        myStack.push(two);
        Integer topElement = myStack.peek();
        assertEquals("Top element is not correct.", two, topElement);
    }

    /**
     * Test method for {@link implementation.MyStack#clear()}.
     */
    @Test
    public void testClear() {
        myStack.push(one);
        myStack.push(two);
        myStack.clear();
        assertTrue("Stack should be empty after clear.", myStack.isEmpty());
    }

    /**
     * Test method for {@link implementation.MyStack#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        assertTrue("Stack should be empty initially.", myStack.isEmpty());
        myStack.push(one);
        assertFalse("Stack should not be empty after push.", myStack.isEmpty());
    }

    /**
     * Test method for {@link implementation.MyStack#toArray()}.
     */
    @Test
    public void testToArray() {
        myStack.push(one);
        myStack.push(two);
        myStack.push(three);
        Object[] array = myStack.toArray();
        assertArrayEquals("Array should contain the elements of the stack.", new Integer[]{three, two, one}, array);
    }

    /**
     * Test method for {@link implementation.MyStack#toArray(Object[])}.
     */
    @Test
    public void testToArrayWithArgument() {
        myStack.push(one);
        myStack.push(two);
        myStack.push(three);
        Integer[] array = new Integer[3];
        Integer[] result = myStack.toArray(array);
        assertArrayEquals("Array should contain the elements of the stack.", new Integer[]{three, two, one}, result);
    }

    /**
     * Test method for {@link implementation.MyStack#contains(Object)}.
     */
    @Test
    public void testContains() {
        myStack.push(one);
        myStack.push(two);
        assertTrue("Stack should contain the specified element.", myStack.contains(one));
        assertFalse("Stack should not contain the specified element.", myStack.contains(three));
    }

    /**
     * Test method for {@link implementation.MyStack#search(Object)}.
     */
    @Test
    public void testSearch() {
        myStack.push(one);
        myStack.push(two);
        myStack.push(three);
        assertEquals("Search should return the correct distance from the top.", 2, myStack.search(two));
        assertEquals("Search should return -1 for an element not in the stack.", -1, myStack.search(four));
    }

    /**
     * Test method for {@link implementation.MyStack#iterator()}.
     */
    @Test
    public void testIterator() {
        myStack.push(one);
        myStack.push(two);
        myStack.push(three);
        Iterator<Integer> iterator = myStack.iterator();
        assertTrue("Iterator should have next element.", iterator.hasNext());
        assertEquals("Iterator should return the correct next element.", three, iterator.next());
        assertTrue("Iterator should have next element.", iterator.hasNext());
        assertEquals("Iterator should return the correct next element.", two, iterator.next());
        assertTrue("Iterator should have next element.", iterator.hasNext());
        assertEquals("Iterator should return the correct next element.", one, iterator.next());
        assertFalse("Iterator should not have next element.", iterator.hasNext());
    }

    /**
     * Test method for {@link implementation.MyStack#equals(StackADT)}.
     */
    @Test
    public void testEqualsStackADT() {
        myStack.push(one);
        myStack.push(two);
        StackADT<Integer> otherStack = new MyStack<>();
        otherStack.push(one);
        otherStack.push(two);
        assertTrue("Stacks should be equal.", myStack.equals(otherStack));
        otherStack.push(three);
        assertFalse("Stacks should not be equal.", myStack.equals(otherStack));
    }

    /**
     * Test method for {@link implementation.MyStack#size()}.
     */
    @Test
    public void testSize() {
        myStack.push(one);
        myStack.push(two);
        myStack.push(three);
        assertEquals("Size should be equal to the number of elements pushed.", 3, myStack.size());
    }
}