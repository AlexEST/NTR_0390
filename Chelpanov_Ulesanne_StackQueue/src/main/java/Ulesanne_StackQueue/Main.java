/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ulesanne_StackQueue;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alexander Chelpanov 182730EDTR 
 * Date: 16.02.2021
 * 
 * Task_StackQueue
 * To solve the tasks create your own classes (MyStack, MyQueue) and classes 
 * java.util to find other solutions (methods signature should coincide, 
 * for example, MyStack -> Stack - empty(), peek(), pop(), push(E item)).
 * 
 * 1. The text is given (up to 15 points)
 * Print out the words and the same words in reverse
 * Check the sequence of brackets (matching, interleaving)
 * 
 * 2. Write a program, which models a queue of the buyers in the check-out 
 * of the shop (up to 15 points). There are N queues in the shop. 
 * Program should reflect the buyers of all queues. Servicing of each client 
 * depends upon the number of the products in the shopping cart 
 * (occasional number from 1 till 5, 1 shopping cart = 1 second). 
 * For example, divide 10 buyers into 3 queues. A buyer is added 
 * to the nearest queue.
 * After the queue has been completed, the products should be bought.
 * Each second - 1 product. If there are 0 products in the shopping cart – 
 * a buyer is removed from the queue.
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
        System.out.println("|1.Printing words                        |");
        System.out.println("|2.Check the sequence of brackets        |"); 
        System.out.println("|3.Queue in shop                         |"); 
        System.out.println("|4.EXIT                                  |");
        System.out.println("=========================================");
        System.out.println("");
        System.out.println("Choose chapter and push Enter:");
        try {
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            while (true) {
                switch (choice) {
                    case 1:
                        System.out.println("Printing words.");
                        System.out.println("Demonstration of reverse method for the strings: \"Sunshine\", "
                                + "\"Reverse string\", \"Tenet\" ");
                        List<String> list = new ArrayList<>();
                        list.add("Sunshine");
                        list.add("Reverse string");
                        list.add("TeneT");
                        for (String string : list) {
                            System.out.println(string+ " - "+ new Reverser(string).doRev());
                        }
                        whatNext();
                        break;
                    case 2:
                        System.out.println("Check the sequence of brackets: ");
                        System.out.println("Examples: ");
                        String brackets = "{}_[(--)]";//тут все правильно
                        String bracketsMiss = "{}_[(--]";//потеряна одна скобка
                        String bracketsWrongOrder = "{_[(--])_}";//неправильный порядок
                        System.out.println("First example: {}_[(--)] ");
                        BracketChecker example = new BracketChecker(brackets);
                        example.check();
                        System.out.println("Second example: {}_[(--]");
                        BracketChecker example1 = new BracketChecker(bracketsMiss);
                        example1.check();
                        System.out.println("Third example: {_[(--])_}");
                        BracketChecker example2 = new BracketChecker(bracketsWrongOrder);
                        example2.check();

                        whatNext();
                        break;
                    case 3:
                        System.out.println("Queue of the customers. ");
                        System.out.println("");
                        Shop.CheckoutApp.checkApp();
                        whatNext();
                        break;
                    case 4:
                        System.out.println("End of programm.");
                        System.exit(0);    
                    default:
                        System.out.println("Wrong choice! You must enter a "
                                + "number from 1 to 4! 4 is the exit from the program.");
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
