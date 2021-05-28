
package SortingAlgorithms;

import API.Stopwatch;


/**
 *  
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *  @author Alexander Chelpanov
 *  @date 02.02.2021
 * 
 */
public class Selection {

    // This class should not be instantiated.
    private Selection() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     * @return 
     */
    public static AscSortingResult ascendingSort(int[] a) {
        int exCnt = 0;
        int n = a.length;
        AscSortingResult result = new AscSortingResult(); 
        Stopwatch timer = new Stopwatch();
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(a[j], a[min])) min = j;                
            }
            exch(a, i, min);
            exCnt++;
        }
        result.setTimerAsc(timer.elapsedTime());
        result.setArrAsc(a);
        result.setExchCountAsc(exCnt);
        return result;
    }

    /**
     * Rearranges the array in descending order, using the natural order.
     * @param a the array to be sorted
     * @return 
     */
    public static DescSortingResult descendingSort(int[] a) {
        int exCnt = 0;
        int n = a.length;
        DescSortingResult result = new DescSortingResult(); 
        Stopwatch timer = new Stopwatch();
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (more(a[j], a[min])) min = j;                
            }
            exch(a, i, min);
            exCnt++;
        }
        result.setTimerDesc(timer.elapsedTime());
        result.setArrDesc(a);
        result.setExchCountDesc(exCnt);
        return result;
    }


   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    // is v > w ?
    private static boolean more(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }
      
    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}

