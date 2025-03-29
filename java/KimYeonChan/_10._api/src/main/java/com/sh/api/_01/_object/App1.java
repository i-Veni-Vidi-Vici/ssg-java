package com.sh.api._01._object;

/**
 * Object 클래스
 * - 모든 클래스의 부모클래스, 클래스 상속 구조의 최상단에 위치한다.
 * - 필드 없이 메소드만 제공
 * - toString(), hashCode(), equals() 주로 오버라이드해서 사용한다.
 */
public class App1 {
    public static void main(String[] args) {
        Book book1 = new Book(1L, "홍길동전", "허균", 15000);
        Book book2 = new Book(2L, "묵민심서", "정약용", 30000);
        Book book3 = new Book(2L, "묵민심서", "정약용", 30000);

        // toString() 호출 객체를 문자열로써 출력해야 할때 자동으로 호출
        // Object#toString: getClass().getName() + "@" + Integer.toHexString(hashCode());
        // 클래스객체(클래스별로 메모리에 적재된 프로토타입객체)의 이름 -> 클래스 풀네임
        System.out.println("book1: " + book1);
        System.out.println("book1: " + book1.toString());
        System.out.println("book2: " + book2);
        System.out.println("book2: " + book2.toString());
        System.out.println("book3: " + book3);
        System.out.println("book3: " + book3.toString());
    }
}
