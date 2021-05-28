package Ulesanne_List;

import linkedlist.LinkedList;
import linkedlist.Node;

/**
 * 
 * @author Alexander Chelpanov 182730EDTR
 * @author Robert Lafore
 * Date: 21.02.2021
 * 
 */

class LinkedListStack {

    private LinkedList theList;

    public LinkedListStack() {
        theList = new LinkedList();
    }

    public void push(int j) {
        theList.addFirst(j);
    }

    public Node pop() {
        return theList.deleteFirst();
    }

    public boolean isEmpty() {
        return (theList.isEmpty());
    }

    public void displayStack() {
        System.out.print("Stack: ");
        theList.displayList();
    }

}

