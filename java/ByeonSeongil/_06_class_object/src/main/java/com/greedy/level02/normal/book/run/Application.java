package com.greedy.level02.normal.book.run;

import com.greedy.level02.normal.book.model.dto.BookDTO;

public class Application {
    public static void main(String[] args) {
        //1
        BookDTO bookDTO1 = new BookDTO();
        bookDTO1.printInformation();

        //2
        BookDTO bookDTO2 = new BookDTO("자바의 정석", "도우출판", "남궁성");
        bookDTO2.printInformation();

        //3
        BookDTO bookDTO3 = new BookDTO("홍길동전", "활빈당", "허균", 5000000, 0.5);
        bookDTO3.printInformation();
    }
}
