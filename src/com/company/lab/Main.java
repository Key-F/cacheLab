package com.company.lab;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader fileReader = new InputStreamReader(new FileInputStream(System.getProperty("user.dir") + "/file.txt"), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int size = Integer.valueOf(bufferedReader.readLine());
        Cache testCache = new Cache(size);
        String line;
        while ((line = bufferedReader.readLine()) != null) { // Построчно читаем из файла и парсим нужные значения
            String value = line.substring(line.lastIndexOf(" ") + 1);
            String key = line.substring(line.indexOf(" ") + 1, line.lastIndexOf(" "));
            String type = line.substring(0, line.indexOf(" "));
            testCache.addRecord(key, value, type);
        }
        bufferedReader.close();

        testCache.printCache(); // тестовый вывод на печать

        testCache.clear(); // тестовая очистка

        testCache.printCache(); // снова выводим на печать для проверки

    }
}
