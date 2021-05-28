/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchingAlgorithms;

import API.Stopwatch;

/**
 *
 * @author Alexander Chelpanov
 * 
 */
public class LinearSearch {

    public static SearchResult search(int arr[], int x) {
        SearchResult res = new SearchResult();
        res.setArr(arr);
        Stopwatch timer = new Stopwatch();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                res.setTimer(timer.elapsedTime());
                res.setElem(x);
                res.setIndex(i);
                return res;
            }
        }
        return null;
    }
    
}
