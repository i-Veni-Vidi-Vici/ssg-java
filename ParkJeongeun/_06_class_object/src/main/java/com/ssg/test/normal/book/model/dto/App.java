package com.ssg.test.normal.book.model.dto;

public class App {
    public static void main(String[] args) {
        BookDTO bookDTO = new BookDTO();
        System.out.printf("%s, %s, %s, %d, %.1f\n",bookDTO.getTitle(),bookDTO.getPublisher(), bookDTO.getAuthor(), bookDTO.getPrice(), bookDTO.getDiscountRate());

        BookDTO bookDTO1 = new BookDTO("자바의 정석", "도우출판", "남궁성");
        System.out.printf("%s, %s, %s, %d, %.1f\n",bookDTO1.getTitle(),bookDTO1.getPublisher(), bookDTO1.getAuthor(), bookDTO1.getPrice(), bookDTO1.getDiscountRate());

        BookDTO bookDTO2 = new BookDTO("홍길동전", "활빈당", "허균", 5_000_000, 0.5);
        System.out.printf("%s, %s, %s, %d, %.1f\n",bookDTO2.getTitle(),bookDTO2.getPublisher(), bookDTO2.getAuthor(), bookDTO2.getPrice(), bookDTO2.getDiscountRate());
    }
}
