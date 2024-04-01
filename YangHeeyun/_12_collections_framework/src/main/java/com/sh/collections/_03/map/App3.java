package com.sh.collections._03.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 커스텀클래스 맵으로 관리하기
 * - Map<K,V>
 * - Map<Long, Book> 식별필드를 key로, Book객체를 value로 관리
 * - Map<Book, Integer> Book객체를 key로, 판매량데이터(int)를 value로 관리
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        // 1. 책정보 관리 <Long, Book>
        Map<Long, Book> bookMap = new HashMap<>();
        bookMap.put(100L, new Book(100L, "홍길동전", "허균", 15000));
        bookMap.put(200L, new Book(200L, "신사동 가로수길", "신사임당", 30000));
        bookMap.put(300L, new Book(300L, "해시계 파헤치기", "장영실", 17000));
        // 책조회
        System.out.println(bookMap.get(100L));

        // 2. 책별 판매량관리
        Map<Book, Integer> bookSaleMap = new HashMap<>();
        bookSaleMap.put(new Book(100L, "홍길동전", "허균", 15000), 10);
        bookSaleMap.put(new Book(200L, "신사동 가로수길", "신사임당", 30000), 30);

        // 판매량 추가
        Book hongBook = new Book(100L, "홍길동전", "허균", 15000);
        if (bookSaleMap.containsKey(hongBook)) {
            int value = bookSaleMap.get(hongBook);
            bookSaleMap.put(hongBook, value + 5);
        }
        System.out.println(bookSaleMap);
    }
}
