package com.company.lab;



class Record {
    private Content content;
    private int accessNum;


    Record(String value, int accessNum, String type){
        content = new Content(type, value);
        this.accessNum = accessNum;
    }

    int getAccessNum(){
        return accessNum;
    }

    Content getValue(){
        return content;
    }

    void setAccessNum(int accessNum) {
        this.accessNum = accessNum;
    }

    void setValue(String value) {
        this.content.setValue(value);
    }

    void updateContent(String type, String value){
        content = new Content(type, value);
    }

    void incrementAcc(){
        accessNum++;
    }

    void printValue(){
        this.content.printValue();
        System.out.println(" Количество обращений: " + accessNum);
    }
}

