package ru.avalon.vergentev.j120.labwork2;
import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

//������� 2 - ����� ��������� ���������� � ������
public class TextChecker {
    File file;
    FileReader fileReader;
    FileWriter fileWriter;
    StringBuilder data;
    String[] dataEachWord, dataEachString;
    Map<String, Integer> map, sortedMapByValue;

    //CONSTRUCTORS
    public TextChecker (File file) {
        this.file = file;
        reader(file);
    }

    //METHODS
    //����� �������� ���� � ������������ ������ � ������ ����������
    public String[] reader (File file) {
        if (!file.exists() || !file.canRead())  throw new SecurityException("File can't be readable or doesn't exist !!!");
        int symbolExisting;
        try {
            fileReader = new FileReader(file, StandardCharsets.UTF_8);
            data = new StringBuilder();
            while ((symbolExisting = fileReader.read()) != -1) {
                data.append((char)symbolExisting);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //� ����� ��������� ������ ��������� ���� � ������� ����� ��������
        dataEachWord = data.toString().toLowerCase().split("[ |'{}.,:;!?@#�$%^&*()=+_><����\t\b\n\r\f]+");
        return dataEachWord;
    }

    //����� ������������ ������ � ����
    public void writer (File file, StringBuilder data) {
        try {
            if (!file.exists()) file.createNewFile();
            if (!file.canWrite()) throw new SecurityException("File can't be writable or doesn't exist !!!");
            fileWriter = new FileWriter(file, false);
            fileWriter.write(String.valueOf(data));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getReports () {
        //������ ��������� TreeMap, ������� ��������� ������ �� �������� (���������� ��� report1.txt)
        map = new TreeMap<>();
        for (int i = 0; i < dataEachWord.length; i++) {
            int counter = 1;
            for (int j = i + 1; j < dataEachWord.length; j++) {
                if (dataEachWord[i].equals(dataEachWord[j]) && !map.containsKey(dataEachWord[i])) {
                    counter++;
                }
            }
            if (!map.containsKey(dataEachWord[i])) {
                map.put(dataEachWord[i], counter);
            }
        }
        //��������� ��������������� ��������� �� �������� ��� ���������� � ������ StringBuilder
        StringBuilder data = new StringBuilder();
        for (Object i : map.keySet()) {
            double k = (double)(100 * (map.get(i))) / dataEachWord.length;
            data.append('\n').append(i).append("=").append(map.get(i)).append(" <=> ").append(k).append("%");
        }
        //���������� � ���� report1.txt
        file = new File("report1.txt");
        writer(file, data);
        //��� report2.txt ��������� ���������� ��������� TreeMap � LinkedHashMap ���, ��� ������ ���������� ������ ���� �� ��������, � �� �� �����
        sortedMapByValue = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        //��������� ��������������� ��������� �� ��������� � ������ StringBuilder
        data.setLength(0);
        for (Object i : sortedMapByValue.keySet()) {
            double k = (double)(100 * (sortedMapByValue.get(i))) / dataEachWord.length;
            data.append('\n').append(sortedMapByValue.get(i)).append("=").append(i).append(" <=> ").append(k).append("%");
        }
        dataEachString = data.toString().toLowerCase().split("\n");
        data.setLength(0);
        for (int i = dataEachString.length-1; i >= 0; i--) {
            data.append('\n').append(dataEachString[i]);
        }
        //���������� � ���� report2.txt
        file = new File("report2.txt");
        writer(file, data);
    }
}
