package com.sh.order.view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sh.menu.controller.MenuController;
import com.sh.menu.model.dto.MenuDto;
import com.sh.order.controller.OrderController;
import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.dto.OrderMenuDto;

public class OrderView {
    private Scanner sc = new Scanner(System.in);
    private OrderController orderController = new OrderController();
    private MenuController menuController = new MenuController();

    public void mainMenu() {
        System.out.println("🎈주문을 시작합니다.🎈");
        List<OrderMenuDto> orderMenuList = new ArrayList<>();
        int totalOrderPrice = 0;

        // 반복처리
        // 1. 주문내역을 OrderMenuDto객체로 생성
        // 2. OrderMenuList에 추가
        // 3. totalOrderPrice
        while (true) {
            // - 카테고리 선택
            menuController.findAllCategory();
            System.out.println("카테고리 선택 : ");
            int categoryCode = sc.nextInt();
            // - 선택한 카테고리의 메뉴 노출
            List<MenuDto> menuList = menuController.findByOrderableCategoryCode(categoryCode);
            if(menuList.isEmpty())
                continue;

            // - 메뉴 선택
            System.out.println("메뉴 선택 : ");
            int menuCode = sc.nextInt();

            int menuPrice = menuList.stream()
                                    .filter((menu) -> menu.getMenuCode() == menuCode)
                                    .findFirst()
                                    // return Optional<MenuDto>
                                    .get()
                                    .getMenuPrice();

            // - 수량 선택
            System.out.println("수량 선택 : ");
            int orderAmount = sc.nextInt();

            // OrderMenu객체 처리
            OrderMenuDto orderMenuDto = new OrderMenuDto(0, menuCode, orderAmount, null);
            orderMenuList.add(orderMenuDto);
            // 결제금액 totalOrderPrice 처리
            totalOrderPrice += menuPrice * orderAmount;

            // - 추가주문 여부 선택
            System.out.println("추가 주문하시겠습니까? (y/n) : ");
            if (sc.next().toLowerCase().charAt(0) != 'y')
                break;
        }
        System.out.println(totalOrderPrice);
        // 주문요청 (OrderController 메세지 전달)
        System.out.println("🎇🎇🎇주문을 요청합니다.🎇🎇🎇");
        OrderDto orderDto = new OrderDto(0, LocalDate.now(), LocalTime.now(), totalOrderPrice, orderMenuList);
        orderController.createOrder(orderDto);
        // 결과확인
        System.out.println("주문번호 : " + orderDto.getOrderCode());
        System.out.println("주문 정상 종료");
    }
}