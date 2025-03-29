package com.sh.collections._02.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 커스텀 클래스 Set으로 관리하기
 */
public class App2 {


    public static void main(String[] args) {
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book(100L ,"홍길동전", "세종대왕", 20000));
        bookSet.add(new Book(200L ,"신사", "세종대", 20000));
        bookSet.add(new Book(300L ,"해시계", "세대왕", 20000));
        bookSet.add(new Book(400L ,"한글", "세왕", 20000));
        bookSet.add(new Book(500L ,"잠수왕", "종대왕", 20000));

        //동일한 내용 추가
        Book book6 = new Book (500L ,"잠수왕", "종대왕", 20000);
        Book book5 = new Book (500L ,"잠수왕", "종대왕", 20000);
        bookSet.add(book6);

        System.out.println(book5.equals(book6));
        System.out.println(book5.hashCode() == book6.hashCode());



        System.out.println(bookSet);
        System.out.println(bookSet.size());




    }
}
