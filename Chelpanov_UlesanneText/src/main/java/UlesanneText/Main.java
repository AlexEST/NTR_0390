/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UlesanneText;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Alexander Chelpanov
 * Date: 01.04.2021
 * 
 * Task 1
 * The dictionary of the words is given (EnglishDictionary.txt). 
 * Find the largest collection of similar ("invalid") words (use Soundex).
 * Create method, for example difference, which defines degree of similarity 
 * (for Soundex – method returns the numbers from 1 to 4, 4 – is the best matching). 
 * Determine the performance of the algorithm (time of working, number of 
 * words in a dictionary, average length of a word...)
 * 
 * Task 2
 * Text and dictionary of the words are given (The_Last_of_the_Mohicans-James_Fenimore_Cooper). 
 * Create software to check the text, for example as Check spelling and grammar 
 * in Microsoft Office. If there is no a word in the dictionary, 
 * then similar words are offered. User can replace a word in the text or add 
 * a new word to the dictionary. Use Damerau-Levenshtein Distance
 * 
 */
public class Main {

    public final static HashMap<String, HashSet<String>> dict = new HashMap<>();// храним для каждого слова множество похожих на него
    public final static HashMap<String, String> wordsCodes = new HashMap<>(); // слова с их кодом 
    public static long PERF_TIMER = 0; // таймер для подсчета времени создания кодов для всех слов
    
    
    public static void main(String[] args) throws InterruptedException, IOException {
        createMaps();//создаем мапы
        Menu();

    }

