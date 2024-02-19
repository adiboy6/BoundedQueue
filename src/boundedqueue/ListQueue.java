package boundedqueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListQueue<E> extends AbstractQueue<E>{

    List<E> list;

    public ListQueue(int max) {
        super(max);
        list = new ArrayList<>();
    }

    @Override
    public void enqueue(E element) {
        if (element == null) throw new IllegalArgumentException();
        if (this.isFull()) throw new IllegalStateException();
        list.add(element);
    }

    @Override
    public E dequeue() {
        if (this.isEmpty()) throw new IllegalStateException();
        return list.removeFirst();
    }

    @Override
    public int length() {
        return list.size();
    }

    @Override
    public Queue<E> newInstance() {
        return new ListQueue<>(capacity());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
