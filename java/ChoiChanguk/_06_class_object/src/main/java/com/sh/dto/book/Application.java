package com.sh.dto.book;

public class Application {
    public static void main(String[] args) {
        //이렇게 변수는 같고 = 똑같이 객체를 생성한 경우
        //가비지 컬렉터가 어?? 똑같네?? 그럼 그 전 거는 메모리에서 하차 -> 새로운 객체 주소가 연결됨
        BookDTO bookDTO=new BookDTO();
        bookDTO.printInformation();

        bookDTO=new BookDTO("자바의 정석", "도우풀판","남궁성");
        bookDTO.printInformation();

        bookDTO=new BookDTO("홍길동전","활빈당","허균",5000000,0.5);
        bookDTO.printInformation();
    }
}
