package com.sh.collections._01.list;

import java.util.Arrays;

/**
 * <pre>
 *     ### Collections Framework
 *
 * - 자바 진영에서 대용량 데이터 처리를 위해 만들어둔 자료 구조
 *     1. List 계열 : `순서가 유지`되어야 하는 데이터 처리
 *     2. Set 계열 : `중복을 허용하지 않는` 데이터 처리
 *     3. Map 계열 : `key - value`로 하나의 요소를 구성하는 데이터 처리 (key는 중복 허용 X)
 * </pre>
 */
public class App0 {
    public static void main(String[] args) {
        Book[] books = new Book[]{
                new Book(100L, "홍길동전", "허균", 15000),
                new Book(200L, "신사동 가로수길", "신사임당", 30000),
                new Book(300L, "해시계 파헤치기", "장영실", 17000)
        };

        //책 2권 추가 (배열의 구린 점 : 배열은 크기 변경이 불가능함 -> 5개짜리 배열 또 만들어야 함)
        Book[] books2 = new Book[100]; //불필요한 공간을 미리 할당(공간 낭비)
        System.arraycopy(books, 0, books2, 0, books.length);
        books2[3] = new Book(400L, "한글2", "세종대왕", 20000);
        books2[4] = new Book(500L, "잠수왕", "논개", 12000);
        System.out.println(Arrays.toString(books2));

        // 책 1권 삭제(중간의 데이터 삭제) - 중간에 데이터가 null로 두지 않음 -> 데이터 관리의 어려움이 있기 때문!
        books2[2] = books2[3];
        books2[3] = books2[4];
        books2[4] = null;

        // 중간에 책 1권 추가
        books2[4] = books2[3];
        books2[3] = books2[2];
        books2[2] = books2[1];
        books2[1] = new Book(150L, "골목대장", "윤봉준", 27000);
        System.out.println(Arrays.toString(books2));
    }
}
