package com.sh.object.creation;

public class Item {
    long id;
    String name;
    int price;

    public Item() {
    }

    public Item(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void print(){
        System.out.printf("id: %d name: %s price: %d\n", this.id,this.name, this.price);
    }
}
