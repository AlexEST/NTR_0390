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
public class SquareProbingHashTable extends LinearProbingHashTable{

    public SquareProbingHashTable(int size) {
        super(size);
    }
    
    /**
     * От линейного пробирования квадратичное отличается только способом вставки.
     * Поэтому переопределим этот метод.
     * При квадратичном пробировании смещение x равно квадрату номера шага.
     * 
     * @param item 
     */
    @Override
    public void insert(DataItem item) {
        if (isFull() == true) {
            System.out.println("The number didn't add. HashTable is FULL!");
            return;
        }
        int key = item.getKey();
        int hashVal = hashFunc(key);

        int i = 1;
        while (hashArray[hashVal] != null
                && hashArray[hashVal].getKey() != -1) {
            hashVal += i * i; // шаг для поиска новой ячейки
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }
}
