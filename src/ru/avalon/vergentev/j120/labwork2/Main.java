package ru.avalon.vergentev.j120.labwork2;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>TASK 1<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        MyProperties myProperties = new MyProperties();
        myProperties.printFileDataInConsole(); //печатаем в консоль всё содержимое файла
        myProperties.put("key1", "value1");
        myProperties.put("key2", "value2");
        myProperties.put("key3", "value3");
        myProperties.store(); //записываем данные в файл
        myProperties.printFileDataInConsole(); //печатаем в консоль всё содержимое файла

        MyProperties myProperties2 = new MyProperties(new File("MyProperties.txt"));
        myProperties2.put("key4", "value4");
        myProperties2.put("key5", "value5");
        myProperties2.put("key6", "value6");
        myProperties2.store(); //записываем данные в файл
        myProperties2.printFileDataInConsole(); //печатаем в консоль всё содержимое файла
        System.out.println('\n');
        System.out.println("The value of the key2 is:");
        System.out.println(myProperties2.get("key2")); //поиск по ключу
        myProperties2.replace("key2", "value44"); //замена значений по ключу
        System.out.println("The value of the key2 is:");
        System.out.println(myProperties2.get("key2")); //снова проверяем значение (уже изменённое)
        myProperties2.remove("key2"); //удаляем значение по ключу
        System.out.println("The value of the key2 is:");
        System.out.println(myProperties2.get("key2")); //снова проверяем, что его удалили
        System.out.println("Is the value of the key2 exists?");
        System.out.println(myProperties2.isValueExist("key2"));
        System.out.println("Is the value of the key3 exists?");
        System.out.println(myProperties2.isValueExist("key3"));
        System.out.println('\n');
        myProperties2.storeInNewFile("MyPropertiesByUrl.txt"); //записываем данные в файл по URL или названию
        myProperties2.printFileDataInConsole(); //печатаем в консоль всё содержимое файла
        System.out.println('\n');

    }
}
