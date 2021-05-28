package Ulesanne_List;


import linkedlist.LinkedList;
import linkedlist.Node;
/**
 * 
 * @author Alexander Chelpanov
 * @author Robert Lafore
 * Date: 21.02.2021
 * 
 */
class LinkedListQueue {

    private LinkedList theList;

    public LinkedListQueue() {
        theList = new LinkedList();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void insert(int j) {
        theList.addLast(j);
    }

    public Node remove() {
        return theList.deleteFirst();
    }

    public void displayQueue() {
        System.out.print("Queue: ");
        theList.displayList();
    }

}

