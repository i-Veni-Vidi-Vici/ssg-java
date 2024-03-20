package com.ssg.book;

public class Application {
    public static void main(String[] args) {
        BookDto bookDto = new BookDto();
        bookDto.printInformation(bookDto);

        System.out.println();

        BookDto bookDto1 = new BookDto("자바의 정석", "도우출판", "남궁성");
        bookDto.printInformation(bookDto1);

        System.out.println();

        BookDto bookDto2 = new BookDto("홍길동전", "활빈당", "허균", 5000000, 0.5);
        bookDto.printInformation(bookDto2);
    }
}