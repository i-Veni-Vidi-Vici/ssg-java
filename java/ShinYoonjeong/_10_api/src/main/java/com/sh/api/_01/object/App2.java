package com.sh.api._01.object;

/**
 * <pre>
 * Object@equals, Object#hashCode 오버라이드
 * - 객체 동일성 (Identity) - heap 영역의 같은 객체인가? (주소값이 같은가?)
 * - 객체 동등성 (Equality) - 객체가 가진 내용이 같은가? (특정 필드의 값들이 동일한가?) -> equals 메소드(오버라이드)
 *
 * 객체 비교 원칙
 * - equals 비교 결과가 true라면, hashCode를 반환해야 한다.
 * - 이후 Collections의 HashXXX클래스들은 요소의 동등성을 위해 equals.hashCode를 모두 호출해 비교
 *
 *
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Book book1 =new Book(1L, "홍길동전", "허균", 15000);
        Book book2 =new Book(2L, "목민심서", "정약용", 30000);
        Book book3 =new Book(2L, "목민심서", "정약용", 30000);

        // 동일성 비교
        System.out.println(book1.hashCode()); // 2055281021
        System.out.println(book2.hashCode()); // 1554547125
        System.out.println(book3.hashCode()); // 617901222

        System.out.println(book1 == book2);
        System.out.println(book3 == book2);
        System.out.println(book3 == book1);
        // 동등 비교 - 특정 필드의 값이 같은지 비굫서 모두 같다면, 두 객체를 동등하다고 판단
        System.out.println(book1.equals(book2)); // false
        System.out.println(book1.equals(book3)); // false
        System.out.println(book2.equals(book3)); // false
        Book book4 = book1;
        System.out.println(book1.equals(book4));

        // title이 null인 경우?
        Book book5 = new Book(2L, null,"정약용", 30000);
        Book book6 = new Book(2L, null,"정약용", 30000);
        System.out.println(book5.equals(book2)); // false
        System.out.println(book2.equals((book5))); // false
        System.out.println(book5.equals(book6)); // true

        // hashCode 확인
        System.out.println(book2.equals(book3));
        System.out.println(book2.hashCode());
        System.out.println(book3.hashCode());

    }
}
