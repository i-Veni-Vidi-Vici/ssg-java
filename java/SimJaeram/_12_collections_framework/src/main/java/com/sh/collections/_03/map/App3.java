package com.sh.collections._03.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     커스텀 클래스 맵으로 관리하기
 *     - Map<K, V>
 *     - Map<Long, Book>        // 식별 필드를 key로, Book 객체를 vaule로 관리
 *     - Map<Book, Integer>     // Book 객체를 Key로, 판매량 데이터 int를 value로 관리
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        // 책정보 관리 <Long, Book>
        Map<Long, Book> bookMap = new HashMap<>();
        bookMap.put(100L, new Book(100L, "홍길동전", "허균", 15000));
        bookMap.put(200L, new Book(200L, "신사동 가로수길", "신사임당", 30000));
        bookMap.put(300L, new Book(300L, "해시계 파헤치기", "장영실", 17000));

        // 책조회
        System.out.println(bookMap.get(100L));

        // 2. 책별 판매량 관리
        Map<Book, Integer> booSaleMap = new HashMap<>();
        booSaleMap.put(new Book(100L, "홍길동전", "허균", 15000), 10);
        booSaleMap.put(new Book(200L, "신사동 가로수길", "신사임당", 30000), 30);
        booSaleMap.put(new Book(300L, "해시계 파헤치기", "장영실", 17000), 10);

        Book hongBook = new Book(100L, "홍길동전", "허균", 15000);
        // 판매량 추가, 덮어써짐 주의
//        if(booSaleMap.containsKey(hongBook)) {
//            int value = bookSaleMap.get(hongBook);
//            bookSaleMap.put(hongBook, value + 5);
//        }
//        else {
//            booSaleMap.put(hongBook, 5);
//        }
//        booSaleMap.put(new Book(100L, "홍길동전", "허균", 15000), 5);

//        System.out.println(booSaleMap);
    }
}
