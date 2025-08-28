package eci.edu.arsw.calculator;

import eci.edu.arsw.linkedList.LinkedList;

public class StandardDeviation extends Thread {
    private final LinkedList list;
    private double mean;
    private double result;

    public StandardDeviation(LinkedList list, double mean) {
        this.list = list;
        this.mean = mean;
        this.result = 0;
    }

    @Override
    public void run() {
        double sum = 0;
        if (list.size() > 0) {
            for (Double value : list) {
                sum += Math.pow(value - mean,2);
            }
            result = Math.round((Math.sqrt(sum / (list.size()-1)))*100.0)/100.0;
        } else {
            result = 0.0;
        }
    }

    public LinkedList getList() {
        return list;
    }

    public double getResult() {
        return result;
    }
}
