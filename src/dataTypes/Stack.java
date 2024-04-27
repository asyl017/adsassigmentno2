package dataTypes;

import list.MyList;

public class Stack<T extends Comparable<T>> implements DataType<T> {

    private final MyList<T> list;

    public Stack(MyList<T> list) {
        this.list = list;
    }

    @Override
    public void pushFirst(T t) {
        list.addFirst(t);
    }

    @Override
    public T pop() {
        T t = list.getLast();
        list.removeLast();
        return t;
    }

    @Override
    public T getList() {
        return list.getLast();
    }

    @Override
    public int getSize() {
        return list.size();
    }
}