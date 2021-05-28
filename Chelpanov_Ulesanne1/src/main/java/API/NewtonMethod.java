/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Alexander Chelpanov
 * 
 * Метод Ньютона для нахождения корней. Взято у Рода Стевенса.
 */
public class NewtonMethod {

    // Нахождение нуля уравнения. На входе значение х и максимальная допустимая погрешность.
    public static Set FindZero(double start, double maxError) {
        double x = start;
        double y = F(x);
        Set<Double> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            //("");
            if (x > y && x > 0 && y <= 0) {
                //System.out.println("(" + Double.toString(x) + ", " + Double.toString(y) + ")");
                set.add(x);
                break;
            }           
            if (Math.abs(y) < maxError) {
                break;
            }
            x -= y / dFdx(x);
            y = F(x);
        }
        return set;
    }

    private static double F(double x) {
        //(N^3 / 100) - (N^2) / 5 + N + 10 - (N + 5)
        return (x * x * x / 100f - x * x / 5f + x + 10) - (x  + 5);
    }

    // производная
    private static  double dFdx(double x) {
        return ((2f * (x * x ))/ 100f - 2f * x / 5f );
    }
}
