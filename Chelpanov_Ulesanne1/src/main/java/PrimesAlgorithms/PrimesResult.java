/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimesAlgorithms;

import static SortingAlgorithms.SortingResult.BLUE;
import static SortingAlgorithms.SortingResult.RED;
import static SortingAlgorithms.SortingResult.RESET;
import java.util.ArrayList;

/**
 *
 * @author Alexander Chelpanov
 * Date: 02.02.2021
 * 
 */
public class PrimesResult {
    private ArrayList<Integer> primes = new ArrayList<>();
    private long timer;

    public PrimesResult() {
    }

    public PrimesResult(ArrayList<Integer> primes, long timer) {
        this.primes = primes;
        this.timer = timer;
    }

    public ArrayList<Integer> getPrimes() {
        return primes;
    }

    public void setPrimes(ArrayList<Integer> primes) {
        this.primes = primes;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }
    
    
    public void primesToConsole(String name) {
        System.out.println(BLUE + name + RESET);
        System.out.println(RED + "Количество простых чисел: "+ primes.size() + RESET);
        System.out.println("Простые числа (Вывод только первых сто для проверки): ");
        for (int i = 0; i < 100; i++) {
            System.out.print(primes.get(i)+" ");
        }
        System.out.println("");        
        System.out.println("Скорость выполнения: "+timer+" миллисекунд");
        System.out.println("----------------------------------------------------------------");
        System.out.println("");
    }
}
