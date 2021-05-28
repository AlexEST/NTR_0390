/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimesAlgorithms;

import API.Stopwatch;
import java.util.Arrays;

/**
 *
 * @author Alexander Chelpanov
 * Date: 02.02.2021
 * 
 */
public class Eratosfen {

    public static PrimesResult eratosfenPrimes(int max) {
        PrimesResult res = new PrimesResult();
        Stopwatch timer = new Stopwatch();
        boolean[] isPrime = new boolean[max];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < max; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for (int i = 2; i < max; i++) {
            if (isPrime[i]) {
                res.getPrimes().add(i);
            }
        }
        res.setTimer(timer.elapsedTime());
        return res;
    }
} 

