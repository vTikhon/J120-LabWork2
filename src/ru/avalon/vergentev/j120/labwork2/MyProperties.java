package ru.avalon.vergentev.j120.labwork2;
import java.io.*;
import java.util.*;

//������� 1 - ������� ����� MyProperties ����������� ������������� Properties (����������� ��������� TreeMap)
public class MyProperties {
    File file, fileAbsolute;
    FileReader fileReader;
    FileWriter fileWriter;
    Map<String, String> map;
    StringBuilder data, title, dataWithoutTitle;
    String[] dataEachString;

    //CONSTRUCTORS
    //����������� �� ��������� ������ ���� � ���������� � ������ ����� ����=��������
    public MyProperties() {
        title = new StringBuilder();
        title.append("#").append(new Date()).append('\n');
        String url = "MyProperties.txt";
        File file = new File(url);
        fileAbsolute = file.getAbsoluteFile();
        writer (file, title);
        reader(file);  //������ ������ �� ����� � ������ ����������
    }

    //����������� ������ ��������� ���� � ��������� ������ ����=��������
    public MyProperties(File file) {
        this.file = file;
        reader(file);  //������ ������ �� ����� � ������ ����������
    }


    //METHODS
    public boolean isLinkOnFileEmpty (File file) {
        return file == null;
    }

    //����� �������� ���� � ������������ ������ � ������ ����������
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
        //��������� data (���������\������� ������\���������)
        title = new StringBuilder();
        dataWithoutTitle = new StringBuilder();
        dataEachString = data.toString().split("\n", -1);  //������� � ������ ������ ������ �������� ��� ����, ����� ����� ���������� ��� ������� ���������
        map = new TreeMap<>();
        for (int i = 0; i < dataEachString.length; i++) {
//            System.out.println(dataEachString[i].charAt(0) == '#');
            if (i == 0) {  // dataEachString[i].charAt(0) == '#'
                title.append(dataEachString[i]);  //��������� ��������� � �������������
            } else if (dataEachString[i].isEmpty()) {
                title.append('\n');  //��������� ������ ������
            } else {
                dataWithoutTitle.append(dataEachString[i]).append('\n');
                String[] temp = dataEachString[i].split("=");
                map.put(temp[0], temp[1]);    //�������� ���� � �������� � ���������� ��������� TreeMap
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

    //��������������� ����� ������� ����������� ���������� ����� ������ � � �������
    public void printFileDataInConsole () {
        reader(file);
        System.out.println(data);
    }

    //����� ������������ ������ � ����
    public void store () {
        data = title;
        //��������� ������ �� ���������� ��������� � ���������� � � ��������� ������
        if (map != null) {
            for (Object i : map.keySet()) {
                data.append('\n').append(i).append("=").append(map.get(i));
            }
        }
        //���������� ������ � ����
        writer (file, data);
    }

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
