package com.sh.collections._02.set;

import com.sh.collections._02.set.Book;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * 커스텀 클래스 Set으로 관리하기
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book(100L, "홍길동전", "허균", 15000));
        bookSet.add(new Book(200L, "신사동 가로수길", "신사임당", 30000));
        bookSet.add(new Book(300L, "해시계 파헤치기", "장영실", 17000));
        bookSet.add(new Book(400L, "한글2", "세종대왕", 20000));
        bookSet.add(new Book(500L, "잠수왕", "논개", 12000));


        Book book5 = (new Book(500L, "잠수왕", "논개", 12000));
        bookSet.add(book5);
        Book book6 = (new Book(500L, "잠수왕", "논개", 12000));
        bookSet.add(book6);

        // equals/hashCode 비교후 동일할 때 같은 객체로 간주한다.
        System.out.println(book5.equals(book6)); // false
        System.out.println(book5.hashCode() == book6.hashCode()); // false


        // 동일한 내용의 Book객체 추가
        bookSet.add(new Book(500L, "잠수왕", "논개", 12000));
        // Set이라서 같은 객체가 저장이 안될것같으나 저장이된다
        // 객체가 다른 객체라서 그렇다.
        // HashSet은 중복을 판단할 때 내부적으로 equals와 hashCode값 비교
        // Object#equals this != obj 주소값이 다르다

        System.out.println(bookSet);
    }
}
