package ru.avalon.vergentev.j120.labwork2;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        //создаём файл и записываем в него произвольные данные
        File fileTask1 = new File("D:/Task2a-J120-VERGENTEV.txt");
        FileWriter fileTask1Writer = null;
        StringBuilder values = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            values.append("value").append(i).append("=key").append(i).append('\n');
        }
        try {
            fileTask1Writer = new FileWriter(fileTask1, false);
            fileTask1Writer.write(values.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileTask1Writer != null;
                fileTask1Writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //считываем данные из файла в консоль
        FileInputStream fileTask1Reader = null;
        int valuesInfo;
        try {
            fileTask1Reader = new FileInputStream(fileTask1);
            while ((valuesInfo=fileTask1Reader.read()) != -1) {
                System.out.print((char)valuesInfo);
            }
            System.out.println(fileTask1Reader.read());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileTask1Reader != null;
                fileTask1Reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
