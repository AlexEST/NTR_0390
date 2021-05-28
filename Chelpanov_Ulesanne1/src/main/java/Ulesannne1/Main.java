/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ulesannne1;

import API.Stopwatch;
import PrimesAlgorithms.Bitwise;
import PrimesAlgorithms.BruteForce;
import PrimesAlgorithms.Eratosfen;
import PrimesAlgorithms.PrimesResult;
import SearchingAlgorithms.SearchResult;
import SortingAlgorithms.Insertion;
import SortingAlgorithms.Selection;
import SortingAlgorithms.SortingResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Alexander Chelpanov
 * Date: 07.02.2021
 * 
 * 1.Есть метод, который определяет, содержит ли массив дубликаты
 * Определите время работы алгоритма
 * Проанализируйте улучшенную версию и определите новое время работы алгоритма
 * 
 * 2.Предположим компьютер выполняет 1 млн. шагов алгоритма за 1 сек. Например, 
 * алгоритм выполняется в течение времени O(N2), тогда компьютер решит через 1 
 * час задачу у которой N=60 000 (60 000 x 60 000 = 3 600 000 000 / 1 000 000 
 * = 3 600 сек = 1 час).
 * Создайте таблицу, где будет представлен максимальный N для различных функций 
 * выполнения алгоритма (см. таблицу лекции слайд 17) за секунду, минуту, час, день, неделю
 * 
 * 3.Иногда константы, которыми пренебрегают в асимтотическом обозначении, 
 * играют важную роль. Например, 2 алгоритма решают одну и ту же задачу. 
 * Для первого требуется (N^3 / 100) - (N^2) / 5 + N + 10 шагов, 
 * второй за N+5 шагов. При каких значениях N вы отдадите предпочтение тому или иному алгоритму?
 * 
 * 4.Программа из N букв генерирует все возможные пары. Например, 
 * при ABCD: AB, AC, AD, BC, BD, CD. Какое время работы алгоритма?
 * 
 * 5.Создайте метод, который определяет является ли число N простым? 
 * Простое число – это целое положительное число, которое делится только 
 * на 1 и на само себя. Попробуйте реализовать несколькими алгоритмами, 
 * например простым перебором от 2 до N-1, решето Эратосфена 
 * или малая теорема Ферма. Сравните время работы алгоритма.
 * 
 * 6. Дан массив N размерностью. Реализуйте линейный и бинарный поиск элемента 
 * в массиве (без дубликатов и с дубликатами) сортировку элементов массива по 
 * возрастанию и убыванию (valige  2 meetodi saitist https://visualgo.net/en, 
 * uurige pseudocode ja looge kood Javas)
 * проанализируйте сложность метода выбранной сортировки для разного количества 
 * элементов (N=10, 100, 1000, 10000, 100000)
 * 
 */
