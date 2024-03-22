package com.sh.object.creation;

public class App {
    //1. 기본생성자 + setter
    public static void main(String[] args) {
        Item item1 = new Item();
        item1.setId(1L);
        item1.setName("떡뽁이");
        item1.setPrice(5600);
        item1.print();

        // 2. 필드 생성자
        Item item2 = new Item(1L, "떡뽁이", 5600);
        item2.print();
    }
}
