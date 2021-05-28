/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchingAlgorithms;

import static SortingAlgorithms.SortingResult.BLUE;
import static SortingAlgorithms.SortingResult.RED;
import static SortingAlgorithms.SortingResult.RESET;

/**
 *
 * @author Alexander Chelpanov
 * Date: 05.02.2021
 * 
 */
public class SearchResult {
    private int [] arr;
    long timer;
    int index;
    int elem;

    public SearchResult() {
    }

    public SearchResult(int[] arr, long timer, int index, int elem) {
        this.arr = arr;
        this.timer = timer;
        this.index = index;
        this.elem = elem;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getElem() {
        return elem;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }
    
    
    
    public void resultToConsole(String name) {
       
        System.out.println(BLUE + name + RESET);
        System.out.println(RED + "Количество элементов в массиве: " + arr.length + RESET);
        System.out.println("Найденное число: " + elem + " Индекс найденного числа: " + index);
        if (arr.length < 100000) {
            System.out.println("Вывод массива: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
        }      
        System.out.println("Скорость выполнения: "+timer+" миллисекунд");
        System.out.println("----------------------------------------------------------------");
        System.out.println("");
        
    }
}
