package eci.edu.arsw.util;

import eci.edu.arsw.linkedList.LinkedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {
    
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
