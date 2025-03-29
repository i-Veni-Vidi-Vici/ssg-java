package com.ssg.test.loop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Map<String, Integer> menus = new HashMap<>();
        menus.put("원조김밥", 1500);
        menus.put("치즈김밥", 2000);
        menus.put("참치김밥", 2300);
        menus.put("그냥라면", 3000);
        menus.put("치즈라면", 3500);
        menus.put("짬뽕라면", 4000);
        menus.put("떡볶이", 2500);
        menus.put("순대", 2500);
        menus.put("오뎅", 1000);
        menus.put("음료수", 1000);
        Scanner scanner = new Scanner(System.in);
        char extraOrder = 'y';
        String orderList = "";
        int totalPrice = 0;
        do{
            System.out.println("김밥류 ===================\n" +
                    "1.원조김밥===========1500원\n" +
                    "2.치즈김밥===========2000원\n" +
                    "3.참치김밥===========2300원\n" +
                    "라면류 ===================\n" +
                    "4.그냥라면===========3000원\n" +
                    "5.치즈라면===========3500원\n" +
                    "6.짬뽕라면===========4000원\n" +
                    "분식류 ===================\n" +
                    "7.떡볶이=============2500원\n" +
                    "8.순대==============2500원\n" +
                    "9.오뎅==============1000원\n" +
                    "기타 ====================\n" +
                    "10.음료수===========1000원\n");
            System.out.printf("메뉴선택: ");
            int choiceNum = scanner.nextInt();
            System.out.printf("수량입력: ");
            int quantity = scanner.nextInt();
            if(choiceNum<1 || choiceNum>10 || quantity<0){
                System.out.println("주문번호 또는 수량 오류입니다. 다시 시도하십시오.");
                continue;
            }
            switch (choiceNum){
                case 1: orderList += "원조김밥: " +quantity+"개 - " + menus.get("원조김밥")*quantity+"원 \n";
                        totalPrice +=menus.get("원조김밥")*quantity;
                        break;
                case 2: orderList += "치즈김밥: " +quantity+"개 - " + menus.get("치즈김밥")*quantity+"원 \n";
                        totalPrice +=menus.get("치즈김밥")*quantity;
                        break;
                case 3: orderList += "참치김밥: " +quantity+"개 - " + menus.get("참치김밥")*quantity+"원 \n";
                        totalPrice += menus.get("참치김밥")*quantity;
                        break;
                case 4: orderList += "그냥라면: " +quantity+"개 - " + menus.get("그냥라면")*quantity+"원 \n";
                        totalPrice += menus.get("그냥라면")*quantity;
                        break;
                case 5: orderList += "치즈라면: " +quantity+"개 - " + menus.get("치즈라면")*quantity+"원 \n";
                        totalPrice += menus.get("치즈라면")*quantity;
                        break;
                case 6: orderList += "짬뽕라면: " +quantity+"개 - " + menus.get("짬뽕라면")*quantity+"원 \n";
                        totalPrice += menus.get("짬뽕라면")*quantity;
                        break;
                case 7: orderList += "떡볶이: " +quantity+"개 - " + menus.get("떡볶이")*quantity+"원 \n";
                        totalPrice += menus.get("떡볶이")*quantity;
                        break;
                case 8: orderList += "순대: " +quantity+"개 - " + menus.get("순대")*quantity+"원 \n";
                        totalPrice += menus.get("순대")*quantity;
                        break;
                case 9: orderList += "오뎅: " +quantity+"개 - " + menus.get("오뎅")*quantity+"원 \n";
                        totalPrice += menus.get("오뎅")*quantity;
                        break;
                case 10: orderList += "음료수: " +quantity+"개 - " + menus.get("음료수")*quantity+"원 \n";
                        totalPrice += menus.get("음료수")*quantity;
                        break;
                default: orderList += "주문오류"; break;
            }

            System.out.printf("추가주문 여부 y / n : ");
            extraOrder = scanner.next().charAt(0);
        }while(extraOrder != 'n' && extraOrder != 'N');

        System.out.println("주문하신 정보는 다음과 같습니다.");
        System.out.println("==============================");
        System.out.println(orderList);
        System.out.println("총 주문금액: "+ totalPrice+ "원");
        System.out.println("==============================");
    }
}
