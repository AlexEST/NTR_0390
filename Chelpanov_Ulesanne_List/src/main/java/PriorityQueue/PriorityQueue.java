/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriorityQueue;

import linkedlist.Node;

/**
 *
 * @author Alexander Chelpanov 182730EDTR
 * Date: 22.02.2021
 * 
 * 
 */
public class PriorityQueue {
    ClientLinkedList sortList;

    public PriorityQueue() {
        sortList = new ClientLinkedList();
    }

    public void insert(Client c) {
        sortList.insert(c);
    }

    public Client delete() {
        return sortList.remove();
    }

    public void display() {
        sortList.displayList();
    }
}