    public static void Menu() throws InterruptedException, IOException {
        System.out.println("=========================================");
        System.out.println("|                MENU                    |");
        System.out.println("=========================================");
        System.out.println("|Chapters:                               |");
        System.out.println("|1.Word with largest collection of       |");
        System.out.println("|  similar words in dictionary           |");
        System.out.println("|2.Count of words in dictionary          |");
        System.out.println("|3.Average length of words               |");
        System.out.println("|  Performance of Soundex                |");
        System.out.println("|4.All words and their collection of     |");
        System.out.println("|  similar words in descending order     |");
        System.out.println("|5.Grammar check in text with            |");
        System.out.println("|  Damerau-Levenstein algorithm          |");
        System.out.println("|6.EXIT                                  |");
        System.out.println("=========================================");
        System.out.println("");
        System.out.println("Choose chapter and push Enter:");
        try {
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            while (true) {
                switch (choice) {
                    case 1:
                        System.out.println("Word with largest collection of similar words from Dictionary.txt: ");

                        // ищем слова с максимальным количеством похожих слов
                        int maxSize = 0;
                        for (Map.Entry<String, HashSet<String>> word : dict.entrySet()) {
                            if (word.getValue().size() > maxSize) {
                                maxSize = word.getValue().size();
                            }
                        }
                        // выводим слова с максимальным количеством похожих слов
                        for (Map.Entry<String, HashSet<String>> word : dict.entrySet()) {
                            if (word.getValue().size() == maxSize) {
                                System.out.println(word.getKey().toUpperCase() + " Count: " + word.getValue().size());
                            }
                        }
                        whatNext();
                        break;
                    case 2:
                        System.out.println("Count of words in dictionary: " + dict.size());
                        System.out.println();
                        whatNext();
                        break;
                    case 3:
                        int len = 0;
                        for (int i = 0; i < DictionaryDAO.wordsList.size(); i++) {
                            len += DictionaryDAO.wordsList.get(i).length();
                        }
                        Double avgLen = Double.valueOf(len) / DictionaryDAO.wordsList.size();
                        System.out.println("Average length of words in dictionary: " + Math.round(avgLen));
                        System.out.println("Time for creating codes (Soundex) of "
                                +dict.size()+" elements: "+PERF_TIMER+" milliseconds");
                        whatNext();
                        break;
                    case 4:
                        System.out.println("Printing words and their count similar words from dictionary.");
                        
                        HashMap<String, Integer> sorted = new HashMap<>();
                        for (Map.Entry<String, HashSet<String>> word : dict.entrySet()) {
                            sorted.put(word.getKey(),word.getValue().size());
                        }
                        TreeMap<String, Integer> sortedByValue = sortMapByValue(sorted);                       
                        for (Map.Entry<String, Integer> word : sortedByValue.entrySet()) {
                            System.out.println(word.getKey() + " : " + word.getValue());                            
                        }
                        whatNext();
                        break;
                    case 5:
                        System.out.println("Grammar check in text with Damerau-Levenstein algorithm.");
                        System.out.println("Checking file The_Last_of_the_Mohicans-James_Fenimore_Cooper: ");
                        for (int i = 0; i < DictionaryDAO.wordsFromText.size(); i++) {
                            if (!DictionaryDAO.wordsList.contains(DictionaryDAO.wordsFromText.get(i))) {
                                System.out.println("Didn't find the next word: "+DictionaryDAO.wordsFromText.get(i));
                                whatNextWithMissingWord(DictionaryDAO.wordsFromText.get(i));
                            }
                        }
                        whatNext();
                        break;
                    case 6:
                        System.out.println("End of programm.");
                        System.exit(0);
                    default:
                        System.out.println("Wrong choice! You must enter a "
                                + "number from 1 to 6! 6 is the exit from the program.");
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
       
    /**
     * Метод вызывается из пункта 4 меню. Обработка текста. Слова из текста нарезаны в лист.
     * Идет проверка слов не найденных в словаре.
     * @param word
     * @throws InterruptedException
     * @throws IOException 
     */
    private static void whatNextWithMissingWord(String word) throws InterruptedException, IOException {
        while (true) {
            try {
                System.out.println("If you want to proceed check the text enter 1. ");
                System.out.println("If you want to find similar words and change word - 2. CANCEL CHECK - 3");
                Scanner choice = new Scanner(System.in);
                int input = choice.nextInt();
                switch (input) {
                    case 2:
                        List<String> simWords = new ArrayList<>();
                        for (int i = 0; i < DictionaryDAO.wordsList.size(); i++) {
                            //поиск списка похожих слов
                            if (DamerauLevenstein.calculateDistance(DictionaryDAO.wordsList.get(i), word) == 1) {
                                simWords.add(DictionaryDAO.wordsList.get(i));
                            }
                        }
                        // если не нашли похожие слова с дистанцией 1 ищем с дистанцией два
                        if (simWords.isEmpty() == true) {
                            for (int i = 0; i < DictionaryDAO.wordsList.size(); i++) {
                                if (DamerauLevenstein.calculateDistance(DictionaryDAO.wordsList.get(i), word) == 2) {
                                    simWords.add(DictionaryDAO.wordsList.get(i));
                                }
                            }
                        }
                        System.out.println("Similar words:");
                        for (int i = 0; i < simWords.size(); i++) {
                            System.out.print((i + 1) + "." + simWords.get(i) + " ");
                        }
                        System.out.println("");
                        while (true) {
                            try {
                                System.out.println("Select number of word and push enter (if you want change word)");
                                System.out.println("If not suitable words - 0. (Type your word instead.)");
                                int input2 = choice.nextInt();
                                if (input2 == 0) {
                                    String newWord = addWord();
                                    changeWord(word, newWord);
                                    System.out.println("Your word added to dictionary and changed in text.");
                                    return;
                                }
                                if (input2 > simWords.size() || input2 < 1) {
                                    System.out.println("Wrong number!");
                                } else {
                                    changeWord(word, simWords.get(input2 - 1));
                                    System.out.println("Word changed");
                                    return;
                                }
                            } catch (Exception e) {
                                System.out.println("WRONG INPUT! Try again.");
                                whatNextWithMissingWord(word);
                            }
                        }

                    case 3:
                        System.out.println("Back to the MENU.");
                        Menu();
                        break;
                    case 1:
                        return;
                    default:
                        System.out.println("You entered an incorrect option!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Wrong Input!!!");
                System.out.println("Your current word is: " + word);
                whatNextWithMissingWord(word);
            }
        }
    }

    private static void changeWord(String word, String newWord) {
        for (int i = 0; i < DictionaryDAO.wordsFromText.size(); i++) {
            if (DictionaryDAO.wordsFromText.get(i).equals(word)) {
                DictionaryDAO.wordsFromText.set(i, newWord);
                break;
            }
        }       
    }
    
    private static String addWord() {
        String newWord;
        while (true) {
            try {
                System.out.println("Write your word and push enter: ");
                Scanner choice = new Scanner(System.in);
                newWord = choice.nextLine();
                if (newWord.trim().isEmpty() == false) {
                    DictionaryDAO.wordsList.add(newWord.toUpperCase());
                    return newWord;
                } else {
                    System.out.println("Empty string! Try again.");
                }               
            } catch (Exception e) {
                System.out.println("Something wrong!! Try again!");
                addWord();
            }
        }
    }

    /**
     * Метод для создания списка похожих слов для каждого слова. Похожими считал
     * только полное совпадение кода Soundex.
     *
     *
     */
    private static void dictOfSimilarWords() {
        for (int i = 0; i < DictionaryDAO.wordsList.size(); i++) {
            HashSet<String> set = new HashSet<>();
            set = getSetOfSimilarWords(DictionaryDAO.wordsList.get(i));
            dict.put(DictionaryDAO.wordsList.get(i), set);
        }
    }

    /**
     * Создание множества похожих слов.
     *
     * @param word
     * @return
     */
    public static HashSet getSetOfSimilarWords(String word) {
        HashSet<String> similarWords = new HashSet<>();
        String wordCode = Soundex.soundex(word);
        for (Map.Entry<String, String> w : wordsCodes.entrySet()) {
            if (!word.equals(w.getKey()) && wordCode.equals(w.getValue())) {
                similarWords.add(w.getKey());
            }
        }
        return similarWords;
    }

    /**
     * Создание кода для слов
     */
    private static void createWordsCodes() {
        Stopwatch timer = new Stopwatch();
        for (int i = 0; i < DictionaryDAO.wordsList.size(); i++) {
            wordsCodes.put(DictionaryDAO.wordsList.get(i), Soundex.soundex(DictionaryDAO.wordsList.get(i)));
        }
        PERF_TIMER = timer.elapsedTime();
    }
    
    /**
     * Сортировка по мапы по значению.
     * @param map
     * @return 
     */
    public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map) {
        Comparator<String> comparator = new ValueComparator(map);
        //TreeMap is a map sorted by its keys. 
        //The comparator is used to sort the TreeMap by keys. 
        TreeMap<String, Integer> result = new TreeMap<>(comparator);
        result.putAll(map);
        return result;
    }
    
    private static void createMaps() throws InterruptedException {
        DictionaryDAO.readDictionary();
        DictionaryDAO.readWordsFromText();
        System.out.println("Please wait. Reading files...");
        createWordsCodes();
        dictOfSimilarWords();
    }
}
