package ru.avalon.vergentev.j120.labwork2;
import java.io.*;
import java.util.*;

public class Task1 {
    File file;
    StringBuffer data;
    FileWriter fileTask1Writer = null;
    FileInputStream fileTask1Reader = null;

    public Task1(File file, StringBuffer data) {
        this.file = file;
        this.data = data;
    }

    //записываем в файл произвольные данные
    public void writer () {
        try {
            fileTask1Writer = new FileWriter(file, false);
            fileTask1Writer.write(data.toString());
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
    public void printInConsole () {
        int dataInfo;
        try {
            fileTask1Reader = new FileInputStream(file);
            while ((dataInfo = fileTask1Reader.read()) != -1) {
                System.out.print((char)dataInfo);
            }
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

    //метод нахождения заданного значения в данных
    public String finderValue (String value) {
        int dataInfo;
        try {
            fileTask1Reader = new FileInputStream(file);
            StringBuilder temp = new StringBuilder();
            while ((dataInfo = fileTask1Reader.read()) != -1) {
                temp.append((char)dataInfo);
            }
            String[] temp2 = temp.toString().split("[=\n]");
            for (String i : temp2) {
                if (i.equals(value)) {
                    return i;
                }
            }
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
        return null;
    }

    //метод нахождения заданного значения в данных
    public void finderValueAndRename (String value, String value2) {
        int dataInfo;
        try {
            fileTask1Reader = new FileInputStream(file);
            StringBuilder temp = new StringBuilder();
            while ((dataInfo = fileTask1Reader.read()) != -1) {
                temp.append((char)dataInfo);
            }
            String[] temp2 = temp.toString().split("[=\n]");
            StringBuilder temp3 = new StringBuilder();
            for (String i : temp2) {
                if (i.equals(value)) {
                    i = value2;
                }
                temp3.append(i + "=").append('\n');
            }
            System.out.println(temp3);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task1 task1 = (Task1) o;
        return Objects.equals(file, task1.file) && Objects.equals(data, task1.data) && Objects.equals(fileTask1Writer, task1.fileTask1Writer) && Objects.equals(fileTask1Reader, task1.fileTask1Reader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, data, fileTask1Writer, fileTask1Reader);
    }
}
