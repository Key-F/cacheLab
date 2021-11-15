package com.company.lab;

import java.nio.file.Files;
import java.nio.file.Paths;

class Util {

    static String getFileAsString(String path){ // Получаем файл как строку
        try {
            byte[] fileContent = Files.readAllBytes(Paths.get(path));
            return new String(fileContent);
        }
        catch (Exception e){
            System.out.println("Ошибка чтения из файла");
            return "";
        }
    }
}
