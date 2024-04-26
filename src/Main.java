import list.MyArrayList;
import list.MyLinkedList;
import list.MyList;

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




        MyList linkedList = new MyLinkedList<>();
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(12);
        linkedList.add(3);
        linkedList.add(21);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList.exist(3));
        System.out.println(linkedList.toString());
    }
}
