package dataTypes;

import list.MyList;

public class MinHeap<T extends Comparable<T>> {
    private final MyList<T> list;

    /**
     * It constructs a MinHeap with the specified list.
     *
     * @param list the list to be used as the underlying data structure for the MinHeap
     */
    public MinHeap(MyList<T> list) {
        this.list = list;
    }

    /**
     * This method inserts a new element into the MinHeap.
     *
     * @param t the element to be inserted
     */
    public void insertAt(T t) {
        list.addLast(t);
        heapifyAfterAddition(t, list.size() - 1);
    }

    /**
     * This method retrieves the minimum element from the MinHeap without removing it.
     *
     * @return the minimum element in the MinHeap
     */
    public T getMinimium() {
        return list.getFirst();
    }

    /**
     * This method removes and returns the minimum element from the MinHeap.
     *
     * @return the minimum element removed from the MinHeap
     */
    public T extractMinimum() {
        T min = list.getFirst();
        list.removeFirst();
        list.set(0, list.getLast());
        list.removeLast();
        heapifyAfterRemove(0);
        return min;
    }

    /**
     * This method decreases the value of a specific element in the MinHeap.
     */
    public void decrease(int index, T newValue) {
        if (list.get(index).compareTo(newValue) < 0) {
            throw new IllegalArgumentException("New value must be smaller than the current value.");
        }
        list.set(index, newValue);
        heapifyAfterDec(index);
    }


    /**
     * This method deletes the element at the specified index from the MinHeap.
     *
     * @param index the index of the element to be deleted
     */
    public void delete(int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        T lastElement = list.getLast();
        list.set(index, lastElement);
        list.removeLast();

        if (index == 0 || list.get(index / 2).compareTo(lastElement) < 0) {
            heapifyAfterRemove(index);
        } else {
            heapifyAfterDec(index);
        }
    }

    /**
     * This method adjusts the heap structure after removing an element from the heap at the specified index.
     *
     * @param index The index of the removed element.
     */
    private void heapifyAfterRemove(int index) {
        int leftChildIdx = (index + 1) * 2 - 1;
        int rightChildIdx = (index + 1) * 2;
        int go;
        if (leftChildIdx >= list.size()) {
            go = rightChildIdx;
        } else if (rightChildIdx >= list.size()) {
            go = leftChildIdx;
        } else {
            go = list.get(leftChildIdx).compareTo(list.get(rightChildIdx)) > 0 ? rightChildIdx : leftChildIdx;
            if (list.get(leftChildIdx).compareTo(list.get(rightChildIdx)) > 0) {
                T temp = list.get(go);
                list.set(go, list.get(index));
                list.set(index, temp);
                heapifyAfterRemove(go);
            }
        }
    }

    /**
     * This method adjusts the heap structure after adding an element to the heap at the specified index.
     *
     * @param t     The added element.
     * @param index The index where the element is added.
     */
    private void heapifyAfterAddition(T t, int index) {
        int parentIdx = index / 2;
        if (parentIdx >= 0 && list.get(parentIdx).compareTo(t) > 0) {
            T parentValue = list.get(parentIdx);
            list.set(parentIdx, t);
            list.set(index, parentValue);
            heapifyAfterAddition(t, parentIdx);

        }
    }

    /**
     * This method adjusts the heap structure after decreasing the value of an element in the heap at the specified index.
     *
     * @param index The index of the element whose value has decreased.
     */
    private void heapifyAfterDec(int index) {
        int parent = index / 2;
        if (parent >= 0 && list.get(parent).compareTo(list.get(index)) > 0) {
            T temp = list.get(parent);
            list.set(parent, list.get(index));
            list.set(index, temp);
            heapifyAfterDec(parent);
        }
    }
}

