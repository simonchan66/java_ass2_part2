package MyDLLTests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import implementation.MyDLL;

public class MyDLLTests {
    // Attributes
    private MyDLL<Integer> myDLL;
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
        myDLL = new MyDLL<>();
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
        myDLL = null;
        one = null;
        two = null;
        three = null;
        four = null;
        five = null;
    }

    /**
     * Test method for {@link linkedListImplementation.MyDLL#MyDLL()}.
     */
    @Test
    public void testMyDLLConstructor() {
        assertNotNull("Double-linked list was not created.", myDLL);
    }
    /**
     * Test method for adding an element to the beginning of the list.
     */
    @Test
    public void testAddFirst() {
        myDLL.add(0, one);
        assertEquals("First element is not correct after adding to the beginning.", one, myDLL.get(0));
    }

    /**
     * Test method for adding an element to the end of the list.
     */
@Test
public void testAddLast() {
	myDLL.add(myDLL.size(), five);
	assertEquals("Last element is not correct after adding to the end.", five, myDLL.get(myDLL.size() - 1));
}

    /**
     * Test method for removing the first element from the list.
     */
    @Test
    public void testRemoveFirst() {
        myDLL.add(0, one);
        myDLL.add(1, two);
        myDLL.remove(0);
        assertEquals("First element is not correct after removing from the beginning.", two, myDLL.get(0));
    }

    /**
     * Test method for removing the last element from the list.
     */
    @Test
    public void testRemoveLast() {
        myDLL.add(0, four);
        myDLL.add(1, five);
        myDLL.remove(myDLL.size() - 1);
        assertEquals("Last element is not correct after removing from the end.", four, myDLL.get(myDLL.size() - 1));
    }

    /**
     * Test method for {@link linkedListImplementation.MyDLL#size()}.
     */
    @Test
    public void testSize() {
        myDLL.add(one);
        myDLL.add(two);
        myDLL.add(three);
        assertEquals("Size should be equal to the number of elements added", 3, myDLL.size());
    }

    /**
     * Test method for {@link linkedListImplementation.MyDLL#clear()}.
     */
    @Test
    public void testClear() {
        myDLL.add(one);
        myDLL.add(two);
        myDLL.clear();
        assertEquals("List should be empty after clear", 0, myDLL.size());
    }

    /**
     * Test method for {@link linkedListImplementation.MyDLL#add(int, Object)}.
     */
    @Test
    public void testAddAtIndex() {
        myDLL.add(one);
        myDLL.add(two);
        myDLL.add(1, three);
        assertEquals("Element should be added at the specified index", three, myDLL.get(1));
        assertEquals("Size should increase by 1 after adding an element", 3, myDLL.size());
    }

    /**
     * Test method for {@link linkedListImplementation.MyDLL#add(int, Object)} with invalid index.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtInvalidIndex() {
        myDLL.add(-1, one);
    }

    /**
     * Test method for {@link linkedListImplementation.MyDLL#get(int)}.
     */
    @Test
    public void testGet() {
        myDLL.add(one);
        myDLL.add(two);
        assertEquals("Element at the specified index should be returned", two, myDLL.get(1));
    }

    /**
     * Test method for {@link linkedListImplementation.MyDLL#get(int)} with invalid index.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetAtInvalidIndex() {
        myDLL.get(0);
    }

    /**
     * Test method for {@link linkedListImplementation.MyDLL#remove(int)}.
     */
    @Test
    public void testRemoveAtIndex() {
        myDLL.add(one);
        myDLL.add(two);
        myDLL.add(three);
        Integer removedElement = myDLL.remove(1);
        assertEquals("Removed element should be returned", two, removedElement);
        assertEquals("Size should decrease by 1 after removing an element", 2, myDLL.size());
    }

    /**
     * Test method for {@link linkedListImplementation.MyDLL#remove(int)} with invalid index.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAtInvalidIndex() {
        myDLL.remove(0);
    }

    /**
     * Test method for {@link linkedListImplementation.MyDLL#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        assertTrue("List should be empty initially", myDLL.isEmpty());
        myDLL.add(one);
        assertFalse("List should not be empty after adding an element", myDLL.isEmpty());
    }

    /**
     * Test method for {@link linkedListImplementation.MyDLL#contains(Object)}.
     */
    @Test
    public void testContains() {
        myDLL.add(one);
        myDLL.add(two);
        assertTrue("List should contain the specified element", myDLL.contains(one));
        assertFalse("List should not contain the specified element", myDLL.contains(three));
    }

    /**
     * Test method for {@link linkedListImplementation.MyDLL#toArray()}.
     */
    @Test
    public void testToArray() {
        myDLL.add(one);
        myDLL.add(two);
        myDLL.add(three);
        Object[] array = myDLL.toArray();
        assertArrayEquals("Array should contain the elements of the list", new Integer[]{one, two, three}, array);
    }
}