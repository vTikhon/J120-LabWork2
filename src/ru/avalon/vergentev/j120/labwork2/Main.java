package ru.avalon.vergentev.j120.labwork2;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>ЗАДАНИЕ 1<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        //формируем произвольные данные, которые помещаем в StringBuilder
        StringBuilder values = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            values.append("value").append(i).append("=key").append(i).append('\n');
        }
        //определяем в какой файл мы будем записывать данные
        Task1 task1 = new Task1(new File("D:/Task2a-J120-VERGENTEV.txt"), values);
        task1.writer();
        task1.print();




    }
}
