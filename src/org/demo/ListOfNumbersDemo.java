package org.demo;

import java.io.File;
import java.io.IOException;

public class ListOfNumbersDemo {

    public static void main(String[] args) {
        String fileLocation = "D:\\Hillel\\fileLocation.txt";
        String fileLocationNotExist = "D:\\Hillel\\file.txt";
        String fileLocationEmptyFile = "D:\\Hillel\\emptyFile.txt";

        File fileTest = new File(fileLocation);
        ListOfNumbers listOfNumbers = new ListOfNumbers(fileLocation);

        if (fileTest.exists()) {
            System.out.println("File exists");
            try {
                listOfNumbers.writeContentToFile(fileLocation);
            } catch (IOException e) {
                System.out.println("Cannot write to file");
            }
        } else {
            try {
                boolean created = fileTest.createNewFile();
                if (created)
                    System.out.println("File has been created");
                listOfNumbers.writeContentToFile(fileLocation);
            } catch (IOException ex) {
                System.out.println("Cannot write to file");
            }
        }

        try {
            listOfNumbers.readContentFromFile(fileLocation);
            System.out.println();
            listOfNumbers.readContentFromFile(fileLocationNotExist);
        } catch (FileNotExistLocationException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FileIsEmptyException e) {
            System.out.println(e.getMessage());
        }
        try {
            listOfNumbers.readContentFromFile(fileLocationEmptyFile);
        } catch (FileNotExistLocationException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FileIsEmptyException e) {
            System.out.println(e.getMessage());
        }
    }

}
