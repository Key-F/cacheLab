package com.company.lab;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader fileReader;
        try {
            fileReader = new FileReader(System.getProperty("user.dir") + "/file.txt");
        }
        catch (IOException e) {System.out.println("Не удалось считать из файла"); return;}
        Scanner in = new Scanner(fileReader);
        int size = Integer.valueOf(in.next());
        in.nextLine();
        Cache testCache = new Cache(size);
        String line;
        while (in.hasNext()) { // Построчно читаем из файла и парсим нужные значения
            line = in.nextLine();
            String value = line.substring(line.lastIndexOf(" ") + 1);
            String key = line.substring(line.indexOf(" ") + 1, line.lastIndexOf(" "));
            String type = line.substring(0, line.indexOf(" "));
            testCache.addRecord(key, value, type);
        }
        fileReader.close();

        testCache.printCache(); // тестовый вывод на печать

        testCache.clear(); // тестовая очистка

        testCache.printCache(); // снова выводим на печать для проверки

    }
}
