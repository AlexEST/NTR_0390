
package API;

/**
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *  @author Alexander Chelpanov
 * 
 *  Класс для отслеживания времени выполнения алгоритмов. Взято у Седжвика и переработано.
 */

public class Stopwatch { 

    private final long start;

    /**
     * Initializes a new stopwatch.
     */
    public Stopwatch() {
        start = System.currentTimeMillis();
    } 


    /**
     * Returns the elapsed CPU time (in milliseconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in milliseconds) since the stopwatch was created
     */
    public long elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start);
    }

} 

