package com.ssg.test.loop;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
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

        Scanner sc = new Scanner(System.in);

        String orderList = "";
        int totalPrice = 0;
        char isContinue;
        do {
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();
            System.out.print("수량 선택: ");
            int count = sc.nextInt();

            switch (menu) {
                case 1:
                    orderList += "원조김밥: " + count + "개 - ";
                    orderList += 1500 * count + "원\n";
                    totalPrice += 1500 * count;
                    break;
                case 2:
                    orderList += "치즈김밥: " + count + "개 - ";
                    orderList += (2000 * count) + "원\n";
                    totalPrice += 2000 * count;
                    break;
                case 3:
                    orderList += "참치김밥: " + count + "개 - ";
                    orderList += (2300 * count) + "원\n";
                    totalPrice += 2300 * count;
                    break;
                case 4:
                    orderList += "그냥라면: " + count + "개 - ";
                    orderList += (3000 * count) + "원\n";
                    totalPrice += 3000 * count;
                    break;
                case 5:
                    orderList += "치즈라면: " + count + "개 - ";
                    orderList += (3500 * count) + "원\n";
                    totalPrice += 3500 * count;
                    break;
                case 6:
                    orderList += "짬뽕라면: " + count + "개 - ";
                    orderList += (4000 * count) + "원\n";
                    totalPrice += 4000 * count;
                    break;
                case 7:
                    orderList += "떡볶이: " + count + "개 - ";
                    orderList += (2500 * count) + "원\n";
                    totalPrice += 2500 * count;
                    break;
                case 8:
                    orderList += "순대: " + count + "개 - ";
                    orderList += (2500 * count) + "원\n";
                    totalPrice += 2500 * count;
                    break;
                case 9:
                    orderList += "오뎅: " + count + "개 - ";
                    orderList += (1000 * count) + "원\n";
                    totalPrice += 1000 * count;
                    break;
                case 10:
                    orderList += "음료수: " + count + "개 - ";
                    orderList += (1000 * count) + "원\n";
                    totalPrice += 1000 * count;
                    break;
            }

            System.out.println("추가 주문하시겠습니까? (y/n): ");
            isContinue = sc.next().charAt(0);
        } while (isContinue =='y');

        System.out.println("주문하신 정보는 다음과 같습니다.");
        System.out.println("==============================");
        System.out.println(orderList);
        System.out.print("------------------------------");
        System.out.println("합계: " + totalPrice + "원");
        System.out.println("==============================");
        System.out.println("감사합니다 \uD83D\uDE00");
    }
}
