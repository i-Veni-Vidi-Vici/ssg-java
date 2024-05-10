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
        System.out.println("✨ 주문 시작 ✨");
        // 반복처리
        // 1. 1턴 돌때마다 주문 내역을 OrderMenuDto 객체로 생성
        // 2. List<OrderMenuDto>에 추가
        // 3. totalOrderPrice 누적
        List<OrderMenuDto> orderMenuList = new ArrayList<>();
        int totalOrderPrice = 0;
        while (true) {
            // - 카테고리 선택
            menuController.findAllCategory();
            System.out.print("> 카테고리 선택 : ");
            int categoryCode = sc.nextInt();
            // - 선택한 카테고리의 메뉴 노출
            List<MenuDto> menuList = menuController.findMenuOrderableByCategoryCode(categoryCode);
            if(menuList.isEmpty()) continue;
            // - 사용자 : 메뉴 선택
            System.out.print("> 메뉴 선택 : ");
            int menuCode = sc.nextInt();
            int menuPrice = menuList.stream().filter((menu) -> menu.getMenuCode() == menuCode)
                             .findFirst() // Optional<MenuDto>
                             .get()
                             .getMenuPrice();
            // - 사용자 : 수량 선택
            System.out.print("> 수량 선택 : ");
            int orderAmount = sc.nextInt();

            // OrderMenu 객체 처리
            OrderMenuDto orderMenuDto =  new OrderMenuDto(0, menuCode, orderAmount);
            orderMenuList.add(orderMenuDto);
            // 결제금액 totalOrderPrice 처리
            totalOrderPrice += menuPrice * orderAmount;

            // - 추가주문 여부 선택 (추가주문 Y -> 맨처음 카테고리 선택)
            System.out.print("> 추가 주문하시겠습니까? (y/n) : ");
            if (sc.next().toLowerCase().charAt(0) != 'y') {
                break;
            }
        }
        // 추가주문 N -> 주문요청 (OrderController에 메세지 전달)
        System.out.println("🎉 주문 요청 🎉");
        OrderDto orderDto = new OrderDto(0, LocalDate.now(), LocalTime.now(), totalOrderPrice, orderMenuList);
        orderController.createOrder(orderDto);

        orderController.createOrder(orderDto);
        System.out.println("주문번호 : " + orderDto.getOrderCode());
        // 결과 확인
    }
}
