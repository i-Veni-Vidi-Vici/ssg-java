package com.sh.abstraction.coffee;

import java.util.Scanner;

/**
 * <pre>
 * Kiosk의 수신메세지 목록
 * 1. 메뉴제공
 * 2. 사용자 선택에 따른 주문생성
 * 3. 생성된 주문 보여주기
 * 4. 주문을 바리스타에게 전달
 * </pre>
 */

public class Kiosk {
    private Scanner sc = new Scanner(System.in);
    private Barista barista = new Barista();
    public void menu(){
        String menu = """
        =====================
           커피 주문 프로그램
        =====================
        1. 아메리카노
        2. 라떼
        0. 종료
        =====================
        선택 : """;
        while (true) {
            System.out.print(menu);
            String choice = sc.next();


            String menuName = null;
            String option = null;
            int count = 0;
            Order order = null;

            switch (choice){
                case "1":
                    menuName = "아메리카노";
                    option = optionMenu();
                    count = inputCount();
                    order = createOrder(menuName, option, count);
                    if (order != null){
                        sendCoffeeRequest(order);
                    }
                    break;
                case "2":
                    menuName = "라떼";
                    option = optionMenu();
                    count = inputCount();
                    order = createOrder(menuName, option, count);
                    if (order != null){
                        sendCoffeeRequest(order);
                    }
                    break;
                case "0": return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    // 외부에 노출할 필요없는 메소드 -> private / App클래스에서는 menu만 호출해도 됨
    private Order createOrder(String menuName, String option, int count){
        // 주문생성
        Order order = new Order(menuName, option, count);
        // 주문확인
        boolean confirmed = confirmOrder(order);
        return confirmed ? order : null;
    }

    private int inputCount() {
        System.out.print("수량을 입력하세요 : ");
        return sc.nextInt();
    }

    private String optionMenu() {
        String menu = """
        ------------------
        옵션 선택
        ------------------
        1. HOT
        2. ICE
        ------------------
        선택 : """;
        System.out.println(menu);
        return sc.next().equals("1") ? "HOT" : "ICE";
    }

    private boolean confirmOrder(Order order){
        System.out.println("주문 내역을 확인하세요.");
        System.out.print("""
        ---------------------------------------
        메뉴명 : %s
        옵션 : %s
        수량 : %d
        ---------------------------------------
        주문내용이 맞으면 1, 취소하려면 2를 눌러주세요.
        입력 : """.formatted(order.getMenuName(), order.getOption(), order.getCount()));
        return sc.next().equals("1");
    }
    private void sendCoffeeRequest(Order order){
        Coffee coffee = barista.makeCoffee(order);
        System.out.println("주문하신 [" + coffee.info() + "]가 나왔습니다.");
    }
}
