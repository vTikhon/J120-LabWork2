package ru.avalon.vergentev.j120.labwork2;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class Decripter {
    File file;
    FileReader fileReader;
    FileWriter fileWriter;
    StringBuilder data, dataWithoutComments;
    String[] dataEachString, dataEachStringForPrint, dataEachStringForSet;
    Map<String, Integer> map;

    public Decripter (File file) {
        try {
            this.file = file;
            if (!file.exists() || !file.canRead()) throw new SecurityException("File doesn't exist or can't be readable !!!");
            int symbolExisting;
            fileReader = new FileReader(file);
            data = new StringBuilder();
            while ((symbolExisting = fileReader.read()) != -1) {
                data.append((char)symbolExisting);
            }
            dataEachString = data.toString().split("\n");
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //METHODS
    public void printFileDataInConsole () {
        if (!file.exists() || !file.canRead())  throw new SecurityException("File can't be readable or doesn't exist !!!");
        try {
            int symbolExisting;
            fileReader = new FileReader(file);
            while ((symbolExisting = fileReader.read()) != -1) {
                System.out.print((char)symbolExisting);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printDecriptData () {
        dataWithoutComments = new StringBuilder();
        for (String i : dataEachString) {
            if (!(i.charAt(0)=='#') && !(i.length() == 1)) {
                dataWithoutComments.append(i).append('\n');
            }
        }
        dataEachString = dataWithoutComments.toString().split("\n");
        for (String i : dataEachString)
        System.out.println(i);
    }




    public void dataDecripter () {
        dataWithoutComments = new StringBuilder();
        for (String i : dataEachString) {
            if (!(i.charAt(0)=='#') && !(i.length() == 1)) {
                dataWithoutComments.append(i).append('\n');
            }
        }
        dataEachString = dataWithoutComments.toString().split("\n");
//        for (String i : dataEachString)
//            System.out.println(i);

        for (String i : dataEachString) {
            if (i.contains("print")) {
                dataEachStringForPrint = i.split("\"");
                for (int j = 1; j < dataEachStringForPrint.length; j = j+2) {
                    System.out.println(dataEachStringForPrint[j]);
                }
//                System.out.println(i.substring(i.indexOf("\""), i.indexOf("\"")));
            }
            else if (i.contains("set")) {
                dataEachStringForSet = i.split("\\$");
                for (int j = 1; j < dataEachStringForSet.length; j = j+2) {
                    System.out.println(dataEachStringForSet[j]);
                }
            }
        }
    }

    public String printDecripter (String string) {

        return string;
    }
}
