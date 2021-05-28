/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shop;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Alexander Chelpanov
 * Date: 16.02.2021
 * 
 * 
 */
public class Checkout {

    
    private int maxItems;
    private ArrayList<CirQueue> lines;

    public Checkout(int nLines, int maxLineLength, int maxItems) {
        
        this.maxItems = maxItems;
        

        lines = new ArrayList<>(); 
        for (int i = 0; i < nLines; i++) {
            CirQueue cir = new CirQueue(maxLineLength);
            lines.add(cir);
        }
    }
    
    public int getLength() {
        return lines.size();
    }
    

    public void addCustomer() {

        int shortestLine = 0;
        int minSize = lines.get(0).size();//мин размер очереди
        int minSum = lines.get(0).getSum();// количество товаров в корзинах очереди
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).size() <= minSize) {
                if (lines.get(i).size() < minSize) {
                    minSize = lines.get(i).size();
                    minSum = lines.get(i).getSum();
                    shortestLine = i;
                }
                // если очередь по длине одинакова, но количество товаров в этой очереди меньше
                if (lines.get(i).size() == minSize && lines.get(i).getSum()<minSum) {
                    minSum = lines.get(i).getSum();
                    shortestLine = i;
                }

            }
        }


        // Добавляем покупателя в самую короткую очередь и с наименьшим числом товаров в корзинах
        Random rand = new Random();
        int items = rand.nextInt(maxItems) + 1;
        lines.get(shortestLine).insert(items);        
        display();
    }
    
    
    public  void deleteItems() {
        for (int i = 0; i < lines.size(); i++) {
            lines.get(i).decFront(1);//удаляем один элемент из корзины
        }
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).isEmpty()) { // если в кассе нет покупателей удаляем
                lines.remove(i);
                i--;
            }
        }
        display();
    }
    


    private void display() {
        
        for (int i = 0; i < lines.size(); i++) {
            System.out.print("Checkout " + (i+1) + ": ");// вывод для касс
            lines.get(i).display();
        }
        System.out.println("____________");
    }
}
