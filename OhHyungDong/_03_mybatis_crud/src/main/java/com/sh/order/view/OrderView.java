package com.sh.order.view;

import com.sh.menu.controller.MenuController;
import com.sh.menu.dto.MenuDto;
import com.sh.order.controller.OrderController;
import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.dto.OrderMenuDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    private Scanner scanner = new Scanner(System.in);
    private OrderController orderController = new OrderController();
    private MenuController menuController = new MenuController();

    public void mainMenu() {
        System.out.println("주문을 시작합니다. 🏎");

        List<OrderMenuDto> orderMenuList = new ArrayList<>();
        int totalOrderPrice = 0;
        //반복처리 부분
        //1. 주문 내역을 OrderMenuDto 객체로 생성
        //2. OrderMenuList 객체에 추가
        //3. totalOrderPrice에 누적
        while (true) {
            // - 카테고리 선택
            menuController.findAllCategory();
            System.out.print("카테고리 선택 : ");
            int categoryCode = scanner.nextInt();
            // - 선택한 카테고리의 메뉴 노출
            List<MenuDto> menuList = menuController.findMenuOrderableByCategoryCode(categoryCode);
            if (menuList.isEmpty()) continue;

            // - 메뉴 선택
            System.out.print("메뉴 선택 : ");
            int menuCode = scanner.nextInt();
            int menuPrice = menuList.stream()
                            .filter(menu -> menu.getMenuCode() == menuCode)
                            .findFirst() //반환타입 Option<MenuDto>
                            .get()
                            .getMenuPrice();
            // - 수량 선택
            System.out.print("수량 선택 : ");
            int orderAmount = scanner.nextInt();

            //OrderMenu 객체 처리
            OrderMenuDto orderMenuDto = new OrderMenuDto(0, menuCode, orderAmount,null);
            orderMenuList.add(orderMenuDto);

            //결제금액 totalOrderPrice처리
            totalOrderPrice += menuPrice * orderAmount;
            // - 추가 주문 여부 선택
            System.out.println("추가 주문하시겠습니까 ? Y/N");
            if (scanner.next().toLowerCase().charAt(0) != 'y') break;
        }

        // 주문 요청 (OrderController 메세지 전달)
        System.out.println("주문을 요청합니다. ");
        OrderDto orderDto = new OrderDto(0, LocalDate.now(), LocalTime.now(), totalOrderPrice, orderMenuList);
        System.out.println(orderDto);
        System.out.println("주문번호 :" + orderDto.getOrderCode());

        orderController.createOrder(orderDto);
        // 결과확인
        System.out.println("주문 정상종료");
    }
}
