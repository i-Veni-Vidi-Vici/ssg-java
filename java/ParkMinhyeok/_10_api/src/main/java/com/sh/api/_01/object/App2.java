package com.sh.api._01.object;

/**
 * Object#equals, Object#hashCode
 *
 * 객체비교 원칙
 * - equals 비교 결과가 true라면, 동일한 hashCode를 반환
 * - 이후 Collections의 hashXXX클래스들은 요소의 동등성을 위해 equals / hashCode를 모두 호출해 비교
 */
public class App2 {
    public static void main(String[] args) {
        Book book1 = new Book(1L, "홍길동전", "허균", 15000);
        Book book2 = new Book(2L, "목민심서", "정약용", 30000);
        Book book3 = new Book(2L, "목민심서", "정약용", 30000);

//        System.out.println(book1.hashCode());
//        System.out.println(book2.hashCode());
//        System.out.println(book3.hashCode());

//        System.out.println(book1 == book2);
//        System.out.println(book2 == book3);
//        System.out.println(book1 == book3);

//        System.out.println(book1.equals(book2));
//        System.out.println(book2.equals(book3));

        // 동일객체를 비교하면?
//        Book book4 = book1;
//        System.out.println(book1.equals(book4));

        // hashCode 확인
//        System.out.println(book2.equals(book3));
//        System.out.println(book2.hashCode());
//        System.out.println(book3.hashCode());

        //
//        System.out.println(book1.getTitle().hashCode());
//        System.out.println(book2.getTitle().hashCode());
//        System.out.println(book3.getTitle().hashCode());
    }
}
