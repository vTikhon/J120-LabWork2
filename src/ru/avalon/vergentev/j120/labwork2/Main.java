package ru.avalon.vergentev.j120.labwork2;

public class Main {
    public static void main(String[] args) {
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>������� 1<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        MyProperties myProperties2 = new MyProperties(); //�������� ������������ ���� � ����������, �� � ������� ����������
//        myProperties.printFileInConsole();
        myProperties2.myPut("key1", "value1");
        myProperties2.myPut("key2", "value2");
        myProperties2.myPut("key3", "value3");
//        myProperties.printFileInConsole();
//        MyProperties myProperties2 = new MyProperties(new File("fileForTask1.txt")); //����������� ��� ���������� ����� � �������
//        myProperties2.printFileInConsole();


//            Properties testProperties = new Properties();
//            testProperties.put();






//        try {
//            DataTask1 dataTask1 = new DataTask1();
//            dataTask1.printInConsole();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        //��������� ������������ ������, ������� �������� � ���������
//        Map<String, String> dataHashMap = new HashMap<>();
//        dataHashMap.put("key1", "value1");
//        dataHashMap.put("key2", "value2");
//        dataHashMap.put("key3", "value3");
//        dataHashMap.put("key4", "value4");
//        //�������������� ��� �������� ��������� � StringBuffer, ������� ����� ������� � ����
//        StringBuffer data = new StringBuffer();
//        for (Map i : dataHashMap) {
//            data.append(i);
//        }
//        //���������� � ����� ���� �� ����� ����������
//        Task1 task1 = new Task1(new File("D:/Task2a-J120-VERGENTEV.txt"), data);
//        task1.writer(); //���������� ������ � ����
//        System.out.println("Print data of file:");
//        task1.printInConsole(); //������� ������ ����� � �������
//        System.out.print('\n');
//        System.out.println("Check is there set value in file:");
//        System.out.println(task1.finderValue("value3"));
//        System.out.print('\n');
//        System.out.println("Change element in a file:");
//        task1.finderValueAndRename("value3", "value27"); //������ �������� ���� �� ������


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
