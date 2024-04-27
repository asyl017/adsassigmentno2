package dataTypes;

import list.MyList;

public class Stack<T extends Comparable<T>> implements DataType<T> {

    /**
     * This linked list used as the underlying data structure for the stack.
     */
    private final MyList<T> list;

    /**
     * It constructs a Stack with the specified linked list.
     *
     * @param list The linked list to be used as the underlying data structure for the stack.
     */
    public Stack(MyList<T> list) {
        this.list = list;
    }

    /**
     * This method pushes an element onto the top of the stack.
     *
     * @param t The element to be pushed onto the stack.
     */
    @Override
    public void enqueue(T t) {
        list.addFirst(t);
    }

    /**
     * This method extracts and returns the element from the top of the stack.
     *
     * @return The element extracted from the top of the stack.
     */
    @Override
    public T dequeue() {
        T t = list.getLast();
        list.removeLast();
        return t;
    }

    /**
     * This method returns the element from the top of the stack without removing it.
     *
     * @return The element from the top of the stack.
     */
    @Override
    public T getList() {
        return list.getLast();
    }

    /**
     * This method returns the size of the stack.
     *
     * @return The number of elements in the stack.
     */
    @Override
    public int getSize() {
        return list.size();
    }
}