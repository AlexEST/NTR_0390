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
public class Bitwise {

    public static PrimesResult BitwiseSieve(int n) {
        PrimesResult res = new PrimesResult();
        Stopwatch timer = new Stopwatch();
        // prime[i] is going to store true if
        // if i*2 + 1 is composite.
        boolean prime[]=new boolean[n / 2];
        Arrays.fill(prime, false);
     
        // 2 is the only even prime so we can
        // ignore that. Loop starts from 3.
        for (int i = 3; i * i < n; i += 2) {
            // If i is prime, mark all its
            // multiples as composite
            if (prime[i / 2] == false) {
                for (int j = i * i; j < n; j += i * 2) {
                    prime[j / 2] = true;
                }
            }
        }
     
        res.getPrimes().add(2);
     
        // Printing other primes
        for (int i = 3; i < n ; i += 2){
            if (prime[i / 2] == false){
                res.getPrimes().add(i);
            }
        }            
        res.setTimer(timer.elapsedTime());
        return res;
    }
}
