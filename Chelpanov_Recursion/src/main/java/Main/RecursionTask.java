/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import static Main.Combination.makeCombi;
import static Main.RecursiveSearch.indexOf;
import static Main.RecursiveSearch.lastIndexOf;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Alexander Chelpanov
 * Date: 09.02.2021
 * 
 * 1. Recursive search, that searches a string among the strings and brings 
 * back to the first position (index) - indexOf (Java), where string is located,
 * and another method brings back to the last position lastIndexOf (
 * not allowed to use String functions - substring, startWith.... )
 * 
 * 2. Combinations and teams selection. For example, 5 participants 
 * are available and it is necessary to compile all possible 3-member teams.
 * 
 * 
 */
public class RecursionTask {

    public static void main(String[] args) {
        Menu();
    }
    public static void Menu()  {
        System.out.println("=========================================");
        System.out.println("|                MENU                    |");
        System.out.println("=========================================");
        System.out.println("|Chapters:                               |");
        System.out.println("|1.Recursive search                      |");
        System.out.println("|2.Combinations and teams selection      |");       
        System.out.println("|3.EXIT                                  |");
        System.out.println("=========================================");
        System.out.println("");
        System.out.println("Choose chapter and push Enter:");
        try {
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            while (true) {
                switch (choice) {
                    case 1:
                        System.out.println("Recursive search.");
                        System.out.println("Demonstration of the algorithm:");
                        System.out.println("For example. Finding word \"For\" in string - "
                                + "\"Geeks For Geeks\"");
                        char[] text = "Geeks For Geeks".toCharArray();
                        char[] pat = "For".toCharArray();

                        System.out.println("First index is: "+indexOf(text, pat, 0, 0));
                        System.out.println("Last index is: "+lastIndexOf(text, pat, 0, 0));
                        whatNext();
                        break;
                    case 2:
                        System.out.println("Combinations and teams selection: ");
                        System.out.println("Demonstration of the algorithm:");
                        System.out.println("Count of available participants - 5. Maximum participant's count in team - 3.");
                        int participants = 5;
                        int teamSize = 3;
                        System.out.println("Combinations:");
                        makeCombi(participants, teamSize);
                        whatNext();
                        break;
                    case 3:
                        System.out.println("End of programm.");
                        System.exit(0);
                    default:
                        System.out.println("Wrong choice! You must enter a "
                                + "number from 1 to 3! 3 is the exit from the program.");
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
    
    private static void whatNext() {
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
