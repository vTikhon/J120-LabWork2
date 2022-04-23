package ru.avalon.vergentev.j120.labwork2;
import java.io.*;
import java.util.*;

public class MyProperties {
    File file;
    FileReader fileReader;
    FileWriter fileWriter;


    //CONSTRUCTORS
    public MyProperties() {
        try {
            fileWriter = new FileWriter("fileForTask1.txt");
            fileWriter.append("#").append(new Date().toString()).append('\n');
            fileWriter.append("\nkey1=value1").append("\nkey2=value2").append("\nkey3=value3");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyProperties(File file) throws SecurityException {
        try {
            this.file = file;
            if (!file.exists() || !file.canRead()) throw new SecurityException("File doesn't exist or can't be readable !!!");
            int dataExisting;
            fileReader = new FileReader(file);
            StringBuilder temp = new StringBuilder();
            while ((dataExisting = fileReader.read()) != -1) {
                temp.append((char)dataExisting);
            }
            String[] temp2 = temp.toString().split("[\n]");  //запишем в массив каждую строку отдельно для того чтобы потом пропустить заголовок
            Map<String, String> map = new HashMap<>();
            for (int i = 2; i < temp2.length; i++) {   //пропускаем заголовок и пустую строку
                new StringBuilder().append(temp2[i]);
                String[] temp3 = temp2[i].split("[=]");
                map.put(temp3[0], temp3[1]);    //помешаем ключ и значение в подходящую коллекцию HashMap
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //METHODS
    public void printFileInConsole () {
        if (!file.exists() || !file.canRead())  throw new SecurityException("File can't be readable");
        int dataInfo;
        try {
            fileReader = new FileReader(file);
            while ((dataInfo = fileReader.read()) != -1) {
                System.out.print((char)dataInfo);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //записываем в файл произвольные данные
    public void myPut (String key, String value) {
        if (!file.exists() || !file.canWrite())  throw new SecurityException("File can't be writable");
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write('\n' + key + "=" + value);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
