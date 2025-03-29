package com.sh.abstraction.coffee;

import java.util.Scanner;

/**
 * Kiosk 수신메시지 목록
 * 메뉴제공하라,
 * 사용자선택에 따라 주문을 생성하라,
 * 생성된 주문을 보여달라,
 * 주문을 바리스타에게 전달하라
 */
public class Kiosk {
    private Scanner sc = new Scanner(System.in);
    private Barista barista = new Barista();

    public void menu() {
        String menu = """
                =================
                  커피주문 프로그램
                =================
                1. 아메리카노
                2. 라떼
                0. 종료
                ================
                선택 : """;
        while (true) {
            System.out.println(menu);
            String choice = sc.next();
            String menuName = null;
            String option = null;
            Order order = null;
            int count = 0;
            switch (choice) {
                case "1":
                    menuName = "아메리카노";
                    option = optionMenu();
                    count = inputCount();
                    order =createOrder(menuName, option, count);
                    if (order != null) {
                        sendCoffeeRequest(order);
                    }
                    break;
                case "2":
                    menuName = "라떼";
                    option = optionMenu();
                    count = inputCount();
                    order =createOrder(menuName, option, count);
                    if (order != null) {
                        sendCoffeeRequest(order);
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }

    }

    private int inputCount() {
        System.out.print("수량을 입력해 주세요 :");
        return sc.nextInt();
    }

    private String optionMenu() {
        String menu = """
                -------------------
                옵션 선택
                -------------------
                1. HOT
                2. ICE
                -------------------
                선택 : """;
        System.out.print(menu);
        return sc.next().equals("1") ? "HOT" : "ICE";
    }

    private Order createOrder(String menuName, String option, int count) {
        // 주문생성
        Order order = new Order(menuName, option, count);
        // 주문확인
        boolean confirmed = confirmOrder(order);
        return confirmed ? order : null;
    }

    private boolean confirmOrder(Order order) {
        System.out.println("주문 내역을 확인하세요...");
        System.out.println("""
                ----------------------
                메뉴명 : %s
                옵션 : %s
                수량 : %d
                ----------------------
                맞으시면 1을 눌러주세요.
                """.formatted(order.getMenuName(), order.getOption(), order.getCount()));
        return sc.next().equals("1");
    }

    private void sendCoffeeRequest(Order order) {
        Coffee coffee = barista.makeCoffee(order);
        System.out.println("주문하신 ["+  coffee.info() + "]가 나왔습니다.");
    }
}
