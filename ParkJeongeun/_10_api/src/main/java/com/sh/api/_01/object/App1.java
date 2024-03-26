package com.sh.api._01.object;

/**
 * <pre>
 * Object 클래스
 * - 모든 클래스의 부모 클래스, 클래스 상속구조의 최상단에 위치
 * - 필드 없이 메소드만 제공
 * - toString(), hashCode(), equals() 주로 오버라이드해서 사용
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        Book book1 = new Book(1L, "홍길동전", "허균", 15000);
        Book book2 = new Book(2L, "목민심서", "정약용", 30000);
        Book book3 = new Book(2L, "목민심서", "정약용", 30000);

        // toString 호출 : 객체를 문자열로써 출력해야 할때 자동으로 호출
        // Object#toString : getClass().getName() + "@" + Integer.toHexString(hashCode());
        // 클래스 객체(클래스별로 메모리에 적재된 프로토타입 객체)의 이름 -> 클래스 풀네임
        System.out.println("book1 : " + book1); // book1 : com.sh.api._01.object.Book@23fc625e
        System.out.println("book1 : " + book1.toString()); // book1 : com.sh.api._01.object.Book@23fc625e
        // toString Override 후 book1 : Book[id = 1, title = 홍길동전, author = 허균, price = 15000] 출력

        System.out.println("book2 : " + book2); // book2 : com.sh.api._01.object.Book@3f99bd52
        System.out.println("book3 : " + book3); // book3 : com.sh.api._01.object.Book@4f023edb
    }
}
