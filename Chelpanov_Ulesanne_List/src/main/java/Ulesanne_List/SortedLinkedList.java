package Ulesanne_List;

import linkedlist.Node;


/**
 *
 * @author Alexander Chelpanov 182730EDTR 
 * @author Robert Lafore
 * Date: 21.02.2021
 *
 */
class SortedLinkedList {

    private Node first;

    public SortedLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }
    
    /**
     * Вставка.
     * Сложность: O(n)
     * @param key 
     */
    public void insert(int key) {
        Node newLink = new Node(key);
        Node previous = null;
        Node current = first;
        // until end of list,
        while (current != null && key > current.data) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current;
    }
    
    /**
     * Удаление.
     * Сложность: O(n)
     * @return 
     */
    public Node remove() {
        Node temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("Numbers in list: ");
        Node current = first;
        while (current != null) {
            System.out.print(current.toString()+" ");
            current = current.next;
        }
        System.out.println("");
    }
}



