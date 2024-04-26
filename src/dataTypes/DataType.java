package dataTypes;

public interface DataType<E> {
    void push(E e);

    E pop();

    E get();

    int size();

}
