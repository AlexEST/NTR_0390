/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ulesanne_List;

import java.util.InputMismatchException;
import java.util.Scanner;
import linkedlist.LinkedList;


/**
 *
 * @author Alexander Chelpanov 182730EDTR
 * Date: 24.02.2021
 * 
 * Task 1. LinkedList
 * 1. Make comments on programming сode Example_LinkedList (all files package linkedlist)
 * 2. Add:
 * Field – reference for the last element (class LinkedList)
 * Methods to add elements to the list at the end addLast, after the given 
 * element to the list addAfterKey (if a member is not found, 
 * then method resets false) LinkedList
 * Remove method at the end of the list removeLast
 * Method, that resets element of the list by the given index – get (int index)
 * Method, that copies the content of the list to the given array starting from 
 * the given index copyToArray
 * 3. Evaluate the complexnesses for all methods execution (O-big)
 * 
 * Task 2. Stack. Queue
 * If your student code is even, you should make the task Stack , 
 * if it is odd, then the task Queue.
 * Using linked list (LinkedList), create classes of Stack (Stack) or of 
 * queue (Queue). There are examples in the lectures, where arrays are used.
 * 
 * Task 3. SortedLinkedList
 * 1. Create sorted linked list by methods add, remove, display, find ... 
 * Compare methods efficiency (complexness) with normal linked list (task 1)
 * 2. Realize priority queue sorted on the basis of the linked list. 
 * Electronic queue for a bank. Data to be reflected: number, time for 
 * receiving a number, type of a client (Private, VIP), start and end time 
 * of servicing. Priority queue clients (Vip) are served out of the queue, 
 * if such clients are in the queue.
 * 
 * 
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Menu();
    }
    
    public static void Menu() throws InterruptedException  {
        System.out.println("=========================================");
        System.out.println("|                MENU                    |");
        System.out.println("=========================================");
        System.out.println("|Chapters:                               |");
        System.out.println("|1.Demonstation of LinkedList methods    |");
        System.out.println("|2.LinkedList Stack                      |"); 
        System.out.println("|3.LinkedList Queue                      |");
        System.out.println("|4.Sorted LinkedList                     |");
        System.out.println("|5.Priority Queue                        |");
        System.out.println("|6.EXIT                                  |");
        System.out.println("=========================================");
        System.out.println("");
        System.out.println("Choose chapter and push Enter:");
        try {
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            while (true) {
                switch (choice) {
                    case 1:
                        System.out.println("LinkedList methods.");
                        LinkedList linkedList = new LinkedList();
                        for (int i = 9; i > -1; i--) {
                            linkedList.addFirst(i+1);
                        }
                        System.out.print("For the next LinkedList which elements are: ");
                        linkedList.displayList();
                        System.out.println("Method getLast(): "+linkedList.getLast());
                        System.out.println("Method removeLast(): "+linkedList.removeLast());
                        System.out.print("After removing: ");
                        linkedList.displayList();
                        System.out.println("Method addAfterKey() element 10 after element 9: "+linkedList.addAfterKey(9, 10));
                        System.out.print("After adding element: ");
                        linkedList.displayList();
                        System.out.println("Method get() for element 3: "+linkedList.get(3));
                        System.out.println("Method copyToArray() starting from element 3.");
                        Integer [] arr = linkedList.copyToArray(3);
                        System.out.print("Printing array elements: ");
                        for (int i = 0; i < arr.length; i++) {
                            System.out.print(arr[i]+" ");
                        }
                        System.out.println("");
                        whatNext();
                        break;
                    case 2:
                        System.out.println("Stack from LinkedList: ");
                        LinkedListStack theStack = new LinkedListStack(); // make stack
                        System.out.println("Adding number 20 in stack.");
                        theStack.push(20);
                        System.out.println("Adding number 40 in stack.");
                        theStack.push(40);
                        System.out.println("Printing stack elements:");
                        theStack.displayStack();              // display stack
                        System.out.println("Adding number 60 and after number 80.");
                        theStack.push(60);                    // push items
                        theStack.push(80);
                        System.out.println("Printing stack elements:");
                        theStack.displayStack();              // display stack
                        System.out.println("Remove 2 times.");
                        theStack.pop();                       // pop items
                        theStack.pop();
                        System.out.println("Printing stack elements:");
                        theStack.displayStack();
                        whatNext();
                        break;
                    case 3:
                        System.out.println("Queue from LinkedList.");
                        LinkedListQueue theQueue = new LinkedListQueue();
                        System.out.println("Adding number 20 in queue.");
                        theQueue.insert(20);
                        System.out.println("Adding number 40 in queue.");                       
                        theQueue.insert(40);
                        System.out.println("Printing queue elements:");
                        theQueue.displayQueue();           
                        System.out.println("Adding number 60 and after number 80.");
                        theQueue.insert(60);                 
                        theQueue.insert(80);
                        System.out.println("Printing queue elements:");
                        theQueue.displayQueue();          
                        System.out.println("Remove 2 times.");
                        theQueue.remove();                 
                        theQueue.remove();
                        System.out.println("Printing queue elements:");
                        theQueue.displayQueue();           
                        whatNext();
                        break;
                    case 4:
                        System.out.println("Sorted LinkedList.");
                        SortedLinkedList theSortedList = new SortedLinkedList();
                        System.out.println("Adding number 20 and 40 in list.");
                        theSortedList.insert(20);    // insert 2 items
                        theSortedList.insert(40);
                        System.out.println("Printing list elements:");
                        theSortedList.displayList(); // display list
                        System.out.println("Adding numbers 10, 30, 50 in list.");
                        theSortedList.insert(10);    // insert 3 more items
                        theSortedList.insert(30);
                        theSortedList.insert(50);
                        System.out.println("Printing list elements:");
                        theSortedList.displayList(); // display list
                        System.out.println("Remove one element and print list:");
                        theSortedList.remove();      // remove an item

                        theSortedList.displayList(); // display list   
                        whatNext();
                        break;
                    case 5:
                        System.out.println("Priority QUEUE.");
                        System.out.println("");
                        PriorityQueue.PriorityQueueApp.priorityQueue();
                        
                        whatNext();
                        break;        
                    case 6:
                        System.out.println("End of programm.");
                        System.exit(0);    
                    default:
                        System.out.println("Wrong choice! You must enter a "
                                + "number from 1 to 6! 6 is the exit from the program.");
                        whatNext();
                        break;
                }
                break;
            }
        } catch (InputMismatchException е) {
            System.out.println("INPUT WRONG! Try again.");
            whatNext();
        }
    }
    
    private static void whatNext() throws InterruptedException {
        while (true) {
            System.out.println("If you want to end the program enter 1. "
                    + "If you want to return to the menu enter 2");
            Scanner choice = new Scanner(System.in);
            int input = choice.nextInt();
            switch (input) {
                case 2:
                    Menu();
                    break;
                case 1:
                    System.exit(0);
                default:
                    System.out.println("You entered an incorrect option!");
                    break;
            }
        }
    }
}
