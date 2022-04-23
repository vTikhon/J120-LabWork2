package ru.avalon.vergentev.j120.labwork2;

public class Main {
    public static void main(String[] args) {
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>ЗАДАНИЕ 1<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        MyProperties myProperties2 = new MyProperties(); //согласно конструктору файл с заголовком, но с пустыми значениями
//        myProperties.printFileInConsole();
        myProperties2.myPut("key1", "value1");
        myProperties2.myPut("key2", "value2");
        myProperties2.myPut("key3", "value3");
//        myProperties.printFileInConsole();
//        MyProperties myProperties2 = new MyProperties(new File("fileForTask1.txt")); //конструктор для считывания файла с данными
//        myProperties2.printFileInConsole();


//            Properties testProperties = new Properties();
//            testProperties.put();






//        try {
//            DataTask1 dataTask1 = new DataTask1();
//            dataTask1.printInConsole();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        //формируем произвольные данные, которые помещаем в коллекцию
//        Map<String, String> dataHashMap = new HashMap<>();
//        dataHashMap.put("key1", "value1");
//        dataHashMap.put("key2", "value2");
//        dataHashMap.put("key3", "value3");
//        dataHashMap.put("key4", "value4");
//        //перезаписываем все элементы коллекции в StringBuffer, которую потом запишем в файл
//        StringBuffer data = new StringBuffer();
//        for (Map i : dataHashMap) {
//            data.append(i);
//        }
//        //определяем в какой файл мы будем записывать
//        Task1 task1 = new Task1(new File("D:/Task2a-J120-VERGENTEV.txt"), data);
//        task1.writer(); //записываем данные в файл
//        System.out.println("Print data of file:");
//        task1.printInConsole(); //выводим данные файла в консоль
//        System.out.print('\n');
//        System.out.println("Check is there set value in file:");
//        System.out.println(task1.finderValue("value3"));
//        System.out.print('\n');
//        System.out.println("Change element in a file:");
//        task1.finderValueAndRename("value3", "value27"); //меняем значение одно на другое


        //формируем произвольные данные, которые помещаем в StringBuilder
//        StringBuffer data = new StringBuffer();
//        for (int i = 1; i < 10; i++) {
//            data.append("value").append(i).append("=key").append(i).append('\n');
//        }
//        //определяем в какой файл мы будем записывать данные
//        Task1 task1 = new Task1(new File("D:/Task2a-J120-VERGENTEV.txt"), data);
//        System.out.println("Print data of file:");
//        task1.writer();
//        task1.printInConsole();
//        System.out.print('\n');
//        System.out.println("Check is there set value in file:");
//        System.out.println(task1.finderValue("value3"));




    }
}
