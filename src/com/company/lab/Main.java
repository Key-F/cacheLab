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
        while (in.hasNext()) { // Построчно читаем из файла и парсим нужные значения
            String type = in.next();
            String key = in.next();
            String value = in.next();
            testCache.addRecord(key, value, type);
        }
        fileReader.close();

        testCache.printCache(); // тестовый вывод на печать

        testCache.clear(); // тестовая очистка

        testCache.printCache(); // снова выводим на печать для проверки

    }
}
