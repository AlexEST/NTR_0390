package PriorityQueue;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



/**
 *
 * @author Alexander Chelpanov 182730EDTR 
 * Date: 21.02.2021
 *
 *
 */
class ClientLinkedList {

    private Client first;
    private Client last;

    public ClientLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insert(Client newClient) {      
        boolean lastClient = false;
        if (isEmpty()) {
            addFirst(newClient);
            //если клиент особый и первый клиент обычный ставим особого первым
        } else if ("VIP".equals(newClient.getType()) && "Usual".equals(first.getType())){            
            addFirst(newClient);
            //если клиент обычный добавляем его в конец очереди
        } else if ("Usual".equals(newClient.getType())) {
            addLast(newClient);
            // если клиент особый ищем ему место после особых
        } else if ("VIP".equals(newClient.getType())) {
            Client current = first;
            while (!"Usual".equals(current.getType())) {                
                if (current.next==null) {
                    lastClient = true;
                    break;
                }
                current = current.next;
            }
            if (lastClient==true) {
                addLast(newClient);               
            } else {
                addAfterKey(current.previous.getId(), newClient);//вставляем особого клиента в очередь                
            }
        }
    }
    
    /**
     * Обновление предполагаемого времени обслуживания.
     * 
     */
    public void renewTime(){
        Client current = first;
        LocalTime time = LocalTime.now();
        int mins = 0;
        while (current != null) {
            current.setStartTime(time.plusMinutes(mins));
            current.setEndTime(time.plusMinutes(mins+15));
            mins += 15;
            current = current.next;
        }
    }

    public void addAfterKey(int key, Client newClient) {
        Client current = first;
        while (current.getId() != key) {
            current = current.next;
            if (current == null) {
                return;
            }
        }

        if (current == last) {
            newClient.next = null;
            last = newClient;
        } else {
            newClient.next = current.next;

            current.next.previous = newClient;
        }
        newClient.previous = current;
        current.next = newClient;    
        renewTime();
    }
    
    
    public void addLast(Client client) {
        if (isEmpty()) {
            first = client;
        } else {
            last.next = client;
            client.previous = last;
        }
        last = client;
        renewTime();
    }
    
    
    public void addFirst(Client newClient) {
        if (isEmpty()) {
            last = newClient;
        } else {
            first.previous = newClient;
        }
        newClient.next = first;
        first = newClient;
        renewTime();
    }
    
    
    public Client remove() {
        Client temp = first;
        first = first.next;
        renewTime();
        return temp;
    }

    public void displayList() {        
        System.out.printf("%-3s %-10s %-15s %-22s %-22s%n",
                "ID", "TIME", "TYPE OF CLIENT", "START TIME(ESTIM.)", "END TIME(ESTIM.)");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
        Client current = first;
        while (current != null) {
            System.out.printf("%-3d %-10s %-15s %-22s %-22s%n",
                current.getId(), current.getTimeRec().format(dtf), current.getType(),
                current.getStartTime().format(dtf), current.getEndTime().format(dtf));
            current = current.next;
        }
        System.out.println("");
    }
}

