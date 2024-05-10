package com.sh.order.view;

import com.sh.menu.controller.MenuController;
import com.sh.menu.model.dto.MenuDto;
import com.sh.menu.view.MenuView;
import com.sh.menu.view.ResultView;
import com.sh.order.controller.OrderController;
import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.dto.OrderMenuDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    private OrderController orderController=new OrderController();
    MenuController menuController=new MenuController();
    Scanner sc=new Scanner(System.in);

    public void mainMenu() {
        // 주문객체에 포함된 변수 준비
        List<OrderMenuDto> orderMenuList = new ArrayList<>(); // 장바구니 같은 개념이다
        int totalOrderPrice = 0;
        // 반복처리
        // 1. 주문내역을 OrderMenuDto 객체 생성
        // 2. OrderMenuList에 추가
        // 3. totalOrderPrice 누적
        System.out.println(" --- 주문을 시작합니다 --- ");
        while (true)
        {
            menuController.findAllCategory();
            // 카테고리 선택
            int categoryCode= sc.nextInt();
            // 선택한 카테고리의 메뉴 노출
            List<MenuDto> menuList=menuController.findByOrderableCategoryCodeMenu(categoryCode);
            if(menuList.isEmpty())
                continue;
            // 메뉴선택
            System.out.printf("메뉴 선택 : ");
            int menuCode=sc.nextInt();
            int menuPrice=menuList.stream()
                    .filter((menu)-> menu.getMenuCode()==menuCode)
                    .findFirst()// Optional(MenuDto)
                    .get()
                    .getMenuPrice();


            // 수량선택
            System.out.printf("수량 선택 : ");
            int orderAmount = sc.nextInt();
            totalOrderPrice=orderAmount*menuPrice;

            // OrderMenu 객체 처리
            OrderMenuDto orderMenuDto=new OrderMenuDto(0,menuCode,orderAmount);
            orderMenuList.add(orderMenuDto);// 장바구니 추가
            // 컨트롤러에 시켜서 그 정보를 view에서 쓸 수 있는 경우도 존재한다

            System.out.printf("추가 주문 하시겠습니까?? (Y/N) : ");
            if(sc.next().charAt(0)!='y')
                break;
            // 추가주문 여부 선택 -> 카테고리 선택 or 주문요청
        }

        // 주문요청 (OrderController 메세지 전달)
        System.out.printf(" --- 주문을 요청합니다 --- ");
        OrderDto orderDto=new OrderDto(0, LocalDate.now(), LocalTime.now(),totalOrderPrice,orderMenuList);
        orderController.createOrder(orderDto);
        System.out.println(orderDto);
        // 결과확인 ex)주문번호는 몇번입니다, 송장번호로 쓰면 되겠다
    }
}
