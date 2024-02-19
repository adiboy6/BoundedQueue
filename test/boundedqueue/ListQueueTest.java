package boundedqueue;

import java.util.Iterator;
import static org.junit.Assert.*;

public class ListQueueTest {

    private Queue<String> abc6;

    @org.junit.Before
    public void setUp() throws Exception {
        abc6 = new ListQueue<>(6);
        abc6.enqueue("A");
        abc6.enqueue("B");
        abc6.enqueue("C");
    }

    @org.junit.Test
    public void capacity() {
        Queue<String> ab2 = new ListQueue<>(2);
        assertEquals(6, abc6.capacity());
        assertEquals(2, ab2.capacity());
    }

    @org.junit.Test
    public void enqueue() {
        assertEquals(3, abc6.length());
        abc6.enqueue("D");
        assertEquals(4, abc6.length());
    }

    @org.junit.Test
    public void length() {
        assertEquals(3, abc6.length());

        Queue<String> length_queue = new ListQueue<>(4  );
        assertEquals(0, length_queue.length());

        length_queue.enqueue("A");
        length_queue.enqueue("B");
        length_queue.enqueue("C");
        length_queue.enqueue("D");
        assertEquals(4, length_queue.length());
        length_queue.dequeue();
        assertEquals(3, length_queue.length());
    }

    @org.junit.Test
    public void newInstance() {
        Queue<String> newInstancequeue = abc6.newInstance();
        assertTrue(newInstancequeue instanceof ListQueue<String>);
        assertEquals(6, newInstancequeue.capacity());
        assertEquals(0, newInstancequeue.length());
    }

    @org.junit.Test
    public void clear() {
        assertEquals(3, abc6.length());
        abc6.clear();
        assertEquals(0, abc6.length());
        assertEquals(6, abc6.capacity());
        assertEquals("[]:6", abc6.toString());
    }

    @org.junit.Test
    public void iterator() {
        Iterator<String> iterator = abc6.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
        String result = "";
        for (String s : abc6) {
            result += s;
        }
        assertEquals("ABC", result);
    }


    @org.junit.Test
    public void appendAll() {
        Queue<String> temp_queue = new ListQueue<>(3);
        temp_queue.enqueue("D");
        temp_queue.enqueue("E");
        temp_queue.enqueue("F");
        assertEquals(3, temp_queue.length());
        assertEquals(3, abc6.length());
        abc6.appendAll(temp_queue);
        assertEquals(6, abc6.length());
        assertEquals(0, temp_queue.length());
    }

    @org.junit.Test
    public void copy() {
        Queue<String> copy = abc6.copy();
        assertEquals(copy.length(), abc6.length());
        assertEquals(copy.capacity(), abc6.capacity());
        assertEquals("A", copy.dequeue());
        assertEquals("B", copy.dequeue());
    }

    @org.junit.Test
    public void testABCEqualsNUll() {
        Queue<String> q = null;
        assertFalse(abc6.equals(q));
    }

    @org.junit.Test
    public void testABCEqualsSelf() {
        assertTrue(abc6.equals(abc6));
    }

    @org.junit.Test
    public void testABC6EqualsForObjectABC6() {
        Queue<String> ABC6 = new ListQueue<>(6);
        ABC6.enqueue("A");
        ABC6.enqueue("B");
        ABC6.enqueue("C");
        assertTrue(abc6.equals(ABC6));
    }

    @org.junit.Test
    public void testABC6EqualsForObjectAB6() {
        Queue<String> ab6 = new ListQueue<>(6);
        ab6.enqueue("A");
        ab6.enqueue("B");
        assertFalse(abc6.equals(ab6));
    }

    @org.junit.Test
    public void testEmpty3EqualsForDifferentEmpty() {
        Queue<String> empty3 = new ListQueue<>(3);
        Queue<String> empty3_dup = new ListQueue<>(3);
        assertTrue(empty3.equals(empty3_dup));
    }

    @org.junit.Test
    public void testtoString() {
        assertNotEquals("[A, B, C]:6", abc6);
    }

    @org.junit.Test
    public void toStringEmpty() {
        Queue<String> queue_3 = new ListQueue<>(3);
        assertEquals("[]:3", queue_3.toString());
    }

    @org.junit.Test
    public void isEmpty() {
        assertFalse(abc6.isEmpty());
        Queue<String> queue1 = new ListQueue<>(1);
        assertTrue(queue1.isEmpty());
    }

    @org.junit.Test
    public void isFull() {
        assertFalse(abc6.isFull());
        Queue<String> a1 = new ListQueue<>(1);
        a1.enqueue("A");
        assertTrue(a1.isFull());
    }

    @org.junit.Test(expected = IllegalStateException.class)
    public void testIllegalStateException() {
        Queue<String> a1 = new ListQueue<>(1);
        a1.enqueue("A");
        a1.enqueue("B");
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() {
        Queue<String> queue_6 = new ListQueue<>(6);
        queue_6.enqueue(null);
    }

    @org.junit.Test
    public void testDifferentABCD6() {
        Queue<String> abcd6 = new ListQueue<>(6);
        abcd6.enqueue("A");
        abcd6.enqueue("B");
        abcd6.enqueue("C");
        abcd6.enqueue("D");

        abc6.enqueue("D");

        assertEquals(6, abcd6.capacity());
        assertEquals(4, abcd6.length());

        assertEquals(abc6.hashCode(), abcd6.hashCode());

        assertTrue(abc6.equals(abcd6));

        assertEquals(abc6, abcd6);
    }
}