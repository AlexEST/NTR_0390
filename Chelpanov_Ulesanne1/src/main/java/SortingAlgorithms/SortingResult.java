/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortingAlgorithms;



/**
 *
 * @author Alexander Chelpanov
 * 
 * Класс для сбора всех результатов сортировки
 */
public class SortingResult {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    
    private int[] arr;
    private AscSortingResult ascResult;
    private DescSortingResult descResult;

    public SortingResult() {
    }
    
    public SortingResult(int[] arr) {
        this.arr = arr;
    }
    
    public SortingResult(int[] arr, AscSortingResult ascResult, DescSortingResult descResult) {
        this.arr = arr;
        this.ascResult = ascResult;
        this.descResult = descResult;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public AscSortingResult getAscResult() {
        return ascResult;
    }

    public void setAscResult(AscSortingResult ascResult) {
        this.ascResult = ascResult;
    }

    public DescSortingResult getDescResult() {
        return descResult;
    }

    public void setDescResult(DescSortingResult descResult) {
        this.descResult = descResult;
    }

    //вывод в консоль. Цветной вывод будет только при версии Maven ниже 3.5
    public void sortResultToConsole(String name) {
        System.out.println(BLUE + name + RESET);
        System.out.println(RED + "Количество элементов массива: "+ arr.length + RESET);
        System.out.println("Изначальный вариант массива (Не больше ста первых чисел): ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
            if (i>99) {
                break;
            }
        }
        System.out.println("");
        System.out.println(BLUE+"Сортировка элементов массива по возрастанию (Не больше ста первых чисел): "+RESET);
        for (int i = 0; i < ascResult.getArrAsc().length; i++) {
            System.out.print(ascResult.getArrAsc()[i] + " ");
            if (i>99) {
                break;
            }
        }
        System.out.println("");
        System.out.println("Количество перестановок: "+ascResult.getExchCountAsc());
        System.out.println("Скорость выполнения: "+ascResult.getTimerAsc()+" миллисекунд");
        System.out.println(BLUE+"Сортировка элементов массива по убыванию (Не больше ста первых чисел): "+RESET);
        for (int i = 0; i < descResult.getArrDesc().length; i++) {
            System.out.print(descResult.getArrDesc()[i] + " ");
            if (i>99) {
                break;
            }
        }
        System.out.println("");
        System.out.println("Количество перестановок: "+descResult.getExchCountDesc());
        System.out.println("Скорость выполнения: "+descResult.getTimerDesc()+" миллисекунд");
        System.out.println("----------------------------------------------------------------");
        System.out.println("");
    }
}
