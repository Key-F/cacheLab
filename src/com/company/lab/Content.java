package com.company.lab;

public class Content {

    private String value;
    private String type;
    private String path;

    Content(String type, String value){
        if (type.equals("FILE")){
            path = value;
            this.value = Util.getFileAsString(value);
        }
        else this.value = value;
        this.type = type;
    }

    void printValue(){
        if(this.type.equals("FILE"))
        System.out.print("Тип: " + type + " Путь до файла: " + path);
        else System.out.print("Тип: " + type + " Значение: " + value);
    }

    public String getContentValue() {
        return value;
    }

    public boolean compareValues(String value) {
        if(this.type.equals("FILE"))
        return this.value.equals(Util.getFileAsString(value));
        else
            return this.value.equals(value);
    }

    public String getType() {
        return type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setType(String type) {
        this.type = type;
    }

}
