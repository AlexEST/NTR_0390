/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortingAlgorithms;

/**
 *
 * @author Alexander Chelpanov
 * 
 * Класс для сбора результата сортировки по возрастанию
 */
public class AscSortingResult {
    private int[] arrAsc;
    private long timerAsc;
    private int exchCountAsc;

    public AscSortingResult() {
    }

    public AscSortingResult(int[] arrAsc, long timerAsc, int exchCountAsc) {
        this.arrAsc = arrAsc;
        this.timerAsc = timerAsc;
        this.exchCountAsc = exchCountAsc;
    }

    public int[] getArrAsc() {
        return arrAsc;
    }

    public void setArrAsc(int[] arrAsc) {
        this.arrAsc = arrAsc;
    }

    public long getTimerAsc() {
        return timerAsc;
    }

    public void setTimerAsc(long timerAsc) {
        this.timerAsc = timerAsc;
    }

    public int getExchCountAsc() {
        return exchCountAsc;
    }

    public void setExchCountAsc(int exchCountAsc) {
        this.exchCountAsc = exchCountAsc;
    }
    
    
}
