package eci.edu.arsw;

import eci.edu.arsw.linkedList.LinkedList;
import eci.edu.arsw.util.DataReader;
import eci.edu.arsw.calculator.Mean;
import eci.edu.arsw.calculator.StandardDeviation;

public class Main {
    public static void main(String[] args) {
        try {
            LinkedList list = DataReader.readFile("src/main/resources/table1.2.txt");

            if (list.isEmpty()) {
                System.out.println("El archivo no tiene datos.");
                return;
            }

            Mean meanThread = new Mean(list);
            meanThread.start();
            meanThread.join();
            double mean = meanThread.getResult();

            StandardDeviation stdThread = new StandardDeviation(list, mean);
            stdThread.start();
            stdThread.join();
            double std = stdThread.getResult();

            System.out.println("Mean: " + mean);
            System.out.println("Standard deviation: " + std);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