public class Main {

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu()  {
        System.out.println("=========================================");
        System.out.println("|                 МЕНЮ                  |");
        System.out.println("=========================================");
        System.out.println("|Разделы:                               |");
        System.out.println("|1.Анализ методов                       |");
        System.out.println("|2.Таблица                              |");
        System.out.println("|3.Анализ алгоритмов                    |");
        System.out.println("|4.Генерирование пар                    |");
        System.out.println("|5.Нахождение простых чисел             |");
        System.out.println("|6.Сравнение алгоритмов сортировок и    |");
        System.out.println("|  поиска                               )");
        System.out.println("|7.Выход                                |");
        System.out.println("=========================================");
        System.out.println("");
        System.out.println("Выберите раздел и нажмите Enter:");
        try {
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            while (true) {
                switch (choice) {
                    case 1:
                        System.out.println("Анализ методов поиска дубликатов:");
                        System.out.println("Оба метода имеют сложность O(n^2). Во втором методе есть улучшение во"
                                + " внутреннем цикле O(n-i), что позволит увеличить скорость.");
                        System.out.println("Тестирование...");
                        int [] arr = API.ArrayMethods.shuffle(API.ArrayMethods.arrWithDups(100000));
                        Stopwatch timer = new Stopwatch();
                        Boolean answer = API.ArrayMethods.containsDuplicates(arr);
                        long time1 = timer.elapsedTime();
                        Stopwatch timer2 = new Stopwatch();
                        Boolean answer2 = API.ArrayMethods.containsDuplicatesOptimized(arr);
                        long time2 = timer2.elapsedTime();
                        System.out.println("Результат тестирования методов на массиве с 100 000 элементов и наличием дубликатов.");
                        System.out.println("Время работы первой версии: "+time1+" Найден дубликат: "+answer);
                        System.out.println("Время работы улучшенной версии: "+time2+" Найден дубликат: "+answer2);
                        whatNext();
                        break;
                    case 2:
                        System.out.println("Таблица");
                        API.Table.toConsole();
                        whatNext();
                        break;
                    case 3:
                        System.out.println("Анализ алгоритмов (N^3/100)-(N^2)/5+N+10 и N+5");
                        Set<Double> set = new HashSet<>();
                        Set<Double> temp;//временные значения для каждого i
                        // так как корней может быть два придется прогонять с разными значениями
                        for (int i = 0; i < 100; i++) {
                            temp = API.NewtonMethod.FindZero(i, 0);
                            for (Double double1 : temp) {
                                set.add(double1);
                            }
                        }
                        // выводим минимальное и максимальное из множества. Это вроде и есть наш диапазон.
                        System.out.println("По методу Ньютона (нахождение корней).");
                        System.out.printf("Алгоритм (N^3/100)-(N^2)/5+N+10 быстрее при значениях %.2f > N > %.2f", 
                                Collections.min(set), Collections.max(set));
                        System.out.println("");                       
                        whatNext();
                        break;
                    case 4:
                        System.out.println("Генерирование возможных пар. Сложность O(n^2).");
                        String [] chars = "ABCDABCD".split("");
                        ArrayList<String> list = new ArrayList<>();
                        System.out.println("На примере набора букв A,B,C,D,A,B,C,D.");
                        System.out.println("Генерирование с дубликатами:");
                        for (int i = 0; i < chars.length; i++) {
                            for (int j = i+1; j < chars.length; j++) {
                                System.out.print(chars[i]+chars[j]+ " ");
                            }
                        }
                        System.out.println("");
                        System.out.println("Генерирование без дубликатов (AB == BA или AA не допускается)");
                        for (int i = 0; i < chars.length; i++) {
                            for (int j = i+1; j < chars.length; j++) {
                                if (!chars[i].equals(chars[j]) 
                                        && list.contains(chars[i]+chars[j])==false 
                                        && list.contains(chars[j]+chars[i])==false) {
                                    list.add(chars[i]+chars[j]);
                                }
                            }
                        }
                        list.forEach((pair) -> {
                            System.out.print(pair + " ");
                        });
                        System.out.println("");
                        whatNext();
                        break;
                    case 5:
                        System.out.println("Нахождение простых чисел");
                        System.out.println("Сравнение работы алгоритмов для поиска простых чисел (до 1 000 000)");
                        System.out.println("");
                        
                        PrimesResult brute = BruteForce.bruteForce(1000000);
                        PrimesResult eratos = Eratosfen.eratosfenPrimes(1000000);
                        PrimesResult bitwise = Bitwise.BitwiseSieve(1000000);
                        
                        brute.primesToConsole("Brute Force");
                        eratos.primesToConsole("Eratosfen Sieve");
                        bitwise.primesToConsole("Bitwise Sieve");
                        whatNext();
                        break;
                    case 6:
                        subMenu();
                        break;
                    case 7:
                        System.out.println("Выход из программы: ");
                        System.exit(0);
                    default:
                        System.out.println("Неверный выбор! Вы должны ввести "
                                + "число от 1 до 7! 7 - это выход из программы.");
                        whatNext();
                        break;
                }
                break;
            }
        } catch (InputMismatchException е) {
            System.out.println("ВВОД НЕВЕРНЫЙ! Попробуйте заново.");
            whatNext();
        }
    }

