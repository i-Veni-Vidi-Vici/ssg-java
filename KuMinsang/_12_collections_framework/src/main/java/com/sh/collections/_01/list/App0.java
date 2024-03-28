package com.sh.collections._01.list;

import java.util.*;

/**
 * <pre>
 *     Collection Framework
 *     - 자바진영에서 대용량 데이터 처리를 위해 만들어둔 자료구조
 *
 *     1. List계열 : 순서가 유지되어야 하는 데이터 처리
 *     2. Set계열 : 중복을 허용해서는 안되는 데이터 처리
 *     3. Map 계열 : Key/value로 하나의 요소를 구성하는 데이터 처리
 *      -key는 중복을 허용하지 않는다
 * </pre>
 */

public class App0 {
    public static void main(String[] args) {
        Book[] books = new Book[]{
                new Book(100L, "홍길동", "허균", 15000),
                new Book(200L, "넛지", "제러드", 15000),
                new Book(300L, "이기적유전자", "엣킨슨", 15000)
        };

        // 2권 추가 (배열은 크기 변경이 불가능하다)
        Book[] books2 = new Book[100]; // 불필요한 공간을 미리 할당(공간 낭비)
        System.arraycopy(books, 0, books2, 0, books.length);
        books2[3] = new Book(400L, "한글2", "세종대왕", 20000);
        books2[4] = new Book(500L, "해상왕", "지중왕", 25000);
        System.out.println(Arrays.toString(books2));

        //1권 삭제 (중간의 데이터 삭제)
//        books2[2] = null; //중간에 데이터를 비워두지 않는다
        books2[2] = books2[3];
        books2[3] = books2[4];
        books2[4] = null;

        //중간에 1권 추가
        books2[1] = new Book(150L, "연탄길", "엄준식", 25000);


    }
}
