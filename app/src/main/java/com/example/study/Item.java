package com.example.study;

public class Item {
    private String name;
    private String price;
    private boolean isSold;

    public Item(String name, String price, boolean isSold) {
        this.name = name;
        this.price = price;
        this.isSold = isSold;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }


}
