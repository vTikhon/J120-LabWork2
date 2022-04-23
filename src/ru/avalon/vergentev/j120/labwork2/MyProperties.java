package ru.avalon.vergentev.j120.labwork2;
import java.io.*;
import java.util.*;

//ЗАДАНИЕ 1 - СОЗДАЁМ КЛАСС MyProperties АНАЛОГИЧНЫЙ БИБЛИОТЕЧНОМУ Properties
public class MyProperties {
    File file, fileAbsolute;
    FileReader fileReader;
    FileWriter fileWriter;
    Map<String, String> map;
    StringBuilder data;
    String[] dataInLines;


    //CONSTRUCTORS
    public MyProperties() {
        try {
            File file = new File("FileForTask1.txt");
            fileAbsolute = file.getAbsoluteFile();
            if (!file.exists()) {
                fileWriter = new FileWriter(file);
                fileWriter.append("#").append(new Date().toString()).append('\n');
                fileWriter.close();
            }
            int symbolExisting;
            fileReader = new FileReader(file);
            data = new StringBuilder();
            while ((symbolExisting = fileReader.read()) != -1) {
                data.append((char)symbolExisting);
            }
            dataInLines = data.toString().split("\n", -1);  //запишем в массив каждую строку отдельно для того чтобы потом пропустить или вернуть заголовок
            map = new HashMap<>();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyProperties(File file) {
        try {
            this.file = file;
            if (!file.exists() || !file.canRead()) throw new SecurityException("File doesn't exist or can't be readable !!!");
            int symbolExisting;
            fileReader = new FileReader(file);
            data = new StringBuilder();
            while ((symbolExisting = fileReader.read()) != -1) {
                data.append((char)symbolExisting);
            }
            dataInLines = data.toString().split("\n", -1);  //запишем в массив каждую строку отдельно для того чтобы потом пропустить или вернуть заголовок
            map = new HashMap<>();
            for (int i = 2; i < dataInLines.length; i++) {   //пропускаем заголовок и пустую строку
                new StringBuilder().append(dataInLines[i]);
                String[] temp = dataInLines[i].split("=");
                map.put(temp[0], temp[1]);    //помешаем ключ и значение в подходящую коллекцию HashMap
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //METHODS
    public void printFileDataInConsole () {
        if (file == null) {
            file = fileAbsolute;
        }
        if (!file.exists() || !file.canRead())  throw new SecurityException("File can't be readable or doesn't exist !!!");

        try {
            int symbolExisting;
            fileReader = new FileReader(file.getAbsoluteFile());
            while ((symbolExisting = fileReader.read()) != -1) {
                System.out.print((char)symbolExisting);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //записываем в файл произвольные данные
    public void put (String key, String value) {
        map.put(key, value);
    }

    public String get (String key) {
        return map.get(key);
    }

    public void replace (String key, String value) {
        if (map.get(key) != null) map.replace(key, value);
    }

    public void remove (String key) {
        map.remove(key);
    }

    public boolean exists (String key) {
        return map.get(key) != null;
    }

    public void store () {
        if (file == null) {
            file = fileAbsolute;
        }
        if (!file.exists() || !file.canWrite()) throw new SecurityException("File can't be writable or doesn't exist !!!");
        try {
            data = new StringBuilder();
            data.append(dataInLines[0]).append('\n').append(dataInLines[1]);
            if (map != null) {
                for (Object i : map.keySet()) {
                    data.append('\n').append(i).append("=").append(map.get(i));
                }
            }
            fileWriter = new FileWriter(file, false);
            fileWriter.write(String.valueOf(data));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storeInNewFile (String url) {
        if (url == null) {
            assert false;
            if (!url.isEmpty()) throw new IllegalArgumentException("URL can't be empty");
        }
        try {
            file = new File(url);
            if (!file.exists()) {
                file.createNewFile();
            }
            data = new StringBuilder();
            data.append(dataInLines[0]).append('\n').append(dataInLines[1]);
            if (map != null) {
                for (Object i : map.keySet()){
                    data.append('\n').append(i).append("=").append(map.get(i));
                }
            }
            fileWriter = new FileWriter(file, false);
            fileWriter.write(String.valueOf(data));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
