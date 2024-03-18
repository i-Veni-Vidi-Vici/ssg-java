package com.ssg.test.loop;

import java.util.Scanner;

public class Test6 {

    public static void main(String[] args) {
        Test6 test6 = new Test6();
        test6.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);

        int sumCost = 0;
        String list = "";

        home :
        for (; ; ) {
            System.out.println("""
                김밥류 ===================
                1.원조김밥===========1500원
                2.치즈김밥===========2000원
                3.참치김밥===========2300원
                라면류 ===================
                4.그냥라면===========3000원
                5.치즈라면===========3500원
                6.짬뽕라면===========4000원
                분식류 ===================
                7.떡볶이=============2500원
                8.순대==============2500원
                9.오뎅==============1000원
                기타 ====================
                10.음료수===========1000원
                """);

            System.out.println("메뉴를 선택해주세요 : ");
            int userMenu = sc.nextInt();
            System.out.println("수량을 입력해주세요 : ");
            int userNum = sc.nextInt();

            System.out.println("추가 주문하시겠습니까? (y/n) : ");
            char addOrder = sc.next().charAt(0);

            String menu = "";
            int cost = 0;
            switch (userMenu) {
                case 1 : menu = "원조김밥"; cost = 1500; break;
                case 2 : menu = "치즈김밥"; cost = 2000; break;
                case 3 : menu = "참치김밥"; cost = 2300; break;
                case 4 : menu = "그냥라면"; cost = 3000; break;
                case 5 : menu = "치즈라면"; cost = 3500; break;
                case 6 : menu = "짬뽕라면"; cost = 4000; break;
                case 7 : menu = "떡볶이"; cost = 2500; break;
                case 8 : menu = "순대"; cost = 2500; break;
                case 9 : menu = "오뎅"; cost = 1000; break;
                case 10 : menu = "음료수"; cost = 1000; break;
            }
            list += (menu + ": " + userNum + "개 - " + cost*userNum + "\n");
            sumCost += cost*userNum;

            if (addOrder == 'y') {
                continue home;
            } else if (addOrder == 'n') {
                System.out.println("주문하신 정보는 다음과 같습니다.");
                System.out.println("============================");
                System.out.println(list);
                System.out.println("----------------------------");
                System.out.println("합계 : " + sumCost + "원");
                System.out.println("============================");
                System.out.println("감사합니다");
                break;
            }
        }
    }
}