/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ulesanne_Hashtable;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Alexander Chelpanov 182730EDTR 
 * Date: 27.02.2021
 * 
 *
 * 1. Task 1 Create array consisting of 500 integers, which are randomly
 * generated in the range from 0 to 1000
 * Hashtable. Collisions solving is via open addressing – see tables
 * 1. linear probing
 * 2. square probing
 * 3. double hashing
 *
 * Realise methods: insert, delete, find
 *
 * Carry out comparative analysis. What are the differences in the rates of
 * methods execution ? (add comments or text file)
 *
 * 2. Text processing The set of words is available (the words are in the text
 * file The_Last_of_the_Mohicans-James_Fenimore_Cooper.txt), where the words are
 * separated between each other by spaces, commas, full stops etc.
 *
 * Use HashTable, Set (java.util) 1. Rate of occurrence dictionary – how many
 * different words are in the text. When reading the words case is not taken
 * into consideration. Print: word and how many times 2. Print how many words
 * begin with each letter 3. List of unique words (words appear only once) in
 * the alphabet order
 *
 * Write what is method hashCode in the class Object. When method is necessary
 * to realize in its class? Create examples (task Software, subject OOP)
 *
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Menu();
    }
    
    public static void Menu() throws InterruptedException, IOException  {
        System.out.println("=========================================");
        System.out.println("|                MENU                    |");
        System.out.println("=========================================");
        System.out.println("|Chapters:                               |");
        System.out.println("|1.Linear probing                        |");
        System.out.println("|2.Square probing                        |"); 
        System.out.println("|3.Double hashing                        |");
        System.out.println("|           TEXT PROCESSING              |");
        System.out.println("|4.Words and their count                 |");
        System.out.println("|5.Count of words begin with each letter |");
        System.out.println("|6.Unique words in text                  |");
        System.out.println("|7.Count of words in text                |");
        System.out.println("|8.EXIT                                  |");
        System.out.println("=========================================");
        System.out.println("");
        System.out.println("Choose chapter and push Enter:");
        try {
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            while (true) {
                switch (choice) {
                    case 1:
                        System.out.println("Linear probing.");
                        HashTable.TableApp.interactWithUser(1);
                        whatNext();
                        break;
                    case 2:
                        System.out.println("Square probing. ");
                        HashTable.TableApp.interactWithUser(2);
                        whatNext();
                        break;
                    case 3:
                        System.out.println("Double probing");
                        HashTable.TableApp.interactWithUser(3);         
                        whatNext();
                        break;
                    case 4:
                        System.out.println("Printing words and their count from text.");
                        for (Map.Entry word : DictionaryDAO.hashList.entrySet()) {
                            System.out.printf("Word: %-10s Count: %-3s%n", word.getKey().toString().toUpperCase(),  word.getValue());
                        }
                        System.out.println("");                      
                        whatNext();
                        break;
                    case 5:
                        System.out.println("Printing count of words begin with each letter.");
                        TreeMap<Character, Integer> sortedLetters = new TreeMap<>();
                        DictionaryDAO.hashList.entrySet().stream().map((word) -> word.getKey().charAt(0)).forEachOrdered((letter) -> {
                            if (sortedLetters.containsKey(letter)) {
                                sortedLetters.put(letter, sortedLetters.get(letter) + 1);
                            } else {
                                sortedLetters.put(letter, 1);
                            }
                        });
                        for (Map.Entry<Character, Integer> letter : sortedLetters.entrySet()) {
                            System.out.printf("Letter: %-1s Count: %-3s%n", letter.getKey().toString().toUpperCase(),letter.getValue());
                        }
                        System.out.println(""); 
                        whatNext();
                        break;                
                    case 6:
                        System.out.println("Printing unique words from text: ");
                        for (Map.Entry word : DictionaryDAO.hashList.entrySet()) {
                            if (word.getValue().equals(1)) {
                                System.out.printf("Word: %-10s Count: %-3s%n", word.getKey().toString().toUpperCase(), word.getValue());
                            }

                        }
                        System.out.println(""); 
                        whatNext();
                        break;
                    case 7:
                        System.out.println("Count of words in text (without date).");
                        System.out.println(DictionaryDAO.hashList.size());
                        whatNext();
                        break;        
                    case 8:                       
                        System.out.println("End of programm.");
                        System.exit(0);    
                    default:
                        System.out.println("Wrong choice! You must enter a "
                                + "number from 1 to 8! 8 is the exit from the program.");
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
    
    private static void whatNext() throws InterruptedException, IOException {
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
