package com.sh.collections._01.list;

import java.util.Arrays;

/**
 * <pre>
 * Collections Framework
 * - 자바진영에서 대용량데이터 처리를 위해 만들어둔 자료구조
 *
 * 1. List 계열 : 순서가 유지되어야 하는 데이터 처리
 * 2. Set 계열 : 중복을 허용하면 안되는 데이터 처리
 * 3. Map 계열 : key/value로 하나의 요소를 구성하는 데이터 처리 (key는 중복허용하지 않음)
 * </pre>
 */
public class App0 {
    public static void main(String[] args) {
        Book[] books = new Book[]{
                new Book(100L, "홍길동전", "홍길동", 15000),
                new Book(200L, "신사동 가로수길", "신사임당", 30000),
                new Book(300L, "해시계 파헤치기", "장영실", 17000),
        };
        // 2권 추가 (배열은 크기 변경이 불가능)
        Book[] books1 = new Book[100]; // 불필요한
        System.arraycopy(books, 0 ,books1, 0, books.length);
        books1[3] = new Book(400L, "한글2", "세종대왕", 20000);
        books1[4] = new Book(500L, "잠수왕", "논개", 12000);
        System.out.println(Arrays.toString(books1));

        // 1권 삭제 (중간 데이터 삭제)
//        books1[2] = null; // 중간에 데이터를 비워두지 않음
        books1[2] = books1[3];
        books1[3] = books1[4];
        books1[4] = null;

        // 중간에 1권 추가
        books1[4] = books1[3];
        books1[3] = books1[2];
        books1[2] = books1[1];
        books1[1] = new Book(150L, "골목대장", "윤봉준", 27000);
        System.out.println(Arrays.toString(books1));
    }
}
