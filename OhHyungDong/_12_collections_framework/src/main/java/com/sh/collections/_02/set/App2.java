package com.sh.collections._02.set;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 *   커스텀 클래스 set으로 관리하기
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Set<Book> books = new HashSet<>();
        books.add(new Book(100L, "홍길동전", "허균", 15000));
        books.add(new Book(200L, "신사동 가로수길", "신사임당", 35000));
        books.add(new Book(300L, "해시계 파헤치기", "장영실", 40000));
        books.add(new Book(400L, "한글2", "세종대왕", 20000));

        Book Book5 = new Book(500L, "잠수왕", "논개", 120000);
        books.add(new Book(500L, "잠수왕", "논개", 120000));

        //동일한 내용의 객체 추가 - 메모리 상으론 서로 다른 객체
        Book Book6 = new Book(500L, "잠수왕", "논개", 120000);
        books.add(Book6);

        //equals, hashcode 비교 후, equals 결과가 true, hashCode가 동일 할 때 같은 객체로 간주한다.
        //동일한 값이 중복 추가 안되려면 Book 클래스에다가 equals, hashCode를 오버라이드 메소드 해서 사용해야 한다.
        System.out.println(Book5.equals(Book6));
        System.out.println(Book5.hashCode() == Book6.hashCode());


        System.out.println(books);
    }
}
