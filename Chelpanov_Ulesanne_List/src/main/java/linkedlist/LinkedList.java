package linkedlist;

import java.util.ArrayList;
/**
 * 
 * @author Alexander Chelpanov
 * @author Robert Lafore
 * Date: 21.02.2021
 * 
 * 
 */
public class LinkedList {
    
    private Node firstNode;
    private Node lastNode;

    public void LinkedList() {        
        firstNode = null;
        lastNode = null;
    }
    
    /**
     * Проверка списка на пустоту.
     * @return 
     */
    public boolean isEmpty() {         
        return (firstNode == null);
    }

    /**
     * Вставка в начало.
     * Сложность: О(1)
     * 
     * @param data 
     */
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            lastNode = newNode;//если список пустой
        } else {
            firstNode.previous = newNode;// если список не пустой 
        }
        newNode.next = firstNode;
        firstNode = newNode;
    }
    
    /**
     * Удаление последнего элемента
     * Сложность: O(1)
     * @return 
     */
    public Node removeLast() {
        Node temp = lastNode;
        if (firstNode.next == null) {
            firstNode = null;
        } else {
            lastNode.previous.next = null;
        }
        lastNode = lastNode.previous;
        return temp;
    }

    /**
     * Вставка последним.
     * Сложность: O(1)
     * @param dd 
     */
    public void addLast(int dd) {
        Node newLink = new Node(dd);
        if (isEmpty()) {
            firstNode = newLink;
        } else {
            lastNode.next = newLink;
            newLink.previous = lastNode;
        }
        lastNode = newLink;
    }
    
    /**
     * Вставка после определенного элемента
     * Сложность: O(n)
     * @param key
     * @param dd
     * @return 
     */
    public boolean addAfterKey(int key, int dd) {
        Node current = firstNode;
        while (current.data != key) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        Node newLink = new Node(dd);

        if (current == lastNode) {
            newLink.next = null;
            lastNode = newLink;
        } else {
            newLink.next = current.next;

            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }
    
    /**
     * Удаление  первого элемента.
     * Сложность: O(1)
     * @return 
     */
    public Node deleteFirst() {
        Node temp = firstNode;
        if (firstNode.next == null) {
            lastNode = null;
        } else {
            firstNode.next.previous = null;
        }
        firstNode = firstNode.next;
        return temp;
    }

    public void displayList() {
        Node current = firstNode;
        //System.out.print("Elements in linked list:");
        while (current != null) {
            System.out.print(current+" ");
            //System.out.println("Next element: " + current.next);
            //System.out.println("");
            current = current.next;
        }
        System.out.println("");
    }

    /**
     * Возвращает первый элемент.
     * Сложность: O(1)
     * @return 
     */
    public Node getFirst() {
        return firstNode;
    }
    
    /**
     * Возвращает последный элемент
     * Сложность: O(1)
     * @return 
     */
    public Node getLast() {
        
        return lastNode;
    }

    /**
     * Получение элемента по индексу.
     * Сложность: O(n)
     * @param key
     * @return 
     */
    public Node get(int key) {
        Node current = firstNode;              
        if (!isEmpty()) {
            while (current.data != key) {       
                if (current.next == null) 
                {
                    return null;                         
                } else             
                {
                    current = current.next;      
                }
            }
        } else {
            System.out.println("LinkedList is empty");
        }
        return current;                        
    }
    
    /**
     * Удаление элемента по индексу.
     * Сложность: O(n)
     * @param key
     * @return 
     */
    public Node delete(int key) {
        Node current = firstNode;
        while (current.data != key) {// ищем элемент если нет возвращем null
            current = current.next;
            if (current == null) {
                return null;
            }
        }
        if (current == firstNode) { //если первый элемент 
            firstNode = current.next;// первым делаем следующий элемент
        } else {
            current.previous.next = current.next;// ставим у предыдущего элемента следующим тот элемент который идет после найденного
        }

        if (current == lastNode) {// если найденный элемент последний
            lastNode = current.previous;// последним делаем предыдущий элемент
        } else {
            current.next.previous = current.previous; // ставим у следующего элемента предыдущим предыдущий элемент найденого
        }
        return current;
    }
    
    /**
     * Копирование в массив с начала определенного элемента.
     * Сложность: O(n)
     * @param key
     * @return 
     */
    public Integer [] copyToArray(int key) {
        Node current = firstNode;
        ArrayList<Integer> list = new ArrayList<>();

        while (current != null) {//пока список не пуст ищем
            current = current.next;
            if (current.data == key) {// если нашли нужный элемент копируем начиная с него
                while (current != null) {
                    list.add(current.data);
                    current = current.next;
                }
            }
        }
        Integer [] arr = new Integer[list.size()];
        return list.toArray(arr);
    }
}
