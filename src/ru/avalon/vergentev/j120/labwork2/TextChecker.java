package ru.avalon.vergentev.j120.labwork2;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;


public class TextChecker {
    File file;
    FileReader fileReader;
    FileWriter fileWriter;
    StringBuilder data;
    String[] dataEachWord, dataEachString;
    Map<String, Integer> map, sortedMapByValue;

    public TextChecker (File file) {
        try {
            this.file = file;
            if (!file.exists() || !file.canRead()) throw new SecurityException("File doesn't exist or can't be readable !!!");
            int symbolExisting;
            fileReader = new FileReader(file, StandardCharsets.UTF_8);
            data = new StringBuilder();
            while ((symbolExisting = fileReader.read()) != -1) {
                data.append((char)symbolExisting);
            }
            dataEachWord = data.toString().toLowerCase().split("[ |'{}.,:;!?@#є$%^&*()=+_><їЂЧЕ\t\b\n\r\f]+");
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getReports () {
        try {
            //создаЄм коллекцию TreeMap, котора€ сортирует список по алфавиту (необходимо дл€ report1.txt)
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
            //переводим отсортированную коллекцию по алфавиту без повторений в пам€ть StringBuilder
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

            //дл€ report2.txt переводим предыдущую коллекцию TreeMap в LinkedHashMap так, что теперь сортировка списка была по значению, а не по ключу
            sortedMapByValue = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey,
                                                Map.Entry::getValue,
                                                (e1, e2) -> e1, LinkedHashMap::new));

            //переводим отсортированную коллекцию по значени€м в пам€ть StringBuilder
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
