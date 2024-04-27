package dataTypes;

import list.MyList;

public class Queue<T extends Comparable<T>> implements DataType<T> {
    /**
     * The linked list used as the underlying data structure for the queue.
     */
    private final MyList<T> list;

    /**
     * Constructs a new queue with the specified linked list.
     *
     * @param list The linked list to be used as the underlying data structure for the queue.
     */
    public Queue(MyList<T> list) {
        this.list = list;
    }

    /**
     * Adds an element to the rear of the queue.
     *
     * @param t The element to be added to the rear of the queue.
     */
    @Override
    public void enqueue(T t) {
        list.addFirst(t);
    }

    /**
     * This method removes and returns the element from the front of the queue.
     *
     * @return The element removed from the front of the queue.
     */
    @Override
    public T dequeue() {
        T t = list.getLast();
        list.removeLast();
        return t;
    }

    /**
     * It returns the element from the front of the queue without removing it.
     *
     * @return The element from the front of the queue.
     */
    @Override
    public T getList() {
        return list.getLast();
    }

    /**
     * It returns the size of the queue.
     *
     * @return The number of elements in the queue.
     */
    @Override
    public int getSize() {
        return list.size();
    }
}
