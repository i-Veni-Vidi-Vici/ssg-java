package com.sh.run;

import com.sh.menu.view.MenuView;
import com.sh.order.view.OrderMenu;

/**
 * <pre>
 * MVC패턴
 * - 어플리케이션에 필요한 구성요소를 view, controller, model로 분류해서 관리하는 디자인패턴
 * - view 사용자 인터페이스 담당 (사용자메뉴, 사용자입력폼, 사용자요청에 따른 응답출력 담당)
 * - controller mvc패턴의 핵심(컨트롤타워)
 *      - view로부터 사용자 요청 수집.
 *      - 업무처리에 필요한 서비스선정
 *      - 데이터 가공
 *      - 예외 처리
 * - model > service 업무처리 담당. db Connection 객체 생성/반환 및 트랜잭션 책임
 * - model > dao db접근객체(Data Access Object)
 *      - service로부터 Connection객체를 넘겨받아 PreparedStatement 생성
 *      - 쿼리를 담당, 실행, ResultSet 처리
 * - model > dto 데이터 전달 객체 (Data Transfer Object)
 *      - 사용자입력값 전달 (view -> dao)
 *      - DB데이터 전달 (dao -> view)
 *
 *
 *
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        new MenuView().mainMenu();
        // new OrderMenu().mainMenu();
    }
}