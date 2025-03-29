package com.sh.level02.normal.book;

public class App {
    public static void main(String[] args) {

        //기본 생성자를 이용하여 인스턴스 생성 후 필드 값 출력
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("자바 프로그래밍");
        bookDTO.setPublisher("한빛 미디어");
        bookDTO.setAuthor("홍길동");
        bookDTO.setPrice(10000);
        bookDTO.setDiscountRate(10.0);

        bookDTO.printInformation(bookDTO);
//        System.out.println(bookDTO.getTitle());
//        System.out.println(bookDTO.getPublisher());
//        System.out.println(bookDTO.getAuthor());
//        System.out.println(bookDTO.getPrice());
//        System.out.println(bookDTO.getDiscountRate());

        System.out.println();

        //필드 3가지를 초기화하는 생성자를 이용하여 인스턴스 생성후 필드 값 출력
        BookDTO bookDTO1 = new BookDTO("파이썬","빛나미디어","신사임당");
        bookDTO1.setPrice(20000);
        bookDTO1.setDiscountRate(30.0);
        bookDTO1.printInformation(bookDTO1);

        System.out.println();

        //모든 필드를 초기화 하는 생성자를 이용하여 인스턴스 생성 후 필드 값 출력
        BookDTO bookDTO3 = new BookDTO("스프링","JET Brain","이순신",40000,50.0);
        bookDTO1.printInformation(bookDTO3);



    }
}
