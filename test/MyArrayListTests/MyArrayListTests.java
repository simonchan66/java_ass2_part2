package MyArrayListTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import implementation.MyArrayList;
import utilities.Iterator; 
import utilities.ListADT;

public class MyArrayListTests {
    private ListADT<String> list;
    private String[] elements = {"Apple", "Banana", "Cherry", "Date", "Elderberry"};

    @Before
    public void setUp() {
        list = new MyArrayList<>();
        for (String element : elements) {
            list.add(element);
        }
    }

    @Test
    public void testSize() {
        assertEquals("Size should be equal to the number of elements added", elements.length, list.size());
    }

    @Test
    public void testClear() {
        list.clear();
        assertEquals("List should be empty after clear", 0, list.size());
    }

    @Test
    public void testAddAtIndex() {
        list.add(2, "Blueberry");
        assertEquals("Element should be added at the specified index", "Blueberry", list.get(2));
        assertEquals("Size should increase by 1 after adding an element", elements.length + 1, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtInvalidIndex() {
        list.add(-1, "Grape");
    }

    @Test
    public void testAddElement() {
        assertTrue("Element should be added successfully", list.add("Fig"));
        assertEquals("Size should increase by 1 after adding an element", elements.length + 1, list.size());
    }

    @Test
    public void testAddAll() {
        ListADT<String> newList = new MyArrayList<>();
        newList.add("Grape");
        newList.add("Honeydew");
        assertTrue("Elements should be added successfully", list.addAll(newList));
        assertEquals("Size should increase by the number of elements added", elements.length + 2, list.size());
    }

    @Test
    public void testGet() {
        assertEquals("Element at the specified index should be returned", "Banana", list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetAtInvalidIndex() {
        list.get(list.size());
    }

    @Test
    public void testRemoveAtIndex() {
        String removedElement = list.remove(2);
        assertEquals("Removed element should be returned", "Cherry", removedElement);
        assertEquals("Size should decrease by 1 after removing an element", elements.length - 1, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAtInvalidIndex() {
        list.remove(list.size());
    }

    @Test
    public void testRemoveElement() {
        String removedElement = list.remove("Date");
        assertEquals("Removed element should be returned", "Date", removedElement);
        assertEquals("Size should decrease by 1 after removing an element", elements.length - 1, list.size());
    }

    @Test
    public void testSet() {
        String previousElement = list.set(3, "Durian");
        assertEquals("Previous element at the specified index should be returned", "Date", previousElement);
        assertEquals("Element at the specified index should be updated", "Durian", list.get(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetAtInvalidIndex() {
        list.set(list.size(), "Grape");
    }

    @Test
    public void testIsEmpty() {
        assertFalse("List should not be empty", list.isEmpty());
        list.clear();
        assertTrue("List should be empty after clear", list.isEmpty());
    }

    @Test
    public void testContains() {
        assertTrue("List should contain the specified element", list.contains("Cherry"));
        assertFalse("List should not contain the specified element", list.contains("Grape"));
    }

    @Test
    public void testToArrayWithArgument() {
        String[] array = new String[list.size()];
        array = list.toArray(array);
        assertArrayEquals("Array should contain the elements of the list", elements, array);
    }

    @Test
    public void testToArray() {
        Object[] array = list.toArray();
        assertArrayEquals("Array should contain the elements of the list", elements, array);
    }

    @Test
    public void testIterator() {
        Iterator<String> iterator = list.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            assertEquals("Iterator should return elements in proper sequence", elements[index], iterator.next());
            index++;
        }
    }

}
