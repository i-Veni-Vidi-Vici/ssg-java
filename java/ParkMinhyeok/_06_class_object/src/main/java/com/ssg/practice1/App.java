package com.ssg.practice1;

public class App {
    public static void main(String[] args) {
        BookDto bookDto = new BookDto();
        bookDto.printInformation();

        BookDto bookDto2 = new BookDto("자바의 정석", "도우출판", "남궁성");
        bookDto2.printInformation();

        BookDto bookDto3 = new BookDto("홍길동전", "활빈당", "허균", 5000000, 0.5);
        bookDto3.printInformation();
    }
}
