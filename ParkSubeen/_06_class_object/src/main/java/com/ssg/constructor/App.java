package com.ssg.constructor;

public class App {
    public static void main(String[] args) {
        // 기본 생성자를 이용하여 인스턴스 생성 후 필드 값 출력
        BookDto bookDto1 = new BookDto();
        bookDto1.printInformation(bookDto1);

        // 필드 3가지를 초기화하는 생성자를 이용하여 인스턴스 생성 후 필드 값 출력
        BookDto bookDto2 = new BookDto("자바의 정석", "도우출판", "남궁성");
        bookDto2.printInformation(bookDto2);

        // 모든 필드를 초기화하는 생성자를 이용하여 인스턴스 생성 후 필드 값 출력
        BookDto bookDto3 = new BookDto("홍길동전", "활빈당", "허균", 5_000_000, 0.5);
        bookDto3.printInformation(bookDto3);
    }
}
