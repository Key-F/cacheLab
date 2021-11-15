package com.company.lab;


import java.util.HashMap;

class Record {
    String value;
    int accessNum;
    String type;


    Record(){}
    Record(String value, int accessNum, String type){
        this.value = value;
        this.accessNum = accessNum;
        this.type = type;
    }

    Record updateRecord(HashMap<String, Record> recordSet, String key, String value){
        Record oldRecord = recordSet.get(key);
        if (oldRecord.getValue().equals(value))
            oldRecord.incrementAcc(); // Если значения равны, то увеличиваем счетчик
        else { // Если не равны, пишем новое значение + сбрасываем счетчик
            oldRecord.setAccessNum(0);
            oldRecord.setValue(value);
        }
        return oldRecord;

    }

    int getAccessNum(){
        return accessNum;
    }

    String getValue(){
        return value;
    }

    void setAccessNum(int accessNum) {
        this.accessNum = accessNum;
    }

    void setValue(String value) {
        this.value = value;
    }

    void incrementAcc(){
        accessNum++;
    }

    void printValue(){
        System.out.println("Тип: " + type + " Значение: " + value + " Количество обращений: " + accessNum);
    }
}

