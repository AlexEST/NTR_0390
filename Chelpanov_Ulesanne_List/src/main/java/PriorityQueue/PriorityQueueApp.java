/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriorityQueue;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Alexander Chelpanov
 * Date: 23.02.2021
 * 
 * 
 */
public class PriorityQueueApp {
    public static void priorityQueue() throws InterruptedException {       
        PriorityQueue pq = new PriorityQueue();
        LocalTime time = LocalTime.now();
        System.out.println("ADDING TO QUEUE:");
        System.out.println("");
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                pq.insert(new Client(i + 1, LocalTime.now(), "VIP", time, time.plusMinutes(15)));
                System.out.println("Adding client with VIP status to the Queue. PLEASE WAIT...");
                TimeUnit.SECONDS.sleep(2);//время можно менять для удобства отслеживания
                pq.display();
            } else {
                pq.insert(new Client(i + 1, LocalTime.now(), "Usual", time, time.plusMinutes(15)));
                System.out.println("Adding client with USUAL status to the Queue. PLEASE WAIT...");
                TimeUnit.SECONDS.sleep(2);
                pq.display();
            }
        }
        System.out.println("");
        System.out.println("REMOVING FROM QUEUE: ");
        System.out.println("");
        while (!pq.sortList.isEmpty()) {
            pq.delete();
            TimeUnit.SECONDS.sleep(2);
            pq.display();
        }        
    } 
}
