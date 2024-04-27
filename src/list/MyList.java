package list;

public interface MyList<T> extends Iterable<T> {
    /**
     * Adds an element to the end of the list.
     *
     * @param element The element to be added.
     */
    void add(T element);

    /**
     * Sets the element at the specified index to the specified value.
     *
     * @param index The index of the element to be set.
     * @param item  The new value to set at the specified index.
     */
    void set(int index, T item);

    /**
     * Inserts the specified element at the specified position in the list.
     *
     * @param index The index at which the specified element is to be inserted.
     * @param item  The element to be inserted.
     */
    void add(int index, T item);

    /**
     * Adds the given element to the beginning of the list.
     *
     * @param item The element to be added to the beginning of the list.
     */
    void addFirst(T item);

    /**
     * Adds the specified element to the end of the list.
     *
     * @param item The element to be added to the end of the list.
     */
    void addLast(T item);

    /**
     * Returns the element at the specified position in the list.
     *
     * @param index The index of the element to return.
     * @return The element at the specified position in the list.
     */
    T get(int index);

    /**
     * Returns the first element in the list.
     *
     * @return The first element in the list.
     */
    T getFirst();

    /**
     * Returns the last element in the list.
     *
     * @return The last element in the list.
     */
    T getLast();

    /**
     * Removes the element at the specified position in the list.
     *
     * @param index The index of the element to be removed.
     */
    void remove(int index);

    /**
     * Removes the first element from the list.
     */
    void removeFirst();

    /**
     * Removes the last element from the list.
     */
    void removeLast();

    /**
     * Sorts the elements of the list into their natural ordering.
     */
    void sort();

    /**
     * Returns the index of the first occurrence of the specified element in the list.
     *
     * @param item The element to search for.
     * @return The index of the first occurrence of the specified element in the list, or -1 if the element is not found.
     */
    int indexOf(T item);

    /**
     * Checks if the specified element exists in the list.
     *
     * @param item The element to check for existence.
     * @return True if the specified element exists in the list, otherwise false.
     */
    boolean exist(T item);

    /**
     * Returns an array containing all of the elements in the list in proper sequence.
     *
     * @return An array containing all of the elements in the list.
     */
    public Object[] toArray();

    /**
     * Removes all of the elements from the list.
     */
    void clear();

    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    int size();
}
