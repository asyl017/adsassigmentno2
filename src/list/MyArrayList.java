package list;

import java.util.Iterator;

public class MyArrayList<T extends Object & Comparable<T>> implements MyList<T> {

    private T[] arr;
    private int size;

    /**
     * Constructs an empty MyArrayList with an initial capacity of 5.
     */
    public MyArrayList() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element the element to be appended to this list
     */
    @Override
    public void add(T element) {
        if (size >= arr.length) {
            increaseBuffer();
        }
        arr[size++] = element;
    }

    /**
     * Increases the capacity of the array.
     */
    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    /**
     * Checks whether the given index is within the bounds of the list.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index  not correct");
        }
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index the index of the element to replace
     * @param item  the element to be stored at the specified position
     * @throws ArrayIndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException("Index not correct");
        T old = arr[index];
        arr[index] = item;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index the index at which the specified element is to be inserted
     * @param item  the element to be inserted
     */
    @Override
    public void add(int index, T item) {
        if (size >= arr.length) {
            increaseBuffer();
        }
        checkIndex(index);
        arr[index] = item;
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param item the element to be inserted at the beginning of this list
     */
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param item the element to be appended to this list
     */
    @Override
    public void addLast(T item) {
        add(size - 1, item);
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     */

    @Override
    public T getFirst() {
        return arr[0];
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     */
    @Override
    public T getLast() {
        return arr[size - 1];
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size--;
    }

    /**
     * Removes the first element from this list.
     */
    @Override
    public void removeFirst() {
        remove(0);
    }

    /**
     * Removes the last element from this list.
     */
    @Override
    public void removeLast() {
        remove(size - 1);
    }

    /**
     * Sorts the elements of this list into ascending order, according to their natural ordering.
     * The sorting is performed using the bubble sort algorithm.
     * Time cimplexity:quadratic time O(n^2).
     */
    @Override
    public void sort() {
        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++)
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    swapped = true;
                }
            if (!swapped)
                break;
        }
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param item the element to search for
     * @return the index of the first occurrence of the element in this list,
     * or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(T item) {
        if (item == null) {
            for (int i = 0; i < size; i++)
                if (arr[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (item.equals(arr[i]))
                    return i;
        }
        return -1;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param item the element to search for
     * @return true if this list contains the element, otherwise false
     */
    @Override
    public boolean exist(T item) {
        return indexOf(item) >= 0;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence.
     *
     * @return an array containing all of the elements in this list in proper sequence
     */
    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(arr, 0, newArray, 0, size);
        return newArray;
    }

    /**
     * Removes all of the elements from this list.
     */
    @Override
    public void clear() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public Iterator<T> iterator() {
        return iterator();
    }

    /**
     * Prints the elements of this list to the standard output.
     */
    public void printArr() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
