package com.ssg.test.loop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("김밥류 =================== \n" +
                "1.원조김밥===========1500원 \n" +
                "2.치즈김밥===========2000원 \n" +
                        "3.참치김밥===========2300원 \n" +
                "라면류 =================== \n" +
                "4.그냥라면===========3000원 \n" +
                "5.치즈라면===========3500원 \n" +
                        "6.짬뽕라면===========4000원 \n" +
                "분식류 =================== \n" +
                "7.떡볶이=============2500원 \n" +
                "8.순대==============2500원 \n" +
                        "9.오뎅==============1000원\n " +
                "기타 ==================== \n" +
                "10.음료수===========1000원\n");

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
        Map<String, Integer> list = new HashMap<>();
        while (true) {
            System.out.print("주문 메뉴 :");
            String menu = sc.next();
            System.out.print("수량 선택 :");
            int count = sc.nextInt();
            list.put(menu, count);

            System.out.print("추가 주문(y/n):");
            char selected = sc.next().charAt(0);
            if (selected == 'n') {
                break;
            }
        }

        System.out.println("주문하신 정보는 다음과 같습니다.");
        System.out.println("==============================");
        int sum =0;
        for (String string : list.keySet()) {
            sum += menus.get(string) * list.get(string);
            System.out.println(string+": "+list.get(string)+"개"+ (menus.get(string)*list.get(string))+ "원");
        }

        System.out.println("-------------------------");
        System.out.println("합계: "+ sum+"원");
    }
}
