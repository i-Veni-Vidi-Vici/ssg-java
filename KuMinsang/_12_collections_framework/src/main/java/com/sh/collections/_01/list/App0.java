package com.sh.collections._01.list;

<<<<<<< HEAD
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
=======
import java.util.Arrays;

/**
 * <pre>
 * Collections Framework
 * - 자바진영에서 대용량데이터 처리를 위해 만들어둔 자료구조
 * 
 * 1. List계열 : 순서가 유지되야하는 데이터 처리
 * 2. Set계열 : 중복을 허용해서는 안되는 데이터 처리
 * 3. Map계열 : key/value로 하나의 요소를 구성하는 데이터처리 (key는 중복을 허용하지 않는다.)
 * 
 * 
 * </pre>
 */
public class App0 {
    public static void main(String[] args) {
        Book[] books = new Book[]{
            new Book(100L, "홍길동전", "허균", 15000),
            new Book(200L, "신사동 가로수길", "신사임당", 30000),
            new Book(300L, "해시계 파헤치기", "장영실", 17000)
        };

        // 2권 추가 (배열은 크기 변경이 불가능하다.)
        Book[] books2 = new Book[100]; // 불필요한 공간을 미리 할당 (공간 낭비)
        System.arraycopy(books, 0, books2, 0, books.length);
        books2[3] = new Book(400L, "한글2", "세종대왕", 20000);
        books2[4] = new Book(500L, "잠수왕", "논개", 12000);


        // 1권 삭제 (중간의 데이터 삭제)
//        books2[2] = null; // 중간에 데이터를 비워두지 않는다.
>>>>>>> 97aa7183c9fb127e3cf611ff187d772054906c64
        books2[2] = books2[3];
        books2[3] = books2[4];
        books2[4] = null;

<<<<<<< HEAD
        //중간에 1권 추가
        books2[1] = new Book(150L, "연탄길", "엄준식", 25000);


=======
        // 중간에 1권 추가
        books2[4] = books2[3];
        books2[3] = books2[2];
        books2[2] = books2[1];
        books2[1] = new Book(150L, "골목대장", "윤봉준", 27000);

        System.out.println(Arrays.toString(books2));
>>>>>>> 97aa7183c9fb127e3cf611ff187d772054906c64
    }
}
