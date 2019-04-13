package com.example.billsplitter;

public class Person implements java.io.Serializable{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
