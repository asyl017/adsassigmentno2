package dataTypes;

public interface DataType<E> {
    /**
     * Adds an element to the data structure.
     *
     * @param e The element to be added.
     */
    void enqueue(E e);

    /**
     * Removes and returns the element from the data structure.
     *
     * @return The element removed from the data structure.
     */
    E dequeue();

    /**
     * Returns an element from the data structure without removing it.
     *
     * @return An element from the data structure.
     */
    E getList();

    /**
     * Returns the size of the data structure.
     *
     * @return The number of elements in the data structure.
     */
    int getSize();

}
