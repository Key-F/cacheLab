package com.company.lab;

import java.util.HashMap;
import java.util.Map;

class Cache {

    private int size;
    private HashMap<String, Record> recordSet;


    Cache(int size){
        this.size = size;
        recordSet = new HashMap<>();
    }

    void addRecord(String key, String value, String type){
        if (recordSet.get(key) != null){ // ключ уже находится в кеше
            updateRecord(recordSet, key, value, type);
        }
        else {
            if (size == 0) return; // Заканчиваем в случае пустого списка.
            Record newRecord;
            newRecord = new Record(value, 0, type); // Новая запись
            if (recordSet.size() < size)
                recordSet.put(key, newRecord); // Если еще есть место в кеше
            else {
                String minKey = getKeyOfMinAccess(recordSet);
                recordSet.put(minKey, newRecord); // Если нет места, то ищем запись с минимальным счетчиком и перезаписываем
                recordSet.put(key, recordSet.remove(minKey)); // Перезапись ключа на новый
            }
        }
    }

    Record updateRecord(HashMap<String, Record> recordSet, String key, String value, String type){
        Record oldRecord = recordSet.get(key);
        if (oldRecord.getValue().compareValues(value))
            oldRecord.incrementAcc(); // Если значения равны, то увеличиваем счетчик
        else { // Если не равны, пишем новое значение + сбрасываем счетчик
            oldRecord.setAccessNum(0);
            oldRecord.updateContent(type, value);
        }
        return oldRecord;
    }


    private String getKeyOfMinAccess(HashMap<String, Record> recordSet){ // поиск минимального значения счетчика
        int min = recordSet.entrySet().iterator().next().getValue().getAccessNum(); // пусть минимальным значением обращений будет первый элемент таблицы
        String minKey = recordSet.entrySet().iterator().next().getKey(); // Минимальный ключ = первый ключ в таблице
        for (Map.Entry<String, Record> pair: recordSet.entrySet()){ // Проходим по всем парам таблицы
            Record temp = pair.getValue();
            if (temp.getAccessNum() < min) {  // Ищем минимальное значение обращений
                min = temp.getAccessNum();
                minKey = pair.getKey();
            }
        }
        return  minKey; // Возвращаем ключ, у которго меньше всего обращений
    }

    void printCache(){ // Вывод кеша в консоль
        for (Map.Entry<String, Record> pair: recordSet.entrySet()){
            System.out.print("Key: " + pair.getKey() + " ");
            pair.getValue().printValue();
        }
    }

    void clear(){
        System.out.println("Очистка кеша");
        recordSet.clear();
        size = 0;
    }

}
