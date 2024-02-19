package boundedqueue;

/**
 * Implementation of this interface should feature a constructor with a single argument
 * that specifies the desired capacity and initializes an empty queue.
 * This capacity must be strictly greater than zero.
 * Iterating through the queue should follow a first-to-last order.
 * @author Aditya Reddy Sabbella
 * @param <E> the type of elements in this queue
 */
public interface Queue<E> extends Iterable<E> {

    /**
     * Adds the specified element to the end of this queue.
     * @param element the element to add
     * @throws IllegalArgumentException if the specified element is null
     * @throws IllegalStateException if this queue is full
     */
    void enqueue(E element) throws IllegalArgumentException, IllegalStateException;

    /**
     * Removes and returns the element at the front of this queue.
     * @return the element at the front of this queue
     */
    E dequeue();

    /**
     * Returns the number of elements in this queue.
     * @return the number of elements in this queue
     */
    int length();

    /**
     * Returns the capacity of this queue.
     * @return the capacity of this queue
     */
    int capacity();

    /**
     * Returns a new instance of this queue with the same capacity.
     * @return a new instance of this queue with the same capacity
     */
    Queue<E> newInstance();

    /**
     * Removes all elements from this queue.
     */
    void clear();

    /**
     * Checks whether this queue is empty.
     * @return true if this queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Checks whether this queue is full.
     * @return true if this queue is full, false otherwise
     */
    boolean isFull();

    /**
     * Appends all elements from the specified queue to the end of this queue.
     * @param that the queue whose elements are to be appended
     */
    void appendAll(Queue<E> that);

    /**
     * Returns a copy of this queue.
     * @return a copy of this queue
     */
    Queue<E> copy();
}