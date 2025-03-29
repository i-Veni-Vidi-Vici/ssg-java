package com.sh.api._01.object;

public class App1 {
    public static void main(String[] args) {
        Book book1 = new Book(1L, "홍길동전", "허균", 15000);
        Book book2 = new Book(2L, "목민심서", "정약용", 30000);
        Book book3 = new Book(2L, "목민심서", "정약용", 30000);

        System.out.println("book1 : " + book1);
        System.out.println("book1 : " + book1.toString());
        System.out.println("book2 : " + book2);
        System.out.println("book2 : " + book2.toString());
        System.out.println("book3 : " + book3);
        System.out.println("book3 : " + book3.toString());
    }
}
