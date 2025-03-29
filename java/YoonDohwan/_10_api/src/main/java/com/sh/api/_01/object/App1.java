package com.sh.api._01.object;

/**
 * Object 클래스
 * -모든 클래스의 부모 클래스. 클래스 상속구조의 최상단에 위치한다.
 * -필드 없이 메소드만 제공
 * -toString(),hashCode(),equals() 주로 오버라이드해서 사용한다.
 */
public class App1 {
    public static void main(String[] args) {
        Book book1 = new Book(1L,"홍길동전","허균",15000);
        Book book2 = new Book(2L,"목민심서","정양욕",30000);
        Book book3 = new Book(2L,"목민심서","정양욕",30000);

        //toString 호출 객체를 문자열로써 출력해야 할때 자동으로 호출
        System.out.println("book1 : "+book1);
        System.out.println("book2 : "+book2);
        System.out.println("book3 : "+book3);


    }
}
