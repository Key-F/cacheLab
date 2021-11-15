package com.company.lab;

import java.io.IOException;
import java.util.HashMap;


class FileRecord extends Record {

    private String path; // Путь до файла

    @Override
    Record updateRecord(HashMap<String, Record> recordSet, String key, String value) {
        value = Util.getFileAsString(value);
        return super.updateRecord(recordSet, key, value);
    }

    @Override
    void printValue(){
        System.out.println("Тип: " + type + " Путь до файла: " + path + " Количество обращений: " + accessNum);
    }

    FileRecord(String value, int accessNum, String type){
        this.path = value;
        value = Util.getFileAsString(value);
        this.value = value;
        this.accessNum = accessNum;
        this.type = type;
    }
}

