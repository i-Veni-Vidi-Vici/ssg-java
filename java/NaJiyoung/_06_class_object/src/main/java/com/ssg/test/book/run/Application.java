package com.ssg.test.book.run;

import com.ssg.test.book.model.dto.BookDTO;

public class Application {
    public static void main(String[] args) {
        // 기본 생성자를 이용하여 인스턴스 생성 후 필드 값 출력
        BookDTO bookDTO1 = new BookDTO();
        bookDTO1.printInformation();

        // 필드 3가지를 초기화하는 생성자를 이용하여 인스턴스 생성 후 필드 값 출력
        BookDTO bookDTO2 = new BookDTO("자바의 정석", "도우출판", "남궁성");
        bookDTO2.printInformation();

        // 모든 필드를 초기화하는 생성자를 이용하여 인스턴스 생성 후 필드 값 출력
        BookDTO bookDTO3 = new BookDTO("홍길동전", "활빈당", "허균", 5_000_000, 0.5);
        bookDTO3.printInformation();
    }
}
