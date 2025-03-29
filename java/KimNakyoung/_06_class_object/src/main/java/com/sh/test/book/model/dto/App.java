package com.sh.test.book.model.dto;

public class App {
    public static void main(String[] args) {
        //기본 생성자를 이용하여 인스턴스 생성 후 필드 값 출력
        //필드 3가지를 초기화하는 생성자를 이용하여 인스턴스 생성 후 필드 값 출력
        //모든 필드를 초기화하는 생성자를 이용하여 인스턴스 생성 후 필드 값 출력

        BookDTO bookDTO1 = new BookDTO();
        bookDTO1.printlnformation();

        BookDTO bookDTO2 = new BookDTO("자바의 정석", "도우출판","남궁성");
        bookDTO2.printlnformation();

        BookDTO bookDTO3 = new BookDTO("홍길동전","활빈당","허균",5000000,0.5);
        bookDTO3.printlnformation();





    }
}
