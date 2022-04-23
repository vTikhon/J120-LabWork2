package ru.avalon.vergentev.j120.labwork2;
import java.io.*;
import java.util.*;

//ЗАДАНИЕ 1 - СОЗДАЁМ КЛАСС MyProperties АНАЛОГИЧНЫЙ БИБЛИОТЕЧНОМУ Properties
public class MyProperties {
    File file;
    FileReader fileReader;
    FileWriter fileWriter;
    Map<String, String> map;
    StringBuilder data;
    String[] title;


    //CONSTRUCTORS
    public MyProperties() {
        try {
            fileWriter = new FileWriter("fileForTask1.txt");
            fileWriter.append("#").append(new Date().toString()).append('\n');
            fileWriter.close();
            map = new HashMap<>();
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
            data = new StringBuilder();
            while ((dataExisting = fileReader.read()) != -1) {
                data.append((char)dataExisting);
            }
            title = data.toString().split("[\n]");  //запишем в массив каждую строку отдельно для того чтобы потом пропустить или вернуть заголовок
            map = new HashMap<>();
            for (int i = 2; i < title.length; i++) {   //пропускаем заголовок и пустую строку
                new StringBuilder().append(title[i]);
                String[] temp = title[i].split("[=]");
                map.put(temp[0], temp[1]);    //помешаем ключ и значение в подходящую коллекцию HashMap
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //METHODS
    public void printFileDataInConsole () {
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
        map.put(key, value);
    }

    public String myGet (String key) {
        return map.get(key);
    }

    public void myReplace (String key, String value) {
        if (map.get(key) != null) map.put(key, value);
    }

    public void myRemove (String key) {
        map.remove(key);
    }

    public boolean myExists (String key) {
        return map.get(key) != null;
    }

    public void myStore () {
        if (!file.exists() || !file.canWrite())  throw new SecurityException("File can't be writable or doesn't exist !!!");
        try {
            System.out.println("i am crying");
            data = new StringBuilder();
            data.append(title[0]).append('\n').append(title[1]);
            for (Object i : map.keySet()){
                data.append('\n').append(i).append("=").append(map.get(i));
        }
            fileWriter = new FileWriter(file, false);
            fileWriter.write(String.valueOf(data));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void myStoreInNewFile (String url) {
        if (url == null) {
            assert false;
            if (!url.isEmpty()) throw new IllegalArgumentException("URL can't be empty");
        }
        try {
            file = new File(url);
            if (!file.exists()) {
                file.createNewFile();
            };
            data = new StringBuilder();
            data.append(title[0]).append('\n').append(title[1]);
            for (Object i : map.keySet()){
                data.append('\n').append(i).append("=").append(map.get(i));
            }
            fileWriter = new FileWriter(file, false);
            fileWriter.write(String.valueOf(data));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
