package eci.edu.arsw.util;

import eci.edu.arsw.linkedList.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase utilitaria para leer archivos de texto y convertir su contenido
 * en una lista de números de tipo double.
 * Cada línea del archivo debe contener un número válido.
 * 
 * Ejemplo de uso:
 * LinkedList list = DataReader.readFile("src/main/resources/Table1.1.txt");
 * 
 * @author Alejandro Prieto
 */
public class DataReader {

    /**
     * Lee un archivo de texto y convierte cada línea en un valor double.
     * Los valores se almacenan en un LinkedList y se retorna.
     * 
     * @param filePath Ruta del archivo a leer.
     * @return LinkedList con los números del archivo.
     * @throws IOException si ocurre un error al leer el archivo.
     */
    public static LinkedList readFile(String filePath) throws IOException {
        LinkedList numbers = new LinkedList();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    double value = Double.parseDouble(line.trim());
                    numbers.add(value);
                }
            }
        }

        return numbers;
    }
}
