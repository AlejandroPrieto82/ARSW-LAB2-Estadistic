package eci.edu.arsw.calculator;

import eci.edu.arsw.linkedList.LinkedList;

/**
 * Clase que calcula la desviación estándar de una lista de números usando un hilo.
 * Permite realizar el cálculo de manera concurrente.
 * La desviación se calcula a partir de la media proporcionada.
 * 
 * @author Alejandro Prieto Reyes
 */
public class StandardDeviation extends Thread {

    /**
     * Lista de números a procesar.
     */
    private final LinkedList list;

    /**
     * Media de los números, usada para el cálculo de la desviación estándar.
     */
    private double mean;

    /**
     * Resultado de la desviación estándar calculada.
     */
    private double result;

    /**
     * Constructor de la clase StandardDeviation.
     * 
     * @param list Lista de números (LinkedList) sobre la cual se calculará la desviación estándar.
     * @param mean Media de los números en la lista, necesaria para el cálculo.
     */
    public StandardDeviation(LinkedList list, double mean) {
        this.list = list;
        this.mean = mean;
        this.result = 0;
    }

    /**
     * Método que se ejecuta al iniciar el hilo.
     * Calcula la desviación estándar de los números en la lista y la almacena en el atributo result.
     * Si la lista está vacía, el resultado será 0.0.
     */
    @Override
    public void run() {
        double sum = 0;
        if (list.size() > 0) {
            for (Double value : list) {
                sum += Math.pow(value - mean, 2);
            }
            result = Math.round((Math.sqrt(sum / (list.size() - 1))) * 100.0) / 100.0;
        } else {
            result = 0.0;
        }
    }

    /**
     * Retorna la lista de números usada en el cálculo.
     * 
     * @return LinkedList de números.
     */
    public LinkedList getList() {
        return list;
    }

    /**
     * Retorna el resultado del cálculo de la desviación estándar.
     * 
     * @return Desviación estándar de los números en la lista, redondeada a dos decimales.
     */
    public double getResult() {
        return result;
    }
}
