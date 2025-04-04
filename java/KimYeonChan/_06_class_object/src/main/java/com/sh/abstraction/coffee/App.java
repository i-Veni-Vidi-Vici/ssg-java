package com.sh.abstraction.coffee;

/**
 * 커피 주문 프로그램
 * 1. 요구사항
 * - 사용자는 키오스크를 통해 커피를 주문할 수 있어야 한다.
 * - 사용자는 키오스크를 통해 제시된 메뉴를 선택할 수 있다.
 * - 커피를 주문할때 종류, 온도, 수량 등을 선택 할 수 있다.
 * - 사용자는 주문한 내용을 확인 할 수 있어야 한다.
 * - 주문이 완료되면 바리스타에게 제조 요청이 전달되어야 한다.
 * - 바리스타는 주문 내용을 확인하고, 그에 맞게 제조한다.
 * - 바리스타는 커피 제조시마다 재고량을 관리한다.
 * 2. 객체 도출
 * - 사용자
 * - 키오스크
 * - 주문
 * - 메뉴
 * - 커피
 * - 커피 속성 (종류, 온도, 수량)
 * - 바리스타
 * 3. 객체 상호작용 다이어그램
 * - 사용자 -> 키오스크(메뉴) --주문(메뉴)--> 바리스타 -> 커피 -> 사용자
 * - 사용자 --메뉴를 보여줘라--> 키오스크 --> 사용자
 * - 사용자 --종류/온도/개수--> 키오스크
 * - 키오스크 --주문 확인--> 사용자 --주문 승인--> 키오스크 --주문서--> 바리스타 --재고량 확인--> 커피 제조
 * 4. 객체가 수신해야 하는 메세지 (메소드)
 * - 키오스크
 *      - 메뉴를 제공하라
 *      - 사용자 선택에 따라 주문 생성
 *      - 생성된 주문을 보여달라
 *      - 주문을 바리스타에게 전달하라
 * - 바리스타
 *      - 주문에 따라 커피를 만들어라 (커피를 제공)
 * 5. 클래스 설계
 */
public class App {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.menu();
    }
}
