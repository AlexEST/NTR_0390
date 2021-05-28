/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

/**
 *
 * @author Alexander Chelpanov
 * Date: 05.02.2021
 * 
 */
public class Table {
    private static final double second = 1000000;
    private static final double minute = second * 60;
    private static final double hour = minute * 60;
    private static final double day = hour * 24;
    private static final double week = day * 7;
    private static final double year = day * 365.25f;
    
    // взято у Рода Стивенса. Факториал числа наоборот
    private static int InverseFactorial(double value) {
        for (int i = 1;; i++) {
            if (Factorial(i) > value) {
                return i - 1;
            }
        }
    }

    //Обычный факториал
    private static double Factorial(int n) {
        double result = 1;
        for (int i = 2; i < n; i++) {
            result *= i;
        }
        return result;
    }
    
    private static void table(String name, double steps) {
        double valLog = Math.pow(2, steps);                  // Log N
        double valSqrt = steps * steps;                      // Sqrt(N)
        double valN = steps;                                 // N
        double valRoot = Math.sqrt(steps);                   // N^2
        double val2 = Math.log(steps);                       // 2^N
        double valFac = InverseFactorial(steps);             // N!
        System.out.printf("%-8s %-15s %-20s %-15s %-25s %-25s %-10s%n",
                name, valLog, valSqrt, valN, valRoot, val2, valFac);
    }
    
    public static void toConsole() {
        System.out.printf("%-8s %-15s %-20s %-15s %-25s %-25s %-10s%n",
                "ВРЕМЯ", "LOG2(n)", "SQRT(n)", "N", "N^2", "2^N", "N!");
        table("Секунда", second);
        table("Минута", minute);
        table("Час", hour);
        table("День", day);
        table("Неделя", week);
        table("Год", year);
        System.out.println("");
    }
    
}
