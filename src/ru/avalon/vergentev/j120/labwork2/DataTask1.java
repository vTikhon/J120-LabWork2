package ru.avalon.vergentev.j120.labwork2;

import java.io.*;
import java.util.*;

public class DataTask1 {
    Properties dataForTask1;
    File fileForDataTask1;
    FileInputStream fileInputStream;

    //CONSTRUCTORS
    public DataTask1() throws IOException {
        fileForDataTask1 = new File("fileForDataTask1.txt");
        if (!fileForDataTask1.exists()) {
            fileForDataTask1.createNewFile();
            dataForTask1 = new Properties();
            dataForTask1.put("key1", "value1");
            dataForTask1.put("key2", "value2");
            dataForTask1.put("key3", "value3");
            dataForTask1.put("key4", "value4");
            dataForTask1.store(new FileWriter(fileForDataTask1), null);
        } else {
            dataForTask1 = new Properties();
            dataForTask1.load(new FileReader(fileForDataTask1));
        }
    }


    //METHODS
    //печатаем данные из файла в консоль
    public void printInConsole() {
        int dataInfo;
        try {
            fileInputStream = new FileInputStream(fileForDataTask1);
            while ((dataInfo = fileInputStream.read()) != -1) {
                System.out.print((char) dataInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileInputStream != null;
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
