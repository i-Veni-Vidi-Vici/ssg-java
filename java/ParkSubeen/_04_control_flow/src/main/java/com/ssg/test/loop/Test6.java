package com.ssg.test.loop;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) { // To-do 😢😢😢😢😢
        Scanner sc = new Scanner(System.in);
        String menu, menuNum = "", orderList = "";
        int num, price = 0, total = 0;
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

            System.out.print("> 메뉴 선택 : ");
            menu = sc.next();
            switch(menu) {
                case "1": menuNum = "원조김밥"; price = 1500; break;
                case "2": menuNum = "치즈김밥"; price = 2000; break;
                case "3": menuNum = "참치김밥"; price = 2300; break;
                case "4": menuNum = "그냥라면"; price = 3000; break;
                case "5": menuNum = "치즈라면"; price = 3500; break;
                case "6": menuNum = "짬뽕라면"; price = 4000; break;
                case "7": menuNum = "떡볶이"; price = 2500; break;
                case "8": menuNum = "순대"; price = 2500; break;
                case "9": menuNum = "오뎅"; price = 1000; break;
                case "10": menuNum = "음료수"; price = 1000; break;
            }
            System.out.print("> 수량 선택 : ");
            num = sc.nextInt();

            total += price * num;
            orderList += (menuNum + ": " + num + "개 - " + total + "원");

            System.out.print("추가주문여부선택 y/n : ");
            more = sc.next().charAt(0);
            if(more == 'y') {
                orderList += "\n";
            }
        } while (more == 'y');
        System.out.println("주문하신 정보는 다음과 같습니다.");
        System.out.println("==============================");
        System.out.println(orderList);
        System.out.println("------------------------------");
        System.out.println("합계 : " + total);
        System.out.println("==============================");
        System.out.println("감사합니다 😀");


        // 강사님 코드
//        Scanner sc = new Scanner(System.in);
//        String menu = "김밥류 ===================\n"
//                + "1.원조김밥===========1500원\n"
//                + "2.치즈김밥===========2000원\n"
//                + "3.참치김밥===========2300원\n"
//                + "라면류 ===================\n"
//                + "4.그냥라면===========3000원\n"
//                + "5.치즈라면===========3500원\n"
//                + "6.짬뽕라면===========4000원\n"
//                + "분식류 ===================\n"
//                + "7.떡볶이=============2500원\n"
//                + "8.순대==============2500원\n"
//                + "9.오뎅==============1000원\n"
//                + "기타 ====================\n"
//                + "10.음료수===========1000원\n";
//        char moreOrder = ' ';
//        String order = "";
//        int sum = 0;
//
//        do {
//            System.out.print(menu);
//            System.out.print("메뉴선택 => ");
//            String menuNum = sc.next();
//
//            System.out.print("수량선택 => ");
//            int count = sc.nextInt();
//
//            int price = 0;
//
//            switch (menuNum) {
//                case "1":
//                    price = 1500 * count;
//                    sum += price;
//                    order += "원조김밥: " + count + "개 - " + price + "원";
//                    break;
//                case "2":
//                    price = 2000 * count;
//                    sum += price;
//                    order += "치즈김밥: " + count + "개 - " + price + "원";
//                    break;
//                case "3":
//                    price = 2300 * count;
//                    sum += price;
//                    order += "참치김밥: " + count + "개 - " + price + "원";
//                    break;
//                case "4":
//                    price = 3000 * count;
//                    sum += price;
//                    order += "그냥라면: " + count + "개 - " + price + "원";
//                    break;
//                case "5":
//                    price = 3500 * count;
//                    sum += price;
//                    order += "치즈라면: " + count + "개 - " + price + "원";
//                    break;
//                case "6":
//                    price = 4000 * count;
//                    sum += price;
//                    order += "짬뽕라면: " + count + "개 - " + price + "원";
//                    break;
//                case "7":
//                    price = 2500 * count;
//                    sum += price;
//                    order += "떡볶이: " + count + "개 - " + price + "원";
//                    break;
//                case "8":
//                    price = 2500 * count;
//                    sum += price;
//                    order += "순대: " + count + "개 - " + price + "원";
//                    break;
//                case "9":
//                    price = 1000 * count;
//                    sum += price;
//                    order += "오뎅: " + count + "개 - " + price + "원";
//                    break;
//                case "10":
//                    price = 1000 * count;
//                    sum += price;
//                    order += "음료수: " + count + "개 - " + price + "원";
//                    break;
//                default:
//                    System.out.println("잘못누르셨습니다.");
//                    break;
//            }
//
//            System.out.print("추가주문하시겠습니까?(y/n) => ");
//            moreOrder = sc.next().toLowerCase().charAt(0);
//
//            // 개행문자추가
//            if (moreOrder == 'y')
//                order += "\n";
//
//        } while (moreOrder == 'y');
//
//        System.out.println("주문하신 정보는 다음과 같습니다.\n----------------------------");
//        System.out.println(order);
//        System.out.println("----------------------------");
//        System.out.println("합계 : " + sum + "원");
    }
}
