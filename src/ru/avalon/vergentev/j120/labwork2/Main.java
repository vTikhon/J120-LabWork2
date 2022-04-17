package ru.avalon.vergentev.j120.labwork2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>ЗАДАНИЕ 1<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        //формируем произвольные данные, которые помещаем в коллекцию
        ArrayList<Data> dataArrayList = new ArrayList<>();
        dataArrayList.add(new Data<>("key1", "value1"));
        dataArrayList.add(new Data<>("key2", "value2"));
        dataArrayList.add(new Data<>("key3", "value3"));
        dataArrayList.add(new Data<>("key4", "value4"));
        dataArrayList.add(new Data<>("key5", "value5"));
        //перезаписываем все элементы коллекции в StringBuffer, которую потом запишем в файл
        StringBuffer data = new StringBuffer();
        for (ArrayList i : dataArrayList) {
            data.append(i);
        }
        //определяем в какой файл мы будем записывать
        Task1 task1 = new Task1(new File("D:/Task2a-J120-VERGENTEV.txt"), data);
        task1.writer(); //записываем данные в файл
        System.out.println("Print data of file:");
        task1.printInConsole(); //выводим данные файла в консоль
        System.out.print('\n');
        System.out.println("Check is there set value in file:");
        System.out.println(task1.finderValue("value3"));


        //формируем произвольные данные, которые помещаем в StringBuilder
//        StringBuffer data = new StringBuffer();
//        for (int i = 1; i < 10; i++) {
//            data.append("value").append(i).append("=key").append(i).append('\n');
//        }
//        //определяем в какой файл мы будем записывать данные
//        Task1 task1 = new Task1(new File("D:/Task2a-J120-VERGENTEV.txt"), data);
//        System.out.println("Print data of file:");
//        task1.writer();
//        task1.printInConsole();
//        System.out.print('\n');
//        System.out.println("Check is there set value in file:");
//        System.out.println(task1.finderValue("value3"));




    }
}
