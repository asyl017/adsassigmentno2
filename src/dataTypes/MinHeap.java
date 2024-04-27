package dataTypes;

import list.MyList;

public class MinHeap<T extends Comparable<T>> {
    private final MyList<T> list;

    /**
     * Constructs a MinHeap with the specified list.
     *
     * @param list the list to be used as the underlying data structure for the MinHeap
     */
    public MinHeap(MyList<T> list) {
        this.list = list;
    }

    /**
     * Inserts a new element into the MinHeap.
     *
     * @param t the element to be inserted
     */
    public void insertAt(T t) {
        list.addLast(t);
        heapifyAddition(t, list.size() - 1);
    }

    /**
     * Retrieves the minimum element from the MinHeap without removing it.
     *
     * @return the minimum element in the MinHeap
     */
    public T getMinimium() {
        return list.getFirst();
    }

    /**
     * Removes and returns the minimum element from the MinHeap.
     *
     * @return the minimum element removed from the MinHeap
     */
    public T popMinimium() {
        T min = list.getFirst();
        list.removeFirst();
        list.set(0, list.getLast());
        list.removeLast();
        heapRemove(0);
        return min;
    }

    /**
     * Decreases the value of a specific element in the MinHeap.
     * (Not implemented in this version)
     */
    public void decrease() {

    }

    /**
     * Deletes the element at the specified index from the MinHeap.
     * (Not implemented in this version)
     *
     * @param index the index of the element to be deleted
     */
    public void delete(int index) {
    }

    private void heapRemove(int index) {
        int l = (index + 1) * 2 - 1;
        int r = (index + 1) * 2;
        int go;
        if (l >= list.size()) {
            go = r;
        } else if (r >= list.size()) {
            go = l;
        } else {
            go = list.get(l).compareTo(list.get(r)) > 0 ? r : l;
            if (list.get(l).compareTo(list.get(r)) > 0) {
                T t = list.get(go);
                list.set(go, list.get(index));
                list.set(index, t);
                heapRemove(go);
            }
        }
    }


    private void heapifyAddition(T t, int index) {
        int parent = index / 2;
        if (list.get(parent).compareTo(t) > 0) {
            T temp = list.get(parent);
            list.set(parent, t);
            list.set(index, temp);
            heapifyAddition(t, parent);
        }
    }
}
