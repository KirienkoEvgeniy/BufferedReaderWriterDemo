package org.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers(String fileLocation) {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(new Integer(i));
    }

    public void writeContentToFile(String fileLocation) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter nFile = new FileWriter(fileLocation);
            bufferedWriter = new BufferedWriter(nFile);
            for (Integer s : list) {
                bufferedWriter.write(s + "\n");
            }
        } finally {
            if (bufferedWriter != null) bufferedWriter.close();
        }
    }

    public void readContentFromFile(String fileLocation) throws FileNotExistLocationException, IOException, FileIsEmptyException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(fileLocation);
            bufferedReader = new BufferedReader(fileReader);
            Scanner scanner = new Scanner(fileReader);
            if (!scanner.hasNext()) {
                throw new FileIsEmptyException(" File -> " + fileLocation + "   is empty");
            }
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new FileNotExistLocationException(e.getMessage());
        } finally {
            if (fileReader != null) bufferedReader.close();
        }
    }
}

