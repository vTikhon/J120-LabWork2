package ru.avalon.vergentev.j120.labwork2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>������� 1<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        MyProperties myProperties = new MyProperties(); //�������� ������������ ���� � ����������, �� � ������� ����������
//        myProperties.printFileDataInConsole(); //������� �������� ����� ����� �� �������

        myProperties.myPut("key1", "value1");
        myProperties.myPut("key2", "value2");
        myProperties.myPut("key3", "value3");

//        myProperties.myStore();
//        myProperties.printFileDataInConsole();

//        MyProperties myProperties2 = new MyProperties(new File("fileForTask1.txt")); //����������� ��� ���������� ����� � �������
//        myProperties2.printFileDataInConsole(); //������� �������� ����� ����� �� �������
//        System.out.println('\n');
//        System.out.println("The value of the key2 is:");
//        System.out.println(myProperties2.myGet("key2")); //������� �������� �����2
//        myProperties2.myReplace("key2", "value44"); //�������� �������� �����2
//        System.out.println("The value of the key2 is:");
//        System.out.println(myProperties2.myGet("key2")); //������� ����� �������� �����2
//        myProperties2.myRemove("key2");
//        System.out.println("The value of the key2 is:");
//        System.out.println(myProperties2.myGet("key2")); //������� ����� �������� �����2
//        System.out.println("Is the value of the key2 exists?");
//        System.out.println(myProperties2.myExists("key2"));
//        System.out.println("Is the value of the key3 exists?");
//        System.out.println(myProperties2.myExists("key3"));
//        System.out.println('\n');
//        myProperties2.myStore(); //���������� � ��� �� ���� ����� ��������
//        myProperties2.myStoreInNewFile("D:/fileForTask1.txt"); //���������� � ����� ���� ����� ��������
//        myProperties2.printFileDataInConsole(); //������� �������� ����� ����� �� �������






    }
}
