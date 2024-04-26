package list;

public interface MyList<T> extends Iterable<T> {
    void add(T element);

    void set(int index, T item);

    void add(int index, T item);

    void addFirst(T item);

    void addLast(T item);

    T get(int index);

    T getFirst();

    T getLast();

    void remove(int index);

    void removeFirst();

    void removeLast();

    void sort();

    int indexOf(T item);

    boolean exist(T item);

    public Object[] toArray();

    void clear();

    int size();
}
