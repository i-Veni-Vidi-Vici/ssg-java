package com.sh.abstraction.coffee;

import java.util.Scanner;

/**
 *  - 키오스크 :
 *  *  메뉴제공,
 *  *  사용자 선택에 따라 주문 생성,
 *  *  생성된 주문을 보여주기,
 *  *  주문을 바리스타에게 전달하기 ...
 */
public class Kiosk {
    private Scanner sc = new Scanner(System.in);
    private Barista barista = new Barista();
    public void menu() {
        String menu = """
                ========================
                    커피 주문 프로그램
                ========================
                1. 아메리카노
                2. 라떼
                0. 종료
                ========================
                선택 :\t""";
        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            String menuName = null;
            String option = null;
            int count = 0;
            Order order = null; // Switch문에서 사용할 클래스는 바깥에서 선언
            switch (choice) {
                case "1" : menuName = "아메리카노";
                    option = optionMenu(); // String
                    count = inputCount(); // int
                    order = createOrder(menuName, option, count);
                    if (order != null) {
                        sendCoffeeRequest(order);
                    }
                    break;
                case "2" : menuName = "라떼";
                    option = optionMenu(); // String
                    count = inputCount(); // int
                    order = createOrder(menuName, option, count);
                    if (order != null) {
                        sendCoffeeRequest(order);
                    }
                    break;
                case "0" : return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    private int inputCount() {
        System.out.println("수량을 입력하세요 : ");
        return sc.nextInt();
    }

    private String optionMenu() {
        String menu = """
                ------------------------
                옵션 선택
                ------------------------
                1. HOT
                2. ICE
                ------------------------
                선택 :\t""";
        System.out.print(menu);
        return sc.next().equals("1") ? "HOT" : "ICE";
    }

    public Order createOrder(String menuName, String option, int count) {
        // 주문 생성
        Order order = new Order(menuName, option, count);
        // 주문 확인
        boolean confirmed = confirmOrder(order);
        return confirmed ? order : null;
    }

    public boolean confirmOrder(Order order) {
        System.out.println("주문 내역을 확인하세요...");
        System.out.println("""
                ------------------------
                메뉴명 : %s
                옵션 : %s
                수량 : %d
                ------------------------
                주문내용이 맞으면 1, 
                취소하려면 2를 눌러주세요 ...
                ------------------------
                입력 :\t""".formatted(order.getMenuName(), order.getOption(), order.getCount()));
        return sc.next().equals("1");
    }

    public void sendCoffeeRequest(Order order) {
        Coffee coffee = barista.makeCoffee(order);
        System.out.println("주문하신 [" + coffee.info() + "]가 나왔습니다.");
    }
}
