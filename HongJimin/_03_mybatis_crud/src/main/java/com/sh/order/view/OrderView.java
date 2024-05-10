package com.sh.order.view;

import com.sh.menu.controller.MenuController;
import com.sh.menu.model.dto.MenuDto;
import com.sh.order.controller.OrderController;
import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.dto.OrderMenuDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    private Scanner sc = new Scanner(System.in);
    private OrderController orderController = new OrderController();
    private MenuController menuController = new MenuController();

    public void mainMenu() {
        System.out.println("🎈🎈🎈 주문을 시작합니다. 🎈🎈🎈");

        // 주문 객체에 포함된 변수 준비
        List<OrderMenuDto> orderMenuList = new ArrayList<>();
        int totalOrderPrice = 0;

        // 반복처리
        // 1. 주문 내역을 OrderMenuDto 객체로 생성
        // 2. OrderMenuList에 추가
        // 3. totalOrderPrice 누적
        while (true) {
            // - 카테고리 선택
            menuController.findAllCategory();
            System.out.print("카테고리 선택 : ");
            int categoryCode = sc.nextInt();

            // - 선택한 카테고리의 메뉴 노출
            List<MenuDto> menuList = menuController.findMenuOrderableByCategoryCode(categoryCode);
            if(menuList.isEmpty())
                continue; // 없는 메뉴를 선택하더라도 다시 돌아가도록 하는 코드! menuList를 반환 받았으므로 가능함!
            // - 메뉴 선택
            System.out.print("메뉴 선택 : ");
            int menuCode = sc.nextInt();

            // - 수량 선택
            System.out.print("수량 선택 : ");
            int orderAmount = sc.nextInt();
            int menuPrice = menuList.stream()
                    .filter((menu) -> menu.getMenuCode() == menuCode) // 위에서 선택한 메뉴코드와 같은 메뉴 코드인 애를 선택
                    .findFirst() // Optional<MenuDto> -> Optional은 null일 수도 있는 값, 길이가 1인 스트림이라고 보기
                    .get() // MenuDto 꺼내오는 과정
                    .getMenuPrice();

            // OrderMenu 객체 처리
            OrderMenuDto orderMenuDto = new OrderMenuDto(0, menuCode, orderAmount);
            orderMenuList.add(orderMenuDto);
            // 결제 금액 totalOrderPrice 처리
            totalOrderPrice += menuPrice * orderAmount; // view에서 controller에 정보를 요청해 그 정보를 이용하는 경우, controller의 메소드 반환 타입을 void 대신 다 값으로 처리해보기! 선택한 메뉴의 가격을 추가해야하는 상황임

            // - 추가주문 여부 선택
            System.out.print("추가 주문하시겠습니까? (y/n) : ");
            if(sc.next().toLowerCase().charAt(0) != 'y')
                break;
        }

        // 주문 요청 (OrderController 메세지 전달) 및 결과확인
        System.out.println("✨✨✨주문을 요청합니다.✨✨✨");
        OrderDto orderDto = new OrderDto(0, LocalDate.now(), LocalTime.now(), totalOrderPrice, orderMenuList);
        System.out.println(orderDto);

        orderController.createOrder(orderDto); //하나의 주문 정보와 여러개의 주문 메뉴 정보가 있음!
        System.out.println("주문 번호 : " + orderDto.getOrderCode());

        System.out.println("주문 정상 종료!!");


        // 결과 확인
    }
}
