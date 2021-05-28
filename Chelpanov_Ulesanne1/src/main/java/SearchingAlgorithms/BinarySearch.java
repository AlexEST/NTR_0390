
package SearchingAlgorithms;

import API.Stopwatch;


/**
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class BinarySearch {

    /**
     * This class should not be instantiated.
     */
    private BinarySearch() { }

    /**
     * 
     *
     * @param  a the array of integers, must be sorted in ascending order
     * @param  key the search key
     * @return SearchResult
     */
    public static SearchResult binarySearch(int[] a, int key) {
        SearchResult res = new SearchResult();
        res.setArr(a);
        Stopwatch timer = new Stopwatch();
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                res.setTimer(timer.elapsedTime());
                res.setElem(a[mid]);
                res.setIndex(mid);
                return res;
            }
        }
        return null;
    }

    
}
