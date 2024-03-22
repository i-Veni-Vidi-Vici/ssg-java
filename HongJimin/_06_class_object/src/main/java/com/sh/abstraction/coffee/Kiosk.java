package com.sh.abstraction.coffee;

import java.util.Scanner;

/**
 * 키오스크 : 수신 메세지 목록
 * 메뉴 제공하라
 * 사용자선택에 따라 주문을 생성하라
 * 생성된 주문을 보여달라
 * 주문을 바리스타에게 전달하라
 */
public class Kiosk {
    private Scanner sc = new Scanner(System.in);
    private Barista barista = new Barista(); //키오스크가 바리스타를 알게 하기 위해서 필드에 변수 선언!

    public void menu() {
        String menu = """
                =====================
                   커피 주문 프로그램
                =====================
                1. 아메리카노
                2. 카페라떼
                0. 종료
                =====================
                선택 :  """;
        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            String menuName = null;
            String option = null;
            int count = 0;
            Order order = null;


            switch (choice) {
                case "1":
                    menuName = "아메리카노";
                    option = optionMenu();
                    count = inputCount();
                    order = createOrder(menuName, option, count);
                    if(order != null) {
                        sendCoffeeRequest(order);
                    }
                    break;
                case "2":
                    menuName = "카페라떼";
                    option = optionMenu();
                    count = inputCount();
                    order = createOrder(menuName, option, count);
                    if(order != null) {
                        sendCoffeeRequest(order);
                    }
                case "0" :
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    private int inputCount() {//외부로 노출할 필요 없기 때문에 private
        System.out.print(" 수량을 입력하세요 : ");
        return sc.nextInt();
    }

    private String optionMenu() { //외부로 노출할 필요 없기 때문에 private
        String menu = """
                --------------------
                 옵션 선택
                --------------------
                 1. HOT
                 2. ICE
                --------------------
                 선택 : """;
        System.out.print(menu);
        return sc.next().equals("1") ? "Hot" : "ICE";
    }

    public Order createOrder(String menuName, String option, int count) {
        // 주문 생성
        Order order = new Order(menuName, option, count);

        // 주문 확인
        boolean confirmed = confirmOrder(order);
        return confirmed ? order : null;

    }

    public boolean confirmOrder(Order order) {
        System.out.println(" 주문 내역을 확인해주세요!");
        System.out.print("""
                ------------------------------
                 메뉴명 : %s
                 옵션 : %s
                 수량  : %d
                -------------------------------
                 주문내용이 맞으면 1,
                          취소하려면 2를 눌러주세요!
                 입력 : """.formatted(order.getMenuName(), order.getOption(), order.getCount()));
        return sc.next().equals("1") ;
    }

    private void sendCoffeeRequest(Order order) {
        Coffee coffee = barista.makeCoffee(order);
        System.out.println("주문하신 [" + coffee.info() + "]가 나왔습니다!");
    }

}
