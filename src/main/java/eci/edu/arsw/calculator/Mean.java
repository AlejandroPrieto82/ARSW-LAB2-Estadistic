package eci.edu.arsw.calculator;

import eci.edu.arsw.linkedList.LinkedList;

/**
 * Clase que calcula la media de una lista de números usando un hilo.
 * Permite realizar el cálculo de manera concurrente.
 * 
 * @author Alejandro Prieto Reyes
 */
public class Mean extends Thread {

    /**
     * Lista de números a procesar.
     */
    private final LinkedList list;

    /**
     * Resultado de la media calculada.
     */
    private double result;

    /**
     * Constructor de la clase Mean.
     * 
     * @param list Lista de números (LinkedList) sobre la cual se calculará la media.
     */
    public Mean(LinkedList list) {
        this.list = list;
    }

    /**
     * Método que se ejecuta al iniciar el hilo.
     * Calcula la media de los números en la lista y la almacena en el atributo result.
     * Si la lista está vacía, el resultado será 0.0.
     */
    @Override
    public void run() {
        double sum = 0;
        if(list.size() > 0){
            for (Double value : list) {
                sum += value;
            }
            result = Math.round ((sum/list.size()) *100.0)/100.0;
        } else {
            result = 0.0;
        }
    }

    /**
     * Retorna el resultado del cálculo de la media.
     * 
     * @return Media de los números en la lista, redondeada a dos decimales.
     */
    public double getResult() {
        return result;
    }
}
