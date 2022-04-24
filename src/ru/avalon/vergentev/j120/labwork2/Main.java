package ru.avalon.vergentev.j120.labwork2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>ЗАДАНИЕ 1<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//        MyProperties myProperties = new MyProperties(); //согласно заданию конструктор по умолчанию создаёт файл с заголовком
//        myProperties.printFileDataInConsole(); //выводим значения всего файла на консоль
//        myProperties.put("key1", "value1");
//        myProperties.put("key2", "value2");
//        myProperties.put("key3", "value3");
//        myProperties.store();
//
//        MyProperties myProperties2 = new MyProperties(new File("FileForTask1.txt")); //конструктор для считывания файла с данными
//        myProperties2.put("key4", "value4");
//        myProperties2.put("key5", "value5");
//        myProperties2.put("key6", "value6");
//        myProperties2.store(); //записываем в тот же файл новые значения
//        myProperties2.printFileDataInConsole(); //выводим значения всего файла на консоль
//        System.out.println('\n');
//        System.out.println("The value of the key2 is:");
//        System.out.println(myProperties2.get("key2")); //выводим значение ключа2
//        myProperties2.replace("key2", "value44"); //изменяем значение ключа2
//        System.out.println("The value of the key2 is:");
//        System.out.println(myProperties2.get("key2")); //выводим новое значение ключа2
//        myProperties2.remove("key2");
//        System.out.println("The value of the key2 is:");
//        System.out.println(myProperties2.get("key2")); //выводим новое значение ключа2
//        System.out.println("Is the value of the key2 exists?");
//        System.out.println(myProperties2.exists("key2"));
//        System.out.println("Is the value of the key3 exists?");
//        System.out.println(myProperties2.exists("key3"));
//        System.out.println('\n');
//        myProperties2.storeInNewFile("D:/fileForTask1.txt"); //записываем в новый файл новые значения
//        myProperties2.printFileDataInConsole(); //выводим значения всего файла на консоль

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>ЗАДАНИЕ 2<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//        TextChecker textChecker = new TextChecker(new File("Pushkin-Kapitanskaya_dochka-ch2.txt"));
//        textChecker.getReports();

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>ЗАДАНИЕ 3<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        Decripter decripter = new Decripter(new File("script.txt"));
//        decripter.printFileDataInConsole();
//        decripter.printDecriptData();
        decripter.dataDecripter();



    }
}
