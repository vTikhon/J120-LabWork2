package ru.avalon.vergentev.j120.labwork2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>������� 1<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        //��������� ������������ ������, ������� �������� � ���������
        ArrayList<Data> dataArrayList = new ArrayList<>();
        dataArrayList.add(new Data<>("key1", "value1"));
        dataArrayList.add(new Data<>("key2", "value2"));
        dataArrayList.add(new Data<>("key3", "value3"));
        dataArrayList.add(new Data<>("key4", "value4"));
        dataArrayList.add(new Data<>("key5", "value5"));
        //�������������� ��� �������� ��������� � StringBuffer, ������� ����� ������� � ����
        StringBuffer data = new StringBuffer();
        for (ArrayList i : dataArrayList) {
            data.append(i);
        }
        //���������� � ����� ���� �� ����� ����������
        Task1 task1 = new Task1(new File("D:/Task2a-J120-VERGENTEV.txt"), data);
        task1.writer(); //���������� ������ � ����
        System.out.println("Print data of file:");
        task1.printInConsole(); //������� ������ ����� � �������
        System.out.print('\n');
        System.out.println("Check is there set value in file:");
        System.out.println(task1.finderValue("value3"));


        //��������� ������������ ������, ������� �������� � StringBuilder
//        StringBuffer data = new StringBuffer();
//        for (int i = 1; i < 10; i++) {
//            data.append("value").append(i).append("=key").append(i).append('\n');
//        }
//        //���������� � ����� ���� �� ����� ���������� ������
//        Task1 task1 = new Task1(new File("D:/Task2a-J120-VERGENTEV.txt"), data);
//        System.out.println("Print data of file:");
//        task1.writer();
//        task1.printInConsole();
//        System.out.print('\n');
//        System.out.println("Check is there set value in file:");
//        System.out.println(task1.finderValue("value3"));




    }
}
