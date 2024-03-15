package com.ssg.test.loop;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) { // To-do 😢😢😢😢😢
        Scanner sc = new Scanner(System.in);
        int num, cnt = 0, price = 0, sum, total;
        String menu, menuName;
        char more;
        do {
            System.out.println("김밥류 ===================");
            System.out.println("1.원조김밥===========1500원");
            System.out.println("2.치즈김밥===========2000원");
            System.out.println("3.참치김밥===========2300원");
            System.out.println("라면류 ===================");
            System.out.println("4.그냥라면===========3000원");
            System.out.println("5.치즈라면===========3500원");
            System.out.println("6.짬뽕라면===========4000원");
            System.out.println("분식류 ===================");
            System.out.println("7.떡볶이=============2500원");
            System.out.println("8.순대==============2500원");
            System.out.println("9.오뎅==============1000원");
            System.out.println("기타 ====================");
            System.out.println("10.음료수===========1000원");

            System.out.println("> 메뉴 선택 : ");
            menu = sc.next();
            switch(menu) {
                case "1": price = 1500; break;
                case "2": price = 2000; break;
                case "3": price = 2300; break;
                case "4": price = 3000; break;
                case "5": price = 3500; break;
                case "6": price = 4000; break;
                case "7": price = 2500; break;
                case "8": price = 2500; break;
                case "9": price = 1000; break;
                default: price = 1000; break;
            }
            System.out.println("> 수량 선택 : ");
            num = sc.nextInt();

            System.out.println("추가주문여부선택 y/n");
            more = sc.next().charAt(0);
            if(more == 'y') {
                cnt += 1;
            }
        } while (more == 'y');
//        System.out.println("주문하신 정보는 다음과 같습니다.");
//        System.out.println("==============================");
        for(int i = 0; i < cnt; i++) {
            char menuNum = menu.charAt(i);
            switch(menuNum) {
                case '1': menuName = "원조김밥"; break;
                case '2': menuName = "치즈김밥"; break;
                case '3': menuName = "참치김밥"; break;
                case '4': menuName = "그냥라면"; break;
                case '5': menuName = "치즈라면"; break;
                case '6': menuName = "짬뽕라면"; break;
                case '7': menuName = "떡볶이"; break;
                case '8': menuName = "순대"; break;
                case '9': menuName = "오뎅"; break;
                default: menuName = "음료수"; break;
            }
            sum = price * num;
        }
//        System.out.println("------------------------------");
//        System.out.println();
//        System.out.println("==============================");
//        System.out.println("감사합니다 😀");
    }
}
