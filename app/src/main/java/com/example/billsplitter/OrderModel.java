package com.example.billsplitter;

public class OrderModel implements java.io.Serializable {
    private String name;
    private String price;

    public OrderModel(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
