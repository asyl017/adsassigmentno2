package list;

import java.util.Iterator;

public class MyLinkedList<T extends Object & Comparable<T>> implements MyList<T> {
    private Node<T> head;
    private int size;
    private Node<T> tail;

    /**
     * Constructs an empty MyLinkedList.
     */

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> previous;

        public Node(T item) {
            this.item = item;
            previous = null;
            next = null;
        }

        public Node(T item, Node<T> next, Node<T> previous) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }

    /**
     * Constructs an empty MyLinkedList.
     */
    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param item the element to be appended to this list
     */
    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;

    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index the index of the element to replace
     * @param item  the element to be stored at the specified position
     */

    @Override
    public void set(int index, T item) {
        Node<T> node = head;
        while (index-- != 0 && node.next != null)
            node = node.next;
        node.item = item;
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
     * Inserts the specified element at the specified position in this list.
     *
     * @param index the index at which the specified element is to be inserted
     * @param item  the element to be inserted
     */
    @Override
    public void add(int index, T item) {
        if (head == null || index == size) {
            add(item);
            return;
        }
        checkIndex(index);

        size++;
        Node<T> node = getNodeAt(index + 1);

        Node<T> newNode = new Node<>(item, node.previous, node);
        if (node.previous != null)
            node.previous.next = newNode;
        node.previous = newNode;
        if (newNode.previous == null)
            head = newNode;
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
        add(item);
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
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     */
    @Override
    public T getFirst() {
        return get(0);
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     */
    @Override
    public T getLast() {
        return getLastNode().item;
    }

    private Node<T> getLastNode() {
        Node<T> node = head;
        while (node.next != null)
            node = node.next;
        return node;
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
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
     */
    @Override
    public void sort() {
        boolean swapped;
        Node<T> node;
        if (head == null)
            return;
        do {
            swapped = false;
            node = head;

            while (node.next != null) {
                if (node.item.compareTo(node.next.item) > 0) {
                    T t = node.next.item;
                    node.next.item = node.item;
                    node.item = t;
                    swapped = true;
                }
                node = node.next;
            }
        }
        while (swapped);
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
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.item.equals(item))
                return i;
            node = node.next;
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
        return indexOf(item) != -1;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Object[] toArray() {
        T[] array = (T[]) new Object[size];
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            array[i] = node.item;
            node = node.next;
        }
        return array;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        Node<T> front;

        public Iter() {
            front = head;
        }

        public boolean hasNext() {
            return front != null;
        }

        public T next() {
            Node<T> node = front;
            front = front.next;
            return node.item;
        }
    }

    private Node<T> getNodeAt(int index) {
        checkIndex(index);
        Node<T> node = head;
        if (node == null)
            return null;
        while (--index != 0 && node.next != null)
            node = node.next;
        return node;
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<T> h = head;
        while (h != null) {
            str.append(h.item).append(" ");
            h = h.next;
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }

}
