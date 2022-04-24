package ru.avalon.vergentev.j120.labwork2;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class TextChecker {
    File file;
    FileReader fileReader;
    FileWriter fileWriter;
    StringBuilder data;
    String[] dataEachWord;
    Map<String, String> map;

    public TextChecker (File file) {
        try {
            this.file = file;
            if (!file.exists() || !file.canRead()) throw new SecurityException("File doesn't exist or can't be readable !!!");
            int symbolExisting;
            fileReader = new FileReader(file, StandardCharsets.UTF_8);
            data = new StringBuilder();
            while ((symbolExisting = fileReader.read()) != -1) {
                data.append((char)symbolExisting);
            }
            dataEachWord = data.toString().toLowerCase().split("[ |'{}.,:;!?@#¹$%^&*()=+_><»«—…\t\b\n\r\f]+");
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //METHODS
    public void printFileDataInConsole () {
        if (!file.exists() || !file.canRead())  throw new SecurityException("File can't be readable or doesn't exist !!!");
        try {
            int symbolExisting;
            fileReader = new FileReader(file, StandardCharsets.UTF_8);
            while ((symbolExisting = fileReader.read()) != -1) {
                System.out.print((char)symbolExisting);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printBuilder () {
        System.out.println(data);
    }

    public void printWordsArray () {
        for (String i : dataEachWord) System.out.println(i);
    }

    public void getReports () {
        try {
            map = new TreeMap<>();
            for (int i = 0; i < dataEachWord.length; i++) {
                int counter = 1;
                for (int j = i + 1; j < dataEachWord.length; j++) {
                    if (dataEachWord[i].equals(dataEachWord[j]) && !map.containsKey(dataEachWord[i])) {
                        counter++;
                    }
                }
                if (!map.containsKey(dataEachWord[i])) {
                    map.put(dataEachWord[i], String.valueOf(counter));
                }
            }
            StringBuilder temp = new StringBuilder();
            for (Object i : map.keySet()) {
                double k = (100 * (Double.parseDouble(map.get(i)))) / dataEachWord.length;
                temp.append('\n').append(i).append("=").append(map.get(i)).append(" <=> ").append(k).append("%");
            }
            File file = new File("report1.txt");
            fileWriter = new FileWriter(file, true);
            fileWriter.append(temp);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
