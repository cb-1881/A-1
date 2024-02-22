import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestLinkedListWithIterator {
    private LinkedListWithIterator<String> myList;

    @Before
    public void setUp() {
        myList = new LinkedListWithIterator<>();
    }

    @Test
    public void testIsEmptyOnNewList() {
        assertTrue("List should be empty", myList.isEmpty());
    }

    @Test
    public void testAddEnd() {
        myList.add("First");
        assertFalse("List should not be empty after add", myList.isEmpty());
        assertEquals("Length should be 1 after adding one item", 1, myList.getLength());
    }

    @Test
    public void testAddAtPosition() {
        assertTrue("Add at position 1 should succeed", myList.add(1, "Second"));
        assertTrue("Add at position 1 should succeed, making it the first element", myList.add(1, "First"));
        assertEquals("First item should be 'First'", "First", myList.getEntry(1));
        assertEquals("Second item should be 'Second'", "Second", myList.getEntry(2));
    }

    @Test
    public void testRemove() {
        myList.add("First");
        myList.add("Second");
        assertEquals("Remove first item should return 'First'", "First", myList.remove(1));
        assertEquals("Second item should now be the first", "Second", myList.getEntry(1));
        assertEquals("Length should be 1 after removal", 1, myList.getLength());
    }

    @Test
    public void testReplace() {
        myList.add("First");
        assertEquals("Replacing 'First' with 'Replaced' should return 'First'", "First", myList.replace(1, "Replaced"));
        assertEquals("First item should now be 'Replaced'", "Replaced", myList.getEntry(1));
    }

    @Test
    public void testGetEntry() {
        myList.add("First");
        myList.add("Second");
        assertEquals("First item should be 'First'", "First", myList.getEntry(1));
        assertEquals("Second item should be 'Second'", "Second", myList.getEntry(2));
    }

    @Test
    public void testContains() {
        myList.add("First");
        assertTrue("List should contain 'First'", myList.contains("First"));
        assertFalse("List should not contain 'Second'", myList.contains("Second"));
    }

    @Test
    public void testToArray() {
        myList.add("First");
        myList.add("Second");
        Object[] array = myList.toArray();
        assertArrayEquals("Array should match the list contents", new Object[]{"First", "Second"}, array);
    }

    @Test
    public void testClear() {
        myList.add("First");
        myList.clear();
        assertTrue("List should be empty after clear", myList.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetEntryOutOfBounds() {
        myList.getEntry(1); // This should throw an IndexOutOfBoundsException because the list is empty
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBounds() {
        myList.remove(1); // This should throw an IndexOutOfBoundsException because the list is empty
    }
}
