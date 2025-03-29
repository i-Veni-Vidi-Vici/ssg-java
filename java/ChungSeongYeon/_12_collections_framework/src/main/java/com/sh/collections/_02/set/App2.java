package com.sh.collections._02.set;

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
//        bookSet.add(new Book(500L, "잠수왕", "논개", 12000));

        // 동일한 내용의 Book 객체 추가
        Book book5 = new Book(500L, "잠수왕", "논개", 12000);
        bookSet.add(book5);

        Book book6 = new Book(500L, "잠수왕", "논개", 12000);
        bookSet.add(book6);

        // equals/hashCode 비교 후, equals 결과가 true, hashCode가 동일할 때 같은 객체로 간주한다.
        //@Override
        //    public boolean equals(Object o) {
        //        if (this == o) return true;
        //        if (o == null || getClass() != o.getClass()) return false;
        //        Book book = (Book) o;
        //        return id == book.id && price == book.price && Objects.equals(title, book.title) && Objects.equals(author, book.author);
        //    }
        //
        //    @Override
        //    public int hashCode() {
        //        return Objects.hash(id, title, author, price);
        //    }
        // equals, hashcode 오버라이드 필수 하고 나면 true, true, 사이즈 5 뜸.

        System.out.println(book5.equals(book6));
        System.out.println(book5.hashCode() == book6.hashCode());

        System.out.println(bookSet); // 순서 엉망으로 출력됨.
        System.out.println(bookSet.size()); // 5
    }
}
