package ru.avalon.vergentev.j120.labwork2;
import java.io.*;

public class Task1 {
    File file;
    StringBuilder values;
    FileWriter fileTask1Writer = null;
    FileInputStream fileTask1Reader = null;

    public Task1(File file, StringBuilder values) {
        this.file = file;
        this.values = values;
    }

    //записываем в файл произвольные данные
    public void writer () {
        try {
            fileTask1Writer = new FileWriter(file, false);
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
    }

    //печатаем данные из файла в консоль
    public void print () {
        int valuesInfo;
        try {
            fileTask1Reader = new FileInputStream(file);
            while ((valuesInfo = fileTask1Reader.read()) != -1) {
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
