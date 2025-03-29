package com.sh.object.creation;

public class App {
    public static void main(String[] args) {
        // 1. 기본 생성자 + setter
        Item item1 = new Item();
        item1.setId(1L);
        item1.setName("떡뽀키");
        item1.setPrice(6000);
        item1.print();

        //2. 필드 생성자
        Item item2 = new Item(1L, "떡뽂이", 5600);
        item2.print();

    }
}
