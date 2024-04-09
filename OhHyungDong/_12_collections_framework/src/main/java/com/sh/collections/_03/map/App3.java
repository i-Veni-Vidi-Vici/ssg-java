package com.sh.collections._03.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  커스텀 클래스 맵으로 관리하기
 *  - Map<K,V></K,V>
 *  -Map<Long,Book> 식별필드를 key 로, book객체르 value로 관리
 *  -Map<Book, Integer> Book객체를 key, 판매량 데이터(int)를 value로 관리</Book,>
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {

        Map<Long, Book> bookMap = new HashMap<>();
        bookMap.put(100L, new Book(100L, "홍길동전", "허균", 150000));
        bookMap.put(100L, new Book(200L, "신사동 가로수길", "신사임당", 35000));
       // bookMap.keySet().add(new com.sh.collections._01.list.Book(300L, "해시계 파헤치기", "장영실", 40000));
        System.out.println(bookMap.get(100L));
        //2권 추가 (내부적으로 관리되는 배열의 크기를 신경쓰지 않아도 된다.)
//        bookMap.keySet().add(new com.sh.collections._01.list.Book(400L, "한글2", "세종대왕", 20000));
//        bookMap.keySet().add(new com.sh.collections._01.list.Book(500L, "잠수왕", "논개", 120000));))

        //책 조회
        System.out.println(bookMap.get(100L));

        //2. 책별 판매량 조회
        Map<Book, Integer> bookSaleMap = new HashMap<>();
        bookSaleMap.put(new Book(100L, "홍길동전", "허균", 150000),10);
        bookSaleMap.put(new Book(200L, "신사동 가로수길", "신사임당", 35000),10);

        //판매량 추가
        Book hongBook = new Book(100L,"홍길동전","허균",15000);
        if(bookSaleMap.containsKey(hongBook)){
            int value = bookSaleMap.get(hongBook);
            bookSaleMap.put(hongBook, value + 5);
        }
        System.out.println(bookSaleMap);


    }
}
