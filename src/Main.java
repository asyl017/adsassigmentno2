import list.MyArrayList;
import list.MyLinkedList;
import list.MyList;

public class Main {
    public static void main(String[] args) {
        /*
        MyArrayList test
        */
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
        arrayList.removeFirst();
        arrayList.addLast(3);
        arrayList.removeLast();
        System.out.println(arrayList.size());
        arrayList.set(0, 5);
        arrayList.printArr();
        System.out.println(arrayList.indexOf(5));
        arrayList.toArray();
        System.out.println(arrayList.exist(9));

        /*
        MyLinkedList test
        */
        MyList linkedList = new MyLinkedList<>();
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(12);
        linkedList.add(3);
        linkedList.add(21);
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.add(0, 3);
        linkedList.addLast(4);
        linkedList.remove(0);
        linkedList.addFirst(12);
        linkedList.set(3, 22);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.getFirst());
        linkedList.addFirst(2);
        linkedList.size();
        linkedList.indexOf(12);
        linkedList.iterator();
        linkedList.exist(21);

        System.out.println(linkedList.toString());
    }
}
