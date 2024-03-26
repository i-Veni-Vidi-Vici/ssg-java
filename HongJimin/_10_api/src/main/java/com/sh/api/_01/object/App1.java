package com.sh.api._01.object;

import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;

public class App1 {
    public static void main(String[] args) {
        Book book1 = new Book(1L, "홍길동전", "허균", 15000);
        Book book2 = new Book(2L, "목민심서", "정약용", 30000);
        Book book3 = new Book(2L, "목민심서", "정약용", 30000);

        //toString 호출 : 객체를 문자열로써 출력해야할 때, 자동으로 호출
        //Object#toString : getClass().getName() + "@" + Integer.toHexString(hashCode());
        System.out.println("book1 : " + book1); //com.sh.api._01.object.Book@23fc625e
        System.out.println("book1 : " + book1.toString());
        System.out.println("book2 : " + book2); //com.sh.api._01.object.Book@3f99bd52
        System.out.println("book1 : " + book2.toString());
        System.out.println("book3 : " + book3); //com.sh.api._01.object.Book@4f023edb
        System.out.println("book1 : " + book3.toString());
    }
}
