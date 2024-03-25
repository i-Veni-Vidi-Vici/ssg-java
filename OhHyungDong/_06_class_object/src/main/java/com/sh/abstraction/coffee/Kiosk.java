package com.sh.abstraction.coffee;

import java.util.Scanner;

/**
 * <pre>
 * Kiosk 수신 메세지 목록
 *    -> 메뉴 제공, 사용자 선택에 따라서 주문 생성 , 생성된 주문을 보여달라, 주문을 바리스타에게 전달 해라
 *
 */
public class Kiosk {

    private Barista barista = new Barista();
    private Scanner scanner = new Scanner(System.in);
    public void menu()
    {
        String menu =
               """
                ===================
                    커피주문 프로그램 
                ===================
                1. Americano
                2. Latte
                0. Exit
                ===================
                선택 : """;
        while(true){
            System.out.println(menu);
            String choice = scanner.next();
            String menuName = null;
            String option = null;
            int count = 0;
            Order order = new Order(menuName, option,count);
            switch (choice){
                case "1" :
                    menuName = "Americano";
                    option = optionMenu();
                    count = inputCount();
                    order = createOrder(menuName, option, count);
                    if(order != null) sendCoffeeRequest(order);

                    break;
                case "2" :
                    menuName = "Latte";
                    option = optionMenu();
                    count = inputCount();
                    order = createOrder(menuName, option, count);
                    if(order == null) sendCoffeeRequest(order);
                    break;
                case "0" : return;
                default :
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
    private  int inputCount()
    {
        System.out.println("수량을 입력하세요 : ");
        return scanner.nextInt();
    }

    private String optionMenu()
    {
        String menu =
          """
          -----------
          옵션 선택
          -----------
          1.Hot
          2.ICE
          -----------
          선택 : """;
        System.out.println(menu);
        return scanner.next().equals("1") ? "HOT" : "ICE";
    }


    public Order createOrder(String menuName,String option, int count)
    {
        //주문 생성
        Order order = new Order(menuName, option, count);
        //주문 확인
        boolean confirmed = confirmOrder(order);
        return  confirmed ? order : null; //confirmed가 true -> order : false : 주문 취소
    }

    public boolean confirmOrder(Order order){
        System.out.println("주문 내역을 확인하세요. ");
        System.out.println("""
         ------------
         메뉴명 : %s
         옵션 : %s
         수량 : %d 
         ------------
         주문 내용이 맞으면 1, 취소하려면 2를 입력하세요.
         입력 : """.formatted(order.getMenuName(), order.getOption(), order.getCount()));
        //
        return scanner.next().equals("1");
    }

    public void sendCoffeeRequest(Order order)
    {
       Coffee coffee = barista.makeCoffee(order); // new Coffee(orderMenu,orderOption,ordergetCount
       System.out.println("주문하신 " + coffee.info() + "가 나왔습니다. ");
    }
}
