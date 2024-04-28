import dataTypes.MinHeap;
import dataTypes.Queue;
import dataTypes.Stack;
import list.MyArrayList;
import list.MyLinkedList;
import list.MyList;

public class Main {
    public static void main(String[] args) {
        /**
         MyArrayList test
         **/
        MyArrayList arrayList = new MyArrayList();
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(9);
        System.out.println("First element of array list:" + arrayList.getFirst());
        System.out.println("Last element of array list:" + arrayList.getLast());
        arrayList.remove(1);
        System.out.print("Array list after remove");
        arrayList.printArr();
        arrayList.addFirst(4);
        System.out.print("Array list after adding first element");
        arrayList.printArr();
        arrayList.removeFirst();
        System.out.print("Array list after removing first element");
        arrayList.printArr();
        arrayList.addLast(3);
        System.out.print("Array list after adding last element");
        arrayList.printArr();
        System.out.print("Array list after adding last element");
        arrayList.removeLast();
        arrayList.printArr();
        System.out.println("Size of array list:" + arrayList.size());
        System.out.print("Array list after setting certain element to certain index");
        arrayList.set(0, 5);
        arrayList.printArr();
        System.out.println("Index of element 5 in array list:" + arrayList.indexOf(5));
        arrayList.toArray();
        System.out.println("Does the certain element exist:" + arrayList.exist(9));

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
        System.out.println("First element of array list:" + linkedList.getFirst());
        System.out.println("Last element of array list:" + linkedList.getLast());
        System.out.print("Linked list after removing first element");
        linkedList.removeFirst();
        System.out.print("Linked list after removing last element");
        linkedList.removeLast();
        System.out.println(linkedList.toString());
        linkedList.add(0, 3);
        System.out.print("Linked list after adding last element");
        linkedList.addLast(4);
        System.out.println(linkedList.toString());
        System.out.print("Linked list after removing element with certain index");
        linkedList.remove(2);
        System.out.print("Linked list after adding first element");
        linkedList.addFirst(12);
        System.out.println(linkedList.toString());
        System.out.print("Linked list after setting certain element to certain index");
        linkedList.set(3, 22);
        System.out.println(linkedList.toString());
        System.out.println("Element of linked list with index 0" + linkedList.get(3));
        System.out.println("First element of linked list" + linkedList.getFirst());
        System.out.println("Size of linked list" + linkedList.size());
        System.out.println("Index of value 12" + linkedList.indexOf(12));
        linkedList.iterator();
        System.out.println("Does the certain element exist:" + linkedList.exist(21));
        System.out.println(linkedList.toString());


        /**
         *  Test with LinkedList
         **/
        System.out.println("Testing with LinkedList:");
        MyLinkedList newLinkedList = new MyLinkedList();
        MinHeap minHeapLinkedList = new MinHeap(newLinkedList);
        Stack stackLinkedList = new Stack(newLinkedList);
        Queue queueLinkedList = new Queue(newLinkedList);

        minHeapLinkedList.insertAt(4);
        minHeapLinkedList.insertAt(2);
        minHeapLinkedList.insertAt(11);
        minHeapLinkedList.insertAt(23);
        System.out.println("Minimum element in MinHeap (LinkedList): " + minHeapLinkedList.getMinimium());

        stackLinkedList.enqueue(4);
        stackLinkedList.enqueue(12);
        stackLinkedList.enqueue(33);
        System.out.println("Element at the top of the stack (LinkedList): " + stackLinkedList.getList());

        queueLinkedList.enqueue(111);
        queueLinkedList.enqueue(221);
        queueLinkedList.enqueue(111444);
        System.out.println("Element at the front of the queue (LinkedList): " + queueLinkedList.getList());

        /**
         * Test with ArrayList
         **/
        System.out.println("\nTesting with ArrayList:");
        MyArrayList newArrayList = new MyArrayList();
        MinHeap minHeapArrayList = new MinHeap(newArrayList);
        Stack stackArrayList = new Stack(newArrayList);
        Queue queueArrayList = new Queue(newArrayList);
        minHeapArrayList.insertAt(5);
        minHeapArrayList.insertAt(3);
        minHeapArrayList.insertAt(8);
        minHeapArrayList.insertAt(1);
        System.out.println("Minimum element in MinHeap (ArrayList): " + minHeapArrayList.getMinimium());

        stackArrayList.enqueue(4);
        stackArrayList.enqueue(21);
        stackArrayList.enqueue(32);
        System.out.println("Element at the top of the stack (ArrayList): " + stackArrayList.getList());

        queueArrayList.enqueue(132);
        queueArrayList.enqueue(234);
        queueArrayList.enqueue(356);
        System.out.println("Element at the front of the queue (ArrayList): " + queueArrayList.getList());
    }
}
}
