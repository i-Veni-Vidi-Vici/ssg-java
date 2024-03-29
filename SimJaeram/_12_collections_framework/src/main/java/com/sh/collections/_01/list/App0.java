package com.sh.collections._01.list;

import java.util.Arrays;

/**
 * <pre>
 *     Collections Framework
 *     - 자바 진영에서 대용량 데이터 처리를 위해 만들어둔 자료구조
 *
 *     1. List 계열 // 순서가 유지되야 하는 데이터 처리 담당
 *
 *     2. Set 계열 // 중복이 허용되지 않는 데이터 처리 담당
 *
 *     3. Map 계열 // key/value로 하나의 요소를 구성하는 데이터 처리, key는 중복을 허용하지 않는다.
 *
 * </pre>
 */
public class App0 {
    public static void main(String[] args) {
        Book[] books = new Book[] {
                new Book(100L, "홍길동전", "허균", 15000),
                new Book(200L, "신사동 가로수길", "신사임당", 30000),
                new Book(300L, "해시계 파헤치기", "장영실", 17000)
        };

        // 2권 추가, 배열은 크기 변경이 불가능하다.
        Book[] books2 = new Book[100];      // 불필요한 공간을 미리 할당하여 공간 낭비가 됨
        System.arraycopy(books, 0, books2, 0, books.length);
        books2[3] = new Book(400L, "한글2", "세종대왕", 20000);
        books2[4] = new Book(500L, "잠수왕", "논개", 12000);
        System.out.println(Arrays.toString(books2));

        // 1권 삭제, 중간의 데이터 삭제
//        book2s[2] = null;                    // 비어 있는 중간에 있는 요소를 비워두지 않는다.
        books2[2] = books2[3];
        books2[3] = books2[4];
        books2[4] = null;

        // 1권 추가, 중간의 데이터 추가
        books2[4] = books2[3];
        books2[3] = books2[2];
        books2[2] = books2[1];
        books2[1] = new Book(150L, "골목대장", "윤봉준", 27000);

    }
}
