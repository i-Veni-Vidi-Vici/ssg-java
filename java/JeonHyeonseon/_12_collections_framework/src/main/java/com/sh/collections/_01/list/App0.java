package com.sh.collections._01.list;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * <pre>
 * Collections Framework
 *  - 자바진영에서 대용량데이터 처리를 위해 만들어둔 자료구조
 *
 * 1. list계열 : 순서가 유지돼야 하는 데이터 처리
 * 2. Set계열 : 중복을 허용해서는 안되는 데이터 처리
 * 3. Map계열 : key/value로 하나의 요소를 구성하는 데이터 처리(이때, key는 중복을 허용하지 않는다)
 *
 *
 * </pre>
 */
public class App0 {
    public static void main(String[] args) {
        // list가 하는 일 구체적으로 파악하기

        Book[] books = new Book[]{
          new Book(100L, "홍길동전", "허균", 15000),
          new Book(200L, "신사동 가로수길", "신사임당", 30000),
          new Book(300L, "해시계 파헤치기", "장영실", 17000)
        };

        // 2권 추가 (배열은 크기 변경이 불가능하기 때문에 추가할 수 없다)
        // 따라서 5권을 넣을 배열을 새로 만들어야 한다.
        Book[] books2 = new Book[100]; // 불필요한 공간을 미리 할당(공간 낭비)
        System.arraycopy(books, 0, books2, 0, books.length);
        books2[3] = new Book(400L, "한글2", "세종대왕", 20000);
        books2[3] = new Book(500L, "잠수왕", "논개", 12000);
        System.out.println(Arrays.toString(books2));

        // 1권 삭제(중간의 데이터 삭제)
//        books2[2] = null; // 중간에 데이터를 비워두지 않는다
//                            장열실 저자의 책을 삭제하고 싶은 것, (중간에 null값이 있으면 관리하기 힘들어짐)
        books2[2] = books2[3]; // 3번지 책을 2번지로 옮긴다
        books2[3] = books2[4]; // 4번지 책을 3번지로 옮긴다.
        books2[4] = null;  // (위의 세줄 이해하기)뒤의 책을 앞으로 당기고 삭제를 한다.

        // 중간에 1권 추가
        books2[4] = books2[3]; // 3번지 책을 4번지로 옮긴다
        books2[3] = books2[2]; // 2번지 책을 3번지로 옯긴다
        books2[2] = books2[1]; // 1번지 책을 2번지로 옮긴다
        books2[1] = new Book(150L, "골목대장", "윤봉준", 27000); // 옮긴 후 남은 공간에 책을 추가한다.

        System.out.println(Arrays.toString(books2));
    }
}
