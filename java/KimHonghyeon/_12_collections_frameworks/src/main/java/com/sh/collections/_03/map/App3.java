package com.sh.collections._03.map;

import java.util.HashMap;
import java.util.Map;

public class App3 {
    public static void main(String[] args) {
        Map<Book, Long> bookMap = new HashMap<>();
        bookMap.put(new Book(1L, "홍길동전", "허균", 10000), 1L);
        bookMap.put(new Book(2L, "가나다", "허상", 10000), 2L);
        bookMap.put(new Book(3L, "마바사아", "허각", 10000), 3L);

        for(Book book : bookMap.keySet()){
            System.out.println(bookMap.get(book));
        }
    }
}
