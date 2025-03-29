package com.sh.api._01.object;

public class App1 {
    public static void main(String[] args) {
        Book book1 = new Book(1L, "홍길동전", "허균", 10000);
        Book book2 = new Book(2L, "목민심서", "정약용", 30000);
        Book book3 = new Book(2L, "목민심서", "정약용", 30000);

        //동일성
        System.out.println(book1.hashCode());
        System.out.println(book2.hashCode());
        System.out.println(book3.hashCode());

        System.out.println(book1.equals(book2));
        System.out.println(book2.equals(book3));
        System.out.println(book1.equals(book3));
    }
}
