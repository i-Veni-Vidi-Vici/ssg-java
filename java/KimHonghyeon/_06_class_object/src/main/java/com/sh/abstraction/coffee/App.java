package com.sh.abstraction.coffee;


/**
 * 커피주문프로그램
 * 1. 요구사항
 *  - 사용자는 키오스크를 통해 커피를 주문할 수 있어야한다.
 *  - 사용자는 키오스크에 제시된 메뉴를 선택할 수 있다.
 *  - 커피를 주문할 때 종류, 온도, 수량 등을 선택할 수 있다.
 *  - 사용자는 주문한 내용을 확인할 수 있어야 한다.
 *  - 주문이 완료되면 바리스타에게 제조요청이 전달되어야 한다.
 *  - 바리스타는 주문내용을 확인하고, 그에 맞게 제조한다.
 *  - 바리스타는 커피 제조시마다 재고량을 관리한다.
 *
 * 2. 객체 도출
 *  - 키오스크
 *  - 바리스타
 *  - 커피
 *  - 주문
 *  - 메뉴
 *
 * 3. 객체 상호작용 다이어그램
 *  - 사용자 -> 키오스크 -> 바리스타 -> 커피 -> 사용자
 *
 * 4. 객체가 수신해야 하는 메세지(처리할 메소드)
 *  - 키오스크
 *      1.메뉴제공
 *      2.주문생성
 *      3.주문출력
 *      4.바리스타에게 주문 전달
 * 5. 클래스 설계
 */
public class App {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.menu();
    }
}
