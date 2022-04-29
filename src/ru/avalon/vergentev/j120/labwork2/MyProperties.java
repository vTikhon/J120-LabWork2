package ru.avalon.vergentev.j120.labwork2;
import java.io.*;
import java.util.*;

//ЗАДАНИЕ 1 - СОЗДАЁМ КЛАСС MyProperties АНАЛОГИЧНЫЙ БИБЛИОТЕЧНОМУ Properties (использовал коллекцию TreeMap)
public class MyProperties {
    File file, fileAbsolute;
    FileReader fileReader;
    FileWriter fileWriter;
    Map<String, String> map;
    StringBuilder data, title, dataWithoutTitle;
    String[] dataEachString;

    //CONSTRUCTORS
    //конструктор по умолчанию создаёт файл с заголовком и пустой набор ключ=значение
    public MyProperties() {
        title = new StringBuilder();
        title.append("#").append(new Date()).append('\n');
        String url = "MyProperties.txt";
        File file = new File(url);
        fileAbsolute = file.getAbsoluteFile();
        writer (file, title);
        reader(file);  //читаем данные из файла в память компьютера
    }

    //конструктор читает указанный файл и принимает наборы ключ=значение
    public MyProperties(File file) {
        this.file = file;
        reader(file);  //читаем данные из файла в память компьютера
    }


    //METHODS
    public boolean isLinkOnFileEmpty (File file) {
        return file == null;
    }

    //метод читающий файл и возвращающий данные в память компьютера
    public StringBuilder reader (File file) {
        if (isLinkOnFileEmpty(file)) {
            file = fileAbsolute;
        }
        if (!file.exists() || !file.canRead()) throw new SecurityException("File can't be readable or doesn't exist !!!");
        try {
            int symbolExisting;
            fileReader = new FileReader(file);
            data = new StringBuilder();
            while ((symbolExisting = fileReader.read()) != -1) {
                data.append((char)symbolExisting);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //сортируем data (заголовок\рабочие данные\коллекция)
        title = new StringBuilder();
        dataWithoutTitle = new StringBuilder();
        dataEachString = data.toString().split("\n", -1);  //запишем в массив каждую строку отдельно для того, чтобы потом пропустить или вернуть заголовок
        map = new TreeMap<>();
        for (int i = 0; i < dataEachString.length; i++) {
            if (i == 0) {  // dataEachString[i].charAt(0) == '#'
                title.append(dataEachString[i]);  //сохраняем заголовок с комментариями
            } else if (dataEachString[i].isEmpty()) {
                title.append('\n');  //сохраняем пустую строку
            } else {
                dataWithoutTitle.append(dataEachString[i]).append('\n');
                String[] temp = dataEachString[i].split("=");
                map.put(temp[0], temp[1]);    //помещаем ключ и значение в подходящую коллекцию TreeMap
            }
        }
        return data;
    }

    public void writer (File file, StringBuilder data) {
        try {
            if (isLinkOnFileEmpty(file)) {
                file = fileAbsolute;
            }
            if (!file.exists()) file.createNewFile();
            if (!file.canWrite()) throw new SecurityException("File can't be writable or doesn't exist !!!");
            fileWriter = new FileWriter(file, false);
            fileWriter.write(String.valueOf(data));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //вспомогательный метод который отслеживает содержимое файла выводя её в консоль
    public void printFileDataInConsole () {
        reader(file);
        System.out.println(data);
    }

    //метод записывающий данные в тот же файл, откуда он ранее был загружен
    public void store () {
        data = title;
        //считываем данные из актуальной коллекции и записываем её в строковые данные
        if (map != null) {
            for (Object i : map.keySet()) {
                data.append('\n').append(i).append("=").append(map.get(i));
            }
        }
        //записываем данные в файл
        writer(file, data);
    }

    //метод записывающий данные в файл с заданным именем
    public void storeInNewFile (String url) {
        if (url.isEmpty()) throw new IllegalArgumentException("URL can't be empty");
        file = new File(url);
        store();
    }

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

    public boolean isValueExist (String key) {
        return map.get(key) != null;
    }

}
