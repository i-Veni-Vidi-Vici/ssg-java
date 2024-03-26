package com.sh.api_01.object;

/**
 * <pre>
 *     Object클래스
 *     - 모든 클래스의 부모 클래스, 클래스 상속구조의 최상단에 위치한다
 *     - 필드 없이 메소드만 제공한다
 *     - toString(), hashCode(), equals() 주로 오버라이드 해서 사용
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        Book book1 = new Book(1L, "홍길동전", "허균", 15000);
        Book book2 = new Book(1L, "1q84", "하루키", 15000);
        Book book3 = new Book(1L, "토지", "박경리", 15000);

        // toString 호출 : 객체를 문자열로서 출력해야 할때 자동으로 호출
        // Object#toString : getClass().getName() +@+ Integer.toHexString(hashCode());
        // 클래스 객체 (클래스 별로 메모리에 적재된 프로토타임객체)의 이름 -> 클래스 풀네임
        // DTO 클래스는 안의 내용을 확인해야 할 때가 많으므로 toString을 재정의 해주는것이 좋다

        System.out.println("book1 : " + book1);
        System.out.println("book2 : " + book2);
        System.out.println("book3 : " + book3);
        System.out.println(String.valueOf(1234));

        

    }
}
