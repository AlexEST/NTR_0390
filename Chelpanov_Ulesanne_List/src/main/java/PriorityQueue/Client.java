/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriorityQueue;

import java.time.LocalTime;


/**
 *
 * @author Alexander Chelpanov 182730EDTR
 * Date: 22.02.2021
 * 
 * 
 */
public class Client {
    private int id;
    private LocalTime timeRec;
    private String type;
    private LocalTime startTime;
    private LocalTime endTime;
    Client previous;
    Client next;

    public Client(int id, String type) {
        this.id = id;
        this.type = type;       
    }

    public Client(int id, LocalTime timeRec, String type, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.timeRec = timeRec;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public LocalTime getTimeRec() {
        return timeRec;
    }

    public String getType() {
        return type;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimeRec(LocalTime timeRec) {
        this.timeRec = timeRec;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {       
        return  ""+id+" "+type;
    }    
}
