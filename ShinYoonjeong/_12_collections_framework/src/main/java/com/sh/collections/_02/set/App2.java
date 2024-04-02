package com.sh.collections._02.set;

import com.sh.collections._01.list.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 * 커스텀 클래스 Set으로 관리하기
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Set<Book> bookSet = new HashSet<>();

        bookSet.add(new Book(100, "홍길동전", "허균", 15000));
        bookSet.add(new Book(200L, "신사동 가로수길", "신사임당", 30000));
        bookSet.add(new Book(300L, "해시계 파헤치기", "장영실", 17000));
        bookSet.add(new Book(400L,"한글2", "세종대왕",20000));


        Book book5 = new Book(500l, "잠수왕","논개", 12000);
        bookSet.add(book5);

        // 동일한 내용의 Book 객체 추가
        Book book6 = new Book(500L,"잠수왕", "논개",12000);
        System.out.println(book5.hashCode()==book6.hashCode());
        System.out.println(bookSet);
    }

}
