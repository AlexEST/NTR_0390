/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimesAlgorithms;

import API.Stopwatch;

/**
 *
 * @author Alexander Chelpanov
 * Date: 02.02.2021
 * 
 */
public class BruteForce {
    
    public static PrimesResult bruteForce(int n) {
        PrimesResult result = new PrimesResult();
        Stopwatch time = new Stopwatch();
        for (int i = 2; i < n; i++) {           
            if (isPrime(i)==true) {
                result.getPrimes().add(i);
            }
        }
        result.setTimer(time.elapsedTime());
        return result;       
    }
    

    static boolean isPrime(int n) {

        // Check if number is less than
        // equal to 1
        if (n <= 1) {
            return false;
        } // Check if number is 2
        else if (n == 2) {
            return true;
        } // Check if n is a multiple of 2
        else if (n % 2 == 0) {
            return false;
        }

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
