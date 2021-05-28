package SortingAlgorithms;

import API.Stopwatch;


/**
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *  @author Alexander Chelpanov
 * 
 *  Кое-что взято у Седжвика
 */
public class Insertion {

    // This class should not be instantiated.
    private Insertion() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     * @return 
     */
    public static AscSortingResult ascendingSort(int [] a) {
        int exCnt = 0;
        int n = a.length;
        AscSortingResult result = new AscSortingResult(); 
        Stopwatch timer = new Stopwatch();
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
                exCnt++;
            }
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
    public static DescSortingResult descendingSort(int [] a) {
        int exCnt2 = 0;
        int n = a.length;
        DescSortingResult result2 = new DescSortingResult(); 
        Stopwatch timer2 = new Stopwatch();
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && more(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
                exCnt2++;
            }
        }
        result2.setTimerDesc(timer2.elapsedTime());
        result2.setArrDesc(a);
        result2.setExchCountDesc(exCnt2);
        return result2;
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

    // exchange a[i] and a[j]  (for indirect sort)
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}

