/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

import Ulesanne_Hashtable.Main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author Alexander Chelpanov
 * @author Robert Lafore
 * Date: 02.03.2021
 * 
 * Многое из учебника по алгоритмам и структурам данных Роберта Лафоре. Переделано как мне удобнее.
 * 
 * 
 */
public class TableApp {
    public static final Random RAND = new Random();
    
    public static LinearProbingHashTable createLinearProbingTable() throws IOException{
        LinearProbingHashTable lpTable = new LinearProbingHashTable(500); // массив с размером в 500
        for (int i = 0; i < lpTable.arraySize; i++) { // вставляем 500 случайных чисел в диапазоне от нуля до 1000
            DataItem item = new DataItem(RAND.nextInt(1000));
            lpTable.insert(item);
        }
        return lpTable;
    }
    
    public static SquareProbingHashTable createSquareProbingTable(){
        SquareProbingHashTable spTable = new SquareProbingHashTable(500); 
        for (int i = 0; i < spTable.arraySize; i++) { 
            DataItem item = new DataItem(RAND.nextInt(1000));
            spTable.insert(item);
        }
        return spTable;
    }
    
    public static DoubleHashTable createDoubleHashingTable(){
        DoubleHashTable dTable = new DoubleHashTable(500); 
        for (int i = 0; i < dTable.arraySize; i++) { 
            DataItem item = new DataItem(RAND.nextInt(1000));
            dTable.insert(item);
        }
        return dTable;
    }
    
    public static void interactWithUser(int marker) throws IOException, InterruptedException{
        LinearProbingHashTable Table =  createLinearProbingTable();
        switch (marker) {
            case 2:
                Table = createSquareProbingTable();
                break;
            case 3:
                Table = createDoubleHashingTable();
                break;
            default:
                break;
        }
        DataItem aDataItem;
        int aKey;
    
        while (true) // interact with user
        {
            System.out.println("Enter first letter of show, insert, delete, find or quit (back to the Menu): ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    Table.displayTable();
                    break;
                case 'i':
                    System.out.println("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
                    Table.insert(aDataItem);
                    break;
                case 'd':
                    System.out.println("Enter key value to delete: ");
                    aKey = getInt();
                    Table.delete(aKey);
                    break;
                case 'f':
                    System.out.println("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = Table.find(aKey);
                    if (aDataItem != null) {
                        System.out.println("Found " + aKey);
                    } else {
                        System.out.println("Could not find " + aKey);
                    }
                    break;
                case 'q':
                    System.out.println("Enter key value to quit to the menu. ");
                    Main.Menu();
                    
                    break;    
                default:
                    System.out.println("Invalid entry\n");
            }  
        }  
    }
    
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
