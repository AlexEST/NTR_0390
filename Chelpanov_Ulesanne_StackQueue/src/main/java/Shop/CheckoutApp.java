/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shop;


import java.util.concurrent.TimeUnit;

/**
 *
 * @author Alexander Chelpanov
 * Date: 16.02.2021
 * 
 */
public class CheckoutApp {

    public static void checkApp() throws InterruptedException {
        int nLines = 3; // Всего очередей в кассы
        int maxLineLength = 20; // Максимальная длина в кассу
        int buyersCount = 10; // Количество покупателей
        int maxItems = 5; // Максимальное количество товаров в корзине.


        Checkout cOut = new Checkout(nLines, maxLineLength, maxItems);

        System.out.println("ADDING TO QUEUE: ");
        
        while (buyersCount > 0) {

            cOut.addCustomer();
            buyersCount--;
            TimeUnit.SECONDS.sleep(2);//ждем 
        }
        System.out.println("");
        System.out.println("");
        System.out.println("REMOVING FROM QUEUE: ");
        while (cOut.getLength()>0) {

            cOut.deleteItems();
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println("");
    }
}
