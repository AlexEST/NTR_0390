
package linkedlist;

public class Node  {
    public int data;
    public Node next;
    public Node previous;
    
    public Node(int data) {
        this.data = data;
        //this.next=null;
    }

    @Override
    public String toString() {
        return "" + data ;
    }
    
}


