/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

/**
 *
 * @author Alexander Chelpanov
 * @author Robert Lafore
 * Date: 01.03.2021
 * 
 * 
 */
public class LinearProbingHashTable {

    DataItem[] hashArray;
    int arraySize;
    DataItem nonItem;

    public LinearProbingHashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) {
                System.out.print(hashArray[j].getKey() + " ");
            } else {
                System.out.print("** ");
            }
        }
        System.out.println("");
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }
    
    public boolean isFull() {
        boolean isFull = false;
        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] == null) {
                break;
            }
            if (i == hashArray.length - 1 && hashArray[i] != null) {
                isFull = true;
            }
        }
        return isFull;
    }
    
    /**
     * При линейном пробировании если ячейка занята идет смещение на один элемент.
     * Сложность О(1)
     * @param item 
     */
    public void insert(DataItem item) {
        if (isFull() == true) {
            System.out.println("The number didn't add. HashTable is FULL!");
            return;
        }
        int key = item.getKey();
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null
                && hashArray[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }
    
    
    /**
     * Сложность О(1)
     * @param key
     * @return 
     */
    public DataItem delete(int key) {
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    /**
     * Сложность О(1)
     * @param key
     * @return 
     */
    public DataItem find(int key) {
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
}
