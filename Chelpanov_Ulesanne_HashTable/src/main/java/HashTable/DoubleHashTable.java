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
 */
public class DoubleHashTable extends LinearProbingHashTable {
   
    public DoubleHashTable(int size) {
        super(size);
    }

    public int hashFunc2(int key) {
        // non-zero, less than array size, different from hF1
        // array size must be relatively prime to 5, 4, 3, and 2
        return 5 - key % 5;
    }
    
    /**
     * При двойном хешировании величина смещения зависит от ключа.
     * 
     * @param key
     * @param item 
     */
    public void insert(int key, DataItem item) {
        if (isFull() == true) {
            System.out.println("The number didn't add. HashTable is FULL!");
            return;
        }
        int hashVal = hashFunc(key);
        int stepSize = hashFunc2(key);
        // until empty cell or -1
        while (hashArray[hashVal] != null
                && hashArray[hashVal].getKey() != -1) {
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    /**
     * Сложность О(1)
     * @param key
     * @return 
     */
    @Override
    public DataItem delete(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    @Override
    public DataItem find(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }
}
