package com.ssg.book.run;

import com.ssg.book.model.dto.BookDTO;

public class App {
    public static void main(String[] args) {
        BookDTO bookDTO1 = new BookDTO();
        bookDTO1.printInformation();

        BookDTO bookDTO2 = new BookDTO("자바의 정석", "도우출판 ", "남궁성");
        bookDTO2.printInformation();

        BookDTO bookDTO3 = new BookDTO("홍길동전", "활빈당", "허균", 5000000, 0.5);
        bookDTO3.printInformation();

        /**
         * 실행 결과 예시
         * null, null, null, 0, 0.0
         * 자바의 정석, 도우출판, 남궁성, 0, 0.0
         * 홍길동전, 활빈당, 허균, 5000000, 0.5
         */
    }
}
