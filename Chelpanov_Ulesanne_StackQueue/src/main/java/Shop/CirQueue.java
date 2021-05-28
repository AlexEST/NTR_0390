/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shop;

import java.util.Arrays;

/**
 *
 * @author Alexander Chelpanov
 * Date: 15.02.2021
 * 
 * Циклическая очередь.
 * 
 */
public class CirQueue {

    private int max, rear, front;
    int[] a;
    int size;

    
    public CirQueue(int m) {
        max = m;
        size = 0;
        a = new int[m];
        rear = front = -1;
    }

    void insert(int val) {
        if (isFull()) {
            System.out.println("CUSTOMER CANNOT BE ADDED AS QUEUE IS FULL");
        } else {
            if (isEmpty()) {
                front = rear = 0;
                a[rear] = val;
            } else {
                rear = (rear + 1) % max;
                a[rear] = val;
            }
            size++;
        }
    }

    int size() {
        return size;
    }
    
    int getValue(int v){
        return a[v];
    }
    // сумма всех элементов в очереди
    int getSum(){
        return Arrays.stream(a).sum();
    }
    //уменьшение элемента в голове очереди
    void decFront(int rmv) {
        a[front] -= rmv;
        if (a[front] <= 0) {// если элемент становится меньше нуля тогда удаляем из очереди
            delete();
        }
    }

    void display() {
        if (!isEmpty()) {
            int i;
            for (i = front; i != rear; i = (i + 1) % max) {
                System.out.print(a[i] + " ");
            }
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    boolean isFull() {
        if (front == (rear + 1) % max) {
            return true;
        } else {
            return false;
        }
    }

    boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    // удаление элемента с головы (двигаем очередь)
    int delete() { 
        if (isEmpty()) {
            System.out.println("Underflow");
            return -1;
        } else {
            int temp = a[front];
            if (rear == front) {
                rear = -1;
                front = -1;
            } else {
                front = (front + 1) % max;
            }
            size--;
            return temp;
        }
    }
}
