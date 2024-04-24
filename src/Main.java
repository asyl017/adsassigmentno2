import list.MyArrayList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(9);
        System.out.println(arrayList.getFirst());
        System.out.println(arrayList.getLast());
        arrayList.remove(1);
        arrayList.printArr();
        arrayList.addFirst(4);
        arrayList.printArr();
        arrayList.set(0,5);
        arrayList.printArr();
        System.out.println(arrayList.indexOf(5));
       arrayList.toArray();
        System.out.println(arrayList.exist(9));
    }
}
