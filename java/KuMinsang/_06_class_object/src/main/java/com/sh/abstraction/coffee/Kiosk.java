package com.sh.abstraction.coffee;

import java.util.Scanner;

public class Kiosk {
    private Scanner sc = new Scanner(System.in);
    private Barista barista = new Barista();

    public void menu(){
        String menu = """
                =======================
                     커피 주문 프로그램
                1. 아메리카노
                2. 아보카도
                3. 라떼
                0. 종료
                ========================
                선택 :\s""";
        while(true){
            System.out.println(menu);
            String choice = sc.next();
            String menuName = null;
            String option = null;
            int count = 0;
            Order order = null;

            switch(choice){
                case "1" :
                    menuName = "아메리카노";
                    option = optionMenu();
                    count = inputCount();
                    order = createOrder(menuName, option, count);
                    if(order != null){
                        sendCoffeeRequest(order);
                    }
                    break;
                case "2" :
                    menuName = "아보카도";
                    option = optionMenu();
                    break;

                case "3" :
                    menuName = "라떼";
                    option = optionMenu();
                    break;
                case "0" : return;
                default :
                    System.out.println("잘못 입력 하셨습니다.");

            }
        }
    } //eoKiosk

    private String optionMenu() {
        String menu = """
                --------------------
                      옵션 선택
                --------------------
                1. Hot
                2. Ice
                --------------------
                선택 :\s""";
        System.out.println(menu);
        return sc.next();
    }

    public Order createOrder(String menuName, String option, int count){
        //주문 생성
        Order order = new Order(menuName, option, count);
        boolean confirmed = confirmOrder(order);
        return confirmed? order: null;
    }

    public boolean confirmOrder(Order order){
        System.out.println("주문 내역을 확인하세요...");
        System.out.println("""
                음료: %s
                옵션: %s
                수량: %d
                맞으면 1 틀리면 2를 입력해주세요
                """.formatted(order.getMenuName(), order.getOption(), order.getCount()));
        return sc.next().equals("1")? true : false;
    }
    public void sendCoffeeRequest(Order order){
        Coffee coffee = barista.makeCoffee(order);
        System.out.println("주문하신 ["+coffee.getCoffeeName()+" " + coffee.getOption() +"욥션 ]"+ coffee.getCount()+"잔이 나왔습니다");
    }
    public int inputCount(){
        System.out.println("수량 : ");
        return sc.nextInt();
    }

}
