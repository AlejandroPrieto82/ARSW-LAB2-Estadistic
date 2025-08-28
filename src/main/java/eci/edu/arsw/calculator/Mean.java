package eci.edu.arsw.calculator;

import eci.edu.arsw.linkedList.LinkedList;

public class Mean extends Thread {
    private final LinkedList list;
    private double result;

    public Mean(LinkedList list) {
        this.list = list;
    }

    @Override
    public void run() {
        double sum = 0;
        if(list.size() > 0){
            for (Double value : list) {
                sum += value;
            }
            result = Math.round ((sum/list.size()) *100.0)/100.0;
        }else{
            result = 0.0;
        }
    }

    public double getResult() {
        return result;
    }
}
