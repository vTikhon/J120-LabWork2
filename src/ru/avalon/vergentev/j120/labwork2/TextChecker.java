package ru.avalon.vergentev.j120.labwork2;
import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

//ЗАДАНИЕ 2 - класс считающий повторения в тексте
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
    //метод читающий файл и возвращающий данные в память компьютера
    public StringBuilder reader (File file) {
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
        //и сразу формируем массив отдельных слов с которым будем работать
        dataEachWord = data.toString().toLowerCase().split("[ |'{}.,:;!?@#№$%^&*()=+_><»«—…\t\b\n\r\f]+");
        return data;
    }

    public void getReports () {
        try {
            //создаём коллекцию TreeMap, которая сортирует список по алфавиту (необходимо для report1.txt)
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
            //переводим отсортированную коллекцию по алфавиту без повторений в память StringBuilder
            StringBuilder temp = new StringBuilder();
            for (Object i : map.keySet()) {
                double k = (double)(100 * (map.get(i))) / dataEachWord.length;
                temp.append('\n').append(i).append("=").append(map.get(i)).append(" <=> ").append(k).append("%");
            }
            //записываем в файл report1.txt
            File file = new File("report1.txt");
            fileWriter = new FileWriter(file, false);
            fileWriter.append(temp);
            fileWriter.close();

            //для report2.txt переводим предыдущую коллекцию TreeMap в LinkedHashMap так, что теперь сортировка списка была по значению, а не по ключу
            sortedMapByValue = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey,
                                                Map.Entry::getValue,
                                                (e1, e2) -> e1, LinkedHashMap::new));

            //переводим отсортированную коллекцию по значениям в память StringBuilder
            temp.setLength(0);
            for (Object i : sortedMapByValue.keySet()) {
                double k = (double)(100 * (sortedMapByValue.get(i))) / dataEachWord.length;
                temp.append('\n').append(sortedMapByValue.get(i)).append("=").append(i).append(" <=> ").append(k).append("%");
            }
            dataEachString = temp.toString().toLowerCase().split("\n");
            temp.setLength(0);
            for (int i = dataEachString.length-1; i >= 0; i--) {
                temp.append('\n').append(dataEachString[i]);
            }
            //записываем в файл report2.txt
            File file2 = new File("report2.txt");
            fileWriter = new FileWriter(file2, false);
            fileWriter.append(temp);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