    private static void whatNext() {
        while (true) {
            System.out.println("Введите 1 если хотите завершить программу. "
                    + "Если хотите вернуться в меню введите 2");
            Scanner choice = new Scanner(System.in);
            int input = choice.nextInt();
            switch (input) {
                case 2:
                    Menu();
                    break;
                case 1:
                    System.exit(0);
                default:
                    System.out.println("Вы ввели неверный вариант!");
                    break;
            }
        }
    }
    
    private static void whatNextInSubMenu() {
        while (true) {
            System.out.println("Введите 1 если хотите завершить программу. "
                    + "Если хотите вернуться в главное меню введите 2"+
                    " Остаться в текущем меню - 3");
            Scanner choice = new Scanner(System.in);
            int input = choice.nextInt();
            switch (input) {
                case 3:
                    subMenu();
                    break;
                case 2:
                    Menu();
                    break;
                case 1:
                    System.exit(0);
                default:
                    System.out.println("Вы ввели неверный вариант!");
                    break;
            }
        }
    }
    
    public static void subMenu()  {
        System.out.println("=========================================");
        System.out.println("|           МЕНЮ раздела 6              |");
        System.out.println("=========================================");
        System.out.println("|Разделы:                               |");
        System.out.println("|1.Линейный и бинарный поиск            |");
        System.out.println("|2.Сортировки и их анализ               |");
        System.out.println("|3.Выход                                |");
        System.out.println("=========================================");
        System.out.println("");
        System.out.println("Выберите раздел и нажмите Enter:");
        try {
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            while (true) {
                switch (choice) {
                    case 1:
                        System.out.println("Линейный и бинарный поиск: ");
                        int [] arrr = API.ArrayMethods.shuffle(API.ArrayMethods.arr(1000000));
                        int [] SortedArray = arrr.clone();
                        Arrays.sort(SortedArray);
                        SearchResult binaryRes = SearchingAlgorithms.BinarySearch.binarySearch(SortedArray, 11);
                        SearchResult linearRes = SearchingAlgorithms.LinearSearch.search(arrr, 11);
                        if (binaryRes == null ) {
                            System.out.println("Нет такого элемента в массиве! ");
                        } else {
                            binaryRes.resultToConsole("Binary Search");
                            linearRes.resultToConsole("Linear Search");
                        }
                        
                        whatNextInSubMenu();
                        break;
                    case 2:
                        System.out.println("Анализ алгоритмов сортировок.");
                        System.out.println("");
                        ArrayList<SortingResult> resList = new ArrayList<>();
                        ArrayList<SortingResult> selList = new ArrayList<>();
                        int elemCnt = 10;
                        for (int i = 0; i < 4; i++) {           
                            int[] arr = API.ArrayMethods.shuffle(API.ArrayMethods.arr(elemCnt));
                            SortingResult res = new SortingResult(arr, Insertion.ascendingSort(arr.clone()), Insertion.descendingSort(arr.clone()));
                            SortingResult selres = new SortingResult(arr, Selection.ascendingSort(arr.clone()), Selection.descendingSort(arr.clone()));
                            resList.add(res);
                            selList.add(selres);
                            elemCnt *= 10;
                        }
                        for (int i = 0; i < resList.size(); i++) {
                            resList.get(i).sortResultToConsole("Insertion sort");
                        }
                        selList.forEach((sortingResult) -> {
                            sortingResult.sortResultToConsole("Selection sort");
                        });
                        whatNextInSubMenu();
                        break;
                    case 3:
                        System.out.println("Выход из программы: ");
                        System.exit(0);
                    default:
                        System.out.println("Неверный выбор! Вы должны ввести "
                                + "число от 1 до 3! 3 - это выход из программы.");
                        whatNext();
                        break;
                }
                break;
            }
        } catch (InputMismatchException е) {
            System.out.println("ВВОД НЕВЕРНЫЙ! Попробуйте заново.");
            whatNext();
        }
    }
}
