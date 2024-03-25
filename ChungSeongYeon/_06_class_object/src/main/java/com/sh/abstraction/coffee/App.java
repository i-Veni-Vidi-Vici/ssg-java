package com.sh.abstraction.coffee;

/**
 * <pre>
 * 커피 주문 프로그램
 * 1. 요구사항
 * - 사용자는 키오스크를 통해 커피를 주문할 수 있어야 한다.
 * - 사용자는 키오스크에 제시된 메뉴를 선택할 수 있다.
 * - 커피를 주문할 때 종류, 온도, 수량 등을 선택할 수 있다.
 * - 사용자는 주문한 내용을 확인할 수 있어야 한다.
 * - 주문이 완료되면 바리스타에게 제조 요청이 전달되어야 한다.
 * - 바리스타는 주문 내용을 확인하고 그에 맞게 제조한다.
 * - 바리스타는 커피 제조시마다 재고량을 관리한다.
 *
 * 2. 객체 도출
 * - 키오스크
 * - 바리스타
 * - 사용자
 * - 커피
 * - 커피 속성 (종류, 온도, 수량) --생략
 * - 주문
 * - 메뉴 --생략
 *
 * 3. 객체 상호작용 다이어그램
 * - 사용자 -> 키오스크(메뉴) -> 주문(메뉴) -> 바리스타 -> 커피
 *       <--------------------------------------------
 * - 사용자 -- 메뉴를 보여줘라 --> 키오스크
 *      <-----------메뉴------------
 *      --------종류/온도/갯수------->
 *      <-----------주문------------
 *            -------주문승인------->
 *                                 ----주문에 따라 커피를 만들어라----> 바리스타---재고량 확인 ---> 커피 제조
 *
 * 4. 객체가 수신해야 하는 메세지 (메소드)
 * - 키오스크 :
 *      메뉴 제공하라,
 *      사용자 선택에 따라 주문을 생성하라,
 *      생성된 주문을 보여달라,
 *      주문을 바리스타에게 전달하라
 * - 바리스타 :
 *      주문에 따라 커피를 만들어라(커피를 제공)
 *
 * 5. 클래스 설계
 * </pre>
 */

public class App {
    public static void main(String[] args){
        Kiosk kiosk = new Kiosk();
        kiosk.menu();
    }

}
