package com.sh.api._01._object;

/**
 * Object#equals, Object#hashCode 오버라이드
 * - 객체 동일성(Identity): heap 영역의 같은 객체인가? (주소값이 같은가?) ==
 * - 객체 동등성(Equality): 객체가 가진 내용이 같은가? (특정필드의 값들이 동일한가?) equals() 메소드 (오버라이드)
 * 객체비교 원칙
 * - equals 비교 결과가 true 라면, 동일한 hashCode 를 반환해야 한다.
 * - 이후 Collections 의 HashXXX 클래스들은 요소의 동등성을 위해 equals/hashCode 를 모두 호출해 비교
 */
public class App2 {
    public static void main(String[] args) {
        Book book1 = new Book(1L, "홍길동전", "허균", 15000);
        Book book2 = new Book(2L, "묵민심서", "정약용", 30000);
        Book book3 = new Book(2L, "묵민심서", "정약용", 30000);

        // 동일성 비교
        System.out.println(book1.hashCode());
        System.out.println(book2.hashCode());
        System.out.println(book3.hashCode());

        System.out.println(book1 == book2);
        System.out.println(book1 == book3);
        System.out.println(book2 == book3);

        // 동등 비교 - 특정필드의 값이 같은지 비교해서 모두 같다면, 두 객체가 동등하다고 판단
        System.out.println(book1.equals(book2));
        System.out.println(book1.equals(book3));
        System.out.println(book2.equals(book3));

        Book book4 = book1; // 얕은 복사
        System.out.println(book4.equals(book1));

        Book book5 = new Book(2L, null, "정약용", 30000);
        Book book6 = new Book(2L, null, "정약용", 30000);
        System.out.println(book5.equals(book2));
        System.out.println(book2.equals(book5));
        System.out.println(book5.equals(book6));

        // hashCode 확인
        System.out.println(book2.equals(book3));
        System.out.println(book2);
        System.out.println(book3);
    }
}
