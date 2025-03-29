package com.sh.abstraction.coffee;

import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);
    Barista barista = new Barista();
    public void menu(){
        String menu = """
                ===================
                   커피주문 프로그램
                ===================
                1. 아메리카노
                2. 라떼
                0. 종료
                ===================
                선택: """;
        while(true){
            System.out.print(menu);
            int choice = scanner.nextInt();
            String menuName = null;
            String option;
            Order order;
            switch (choice){
                case 1:
                    menuName="아메리카노";
                    break;
                case 2:
                    menuName="라떼";
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못입력하셨습니다.");
            }
            option = optionMenu();
            int count  = countInput();
            Order newOrder = createOrder(menuName, option, count);
            if(confirmOrder(newOrder)){
                sendOrder(newOrder);
            }
            else{
                System.out.println("처음부터 다시 주문해주세요.");
            }


        }

    }

    private String optionMenu() {
        String option= """
                -----------------
                    옵션 선택
                -----------------
                1. HOT
                2. ICE
                -----------------
                옵션 선택: """;
        System.out.print(option);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                return "HOT";
            case 2:
                return "ICE";
            default:
                System.out.println("잘못입력하셨습니다. 기본값 HOT");
                return "HOT";
        }
    }
    private int countInput(){
        System.out.print("수량을 입력하세요: ");
        int count = scanner.nextInt();
        return count;
    }

    public Order createOrder(String menuName, String option, int count){
        return new Order(menuName, option, count);
    }

    public boolean confirmOrder(Order order){
        System.out.println("주문 내역을 확인하세요.");
        order.printOrder();
        System.out.print("주문 내용이 맞습니까? 1(Yes) / 2(No)");
        int choice = scanner.nextInt();
        return choice==1;
    }

    public void sendOrder(Order order){
        Coffee[] coffees = barista.makeCoffee(order);
        System.out.printf("주문하신 %s %d 잔 나왔습니다.\n", coffees[0].getInfo(), coffees.length);
    }
}
