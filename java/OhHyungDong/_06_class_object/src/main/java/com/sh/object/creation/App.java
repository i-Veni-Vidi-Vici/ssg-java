package com.sh.object.creation;

/**
 *
 */
public class App {
    public static void main(String[] args) {
        //1. 기본 생성자 + setter
        Item item1 = new Item();
        item1.setId(1L);
        item1.setName("떡볶이");
        item1.setPrice(5600);
        item1.print();

        //2. 필드 생성자
        Item item2 = new Item(2L, "부대찌개", 8000);
        item2.print();
    }
}
