package eci.edu.arsw;

import eci.edu.arsw.linkedList.LinkedList;
import eci.edu.arsw.util.DataReader;
import eci.edu.arsw.calculator.Mean;
import eci.edu.arsw.calculator.StandardDeviation;

/**
 * Clase principal del proyecto ARSW Programa Stadistic.
 * Lee un archivo de texto con números, calcula la media y la desviación estándar
 * usando hilos (threads) y muestra los resultados en consola.
 * 
 * Ejemplo de uso:
 * java -cp bin eci.edu.arsw.Main
 * 
 * @author Alejandro Prieto
 */
public class Main {

    /**
     * Método principal que ejecuta el flujo del programa.
     * 
     * @param args Argumentos de línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        try {
            // Leer los datos desde el archivo
            LinkedList list = DataReader.readFile("src/main/resources/table3.txt");

            if (list.isEmpty()) {
                System.out.println("El archivo no tiene datos.");
                return;
            }

            // Calcular la media usando un hilo
            Mean meanThread = new Mean(list);
            meanThread.start();
            meanThread.join();
            double mean = meanThread.getResult();

            // Calcular la desviación estándar usando otro hilo
            StandardDeviation stdThread = new StandardDeviation(list, mean);
            stdThread.start();
            stdThread.join();
            double std = stdThread.getResult();

            // Mostrar resultados
            System.out.println("Mean: " + mean);
            System.out.println("Standard deviation: " + std);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
