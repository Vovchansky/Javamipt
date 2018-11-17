package lists;

import org.junit.*;

public class SimpleTest extends Assert {
    private MyIntegerList linkedList;

    @Before
    public void init() {
        linkedList = new DoubleLinkedList();
        Assert.assertEquals("List should be printed as [] when initialized", "[]", linkedList.printList());
        Assert.assertEquals("Empty list is of size zero",  0, linkedList.size());
    }

    @Test
    public void testRemoveAll() {
        for (int i = 0; i < 10; i++) {
            linkedList.addToHead(i);
        }
        linkedList.removeAll();
        Assert.assertEquals("List should be printed as [] when cleared", "[]", linkedList.printList());
        Assert.assertEquals("Empty list is of size zero", 0, linkedList.size());
    }

    @Test
    public void testDelete() {
        linkedList.addToHead(2);
        linkedList.addToHead(3);
        Assert.assertEquals("List should be printed as [3, 2]", "[3, 2]", linkedList.printList());
        Assert.assertEquals("List should be size = 2", 2, linkedList.size());
        linkedList.removeByIndex(0);
        Assert.assertEquals("List should be printed as [2]", "[2]", linkedList.printList());
        linkedList.addToHead(4);
        Assert.assertEquals("List should be printed as [4, 2]", "[4, 2]", linkedList.printList());
        linkedList.removeByIndex(0);
        linkedList.removeByIndex(0);
        Assert.assertEquals("List should be printed as []", "[]", linkedList.printList());
    }

    @Test
    public void testSize() {
        Assert.assertEquals("Empty list is of size zero", 0, linkedList.size());
        linkedList.addToHead(1);
        Assert.assertEquals("List with one element is of size = 1", 1, linkedList.size());
        linkedList.addToHead(2);
        Assert.assertEquals("List with two elements is of size = 2", 2, linkedList.size());
        linkedList.addToHead(3);
        Assert.assertEquals("List with three elements is of size = 3", 3, linkedList.size());
        linkedList.addToHead(4);
        Assert.assertEquals("List with four elements is of size = 4", 4, linkedList.size());
    }

    @Test
    public void testList() {
        Assert.assertEquals("List should be printed as [] when empty", "[]", linkedList.printList());
        linkedList.addToHead(1);
        Assert.assertEquals("List should be printed as [1]", "[1]", linkedList.printList());
        linkedList.addToHead(2);
        Assert.assertEquals("List should be printed as [2, 1]", "[2, 1]", linkedList.printList());
        linkedList.addToHead(3);
        Assert.assertEquals("List should be [3, 2, 1]", "[3, 2, 1]", linkedList.printList());
        linkedList.addToHead(5);
        Assert.assertEquals("List should be [5, 3, 2, 1]", "[5, 3, 2, 1]", linkedList.printList());
        linkedList.addToHead(4);
        Assert.assertEquals("List [4, 5, 3, 2, 1]", "[4, 5, 3, 2, 1]", linkedList.printList());
    }

    @Test
    public void testAddToHead() {
        Assert.assertEquals("List should be printed as [] when initialized", "[]", linkedList.printList());
        linkedList.addToHead(1);
        linkedList.addToHead(5);
        Assert.assertEquals("Should return 5 if the List is [5, 1]", 5, linkedList.getByIndex(0));
    }

    @Test
    public void testAddToTail() {
        Assert.assertEquals("List should be printed as [] when initialized", "[]", linkedList.printList());
        Assert.assertEquals("Empty list is of size zero", 0, linkedList.size());
        linkedList.addToTail(18);
        Assert.assertEquals("List should be [18]", "[18]", linkedList.printList());
        Assert.assertEquals("Empty list is of size 1", 1, linkedList.size());
        linkedList.addToTail(7);
        Assert.assertEquals("List should be [18, 7]", "[18, 7]", linkedList.printList());
        Assert.assertEquals("Empty list is of size 2", 2, linkedList.size());
        Assert.assertEquals("Should return 18 if the List is [7, 18]", 7, linkedList.getByIndex(linkedList.size() - 1));
    }

    @Test
    public void testcontainsElem() {
        Assert.assertEquals("List should be printed as [] when initialized", "[]", linkedList.printList());
        Assert.assertEquals("Empty list is of size zero", 0, linkedList.size());
        linkedList.addToTail(18);
        Assert.assertTrue(linkedList.containsElem(18));
        Assert.assertEquals("List is of size 1 should return 1", 1, linkedList.size());
        linkedList.addToTail(1488);
        Assert.assertTrue(linkedList.containsElem(1488));
        Assert.assertFalse(linkedList.containsElem(0));
    }

    @Test
    public void testToArray() {
        Assert.assertEquals("List should be printed as [] when initialized", "[]", linkedList.printList());
        Assert.assertEquals("Empty list is of size zero", 0, linkedList.size());
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            linkedList.addToTail(i);
            a[i] = i;
        }
        Assert.assertArrayEquals(a, linkedList.toArray());
        linkedList.removeAll();
        a = new int[0];
        Assert.assertArrayEquals(a, linkedList.toArray());
    }
}
