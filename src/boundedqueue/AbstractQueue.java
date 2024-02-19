package boundedqueue;

import java.util.Iterator;

public abstract class AbstractQueue<E> implements Queue<E>{
    private final int capacity;

    public AbstractQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return this.length() == 0;
    }

    @Override
    public boolean isFull() {
        return this.length() == this.capacity();
    }

    @Override
    public void appendAll(Queue<E> that) {
        if (that == null) throw new IllegalArgumentException();
        if (!that.isEmpty()) {
            this.enqueue(that.dequeue());
            appendAll(that);
        }
    }

    @Override
    public Queue<E> copy() {
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Queue)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Queue<?> that = (Queue) obj;
        if (this.capacity() != that.capacity()) {
            return false;
        }
        if (this.length() != that.length()) {
            return false;
        }
        Iterator<E> thisIter = this.iterator();
        Iterator<?> thatIter = that.iterator();
        while (thisIter.hasNext()) {
            E elem = thisIter.next();
            Object o = thatIter.next();
            if (!elem.equals(o)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int result = 17;
        for (E element : this) {
            result = 31 * result + element.hashCode();
        }
        result = 31 * result + capacity();
        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<E> iterator = this.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]:");
        sb.append(capacity());
        return sb.toString();
    }
}