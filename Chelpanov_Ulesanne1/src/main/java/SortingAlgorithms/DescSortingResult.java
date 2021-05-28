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
 * Класс для сбора результата сортировки по убыванию
 */
public class DescSortingResult {
    private int [] arrDesc;
    private long timerDesc;
    private int exchCountDesc;

    public DescSortingResult() {
    }

    public DescSortingResult(int[] arrDesc, long timerDesc, int exchCountDesc) {
        this.arrDesc = arrDesc;
        this.timerDesc = timerDesc;
        this.exchCountDesc = exchCountDesc;
    }

    public int[] getArrDesc() {
        return arrDesc;
    }

    public void setArrDesc(int[] arrDesc) {
        this.arrDesc = arrDesc;
    }

    public long getTimerDesc() {
        return timerDesc;
    }

    public void setTimerDesc(long timerDesc) {
        this.timerDesc = timerDesc;
    }

    public int getExchCountDesc() {
        return exchCountDesc;
    }

    public void setExchCountDesc(int exchCountDesc) {
        this.exchCountDesc = exchCountDesc;
    }
    
    
}
