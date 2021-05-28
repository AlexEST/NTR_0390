/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.util.Random;

/**
 *
 * @author Alexander Chelpanov
 * Date: 02.02.2021
 */
public class ArrayMethods {
    // кое-что взято из Седжвика и его книги 
    private static final Random random;    // pseudo-random number generator
    private static final long seed;        // pseudo-random number generator seed
    
    // static initializer
    static {
        // this is how the seed was set in Java 1.4
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }
    
    public static int[] arr(int N) {
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        shuffle(arr);
        
        return arr;      
    }
    
    public static int[] arrWithDups(int N) {
        int[] arr = new int[N];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
            arr[i-1] = i;
        }
        shuffle(arr);
        
        return arr;      
    }
    
    
    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     * @return 
     */
    public static int[] shuffle(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n-i);     // between i and n-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        return a;
    }
    
    /**
     * Returns a random integer uniformly in [0, n).
     * 
     * @param n number of possible integers
     * @return a random integer uniformly between 0 (inclusive) and {@code n} (exclusive)
     */
    public static int uniform(int n) {
        if (n <= 0) throw new IllegalArgumentException("argument must be positive: " + n);
        return random.nextInt(n);
    }
    
    public static boolean containsDuplicates(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j ) {
                    if (arr[i] == arr[j]) {
                        return true;
                    }
                }
            }
        }
        return false;  
    }
    
    public static boolean containsDuplicatesOptimized(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;  
    }

    
}
