package boundedqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircArrayQueue<E> extends AbstractQueue<E>{
    private final E[] elements;
    private int first;
    private int last;
    public CircArrayQueue(int capacity) {
        super(capacity);
        elements = (E[]) new Object[capacity];
        first = -1;
        last = -1;
    }

    @Override
    public void enqueue(E element) {
        if (element == null) throw new IllegalArgumentException("Value cannot be null");
        if (this.isFull()) throw new IllegalStateException("Queue is full");
        if (this.isEmpty()) {
            first = 0;
            last = 0;
        }
        else {
            last = (last + 1) % capacity();
        }
        elements[last] = element;
    }

    @Override
    public E dequeue() {
        if (this.isEmpty()) throw new IllegalStateException("Queue is empty");
        E firstElement = elements[first];
        if (first != last) {
            first = (first + 1) % capacity();
        } else {
            first = -1;
            last = -1;
        }
        return firstElement;
    }

    @Override
    public int length() {
        if(first < 0 ) return 0;
        return ((last - first + 1) % capacity() == 0)? capacity() : (last - first + 1) % capacity();
    }

    @Override
    public Queue<E> newInstance() {
        return new CircArrayQueue<>(capacity());
    }

    @Override
    public void clear() {
        first = -1;
        last = -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator<E>();
    }

    private class QueueIterator<E> implements Iterator<E> {
        private int index = first;
        private int currentIndex = 0;

        @Override
        public boolean hasNext(){ return currentIndex < length(); }

        @Override
        public E next() {
            if (!this.hasNext()) throw new NoSuchElementException("No more elements in the queue");
            E nextValue = (E) elements[index];
            currentIndex++;
            index = (index + 1) % capacity();
            return nextValue;
        }
    }
}
