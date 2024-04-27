package dataTypes;

public interface DataType<E> {
    void pushFirst(E e);

    E pop();

    E getList();

    int getSize();

}
