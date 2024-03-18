package com.ssg.test.loop;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Test6 test6 = new Test6();
        test6.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------- 메뉴 ---------");
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
        System.out.println();

        String menu = "";   // 선택한 메뉴
        int quantity = 0;   // 선택한 수량
        char additional;  // 추가주문 여부
        int price = 0;  // 가격
        int sumEach = 0;   // 각 주문의 가격의 총합
        int sumAll = 0; // 전체 주문의 가격의 총합
        String result = ""; // 입력받은 결과

        do {
            System.out.print("메뉴를 선택하세요 : ");
            menu = sc.next();
            System.out.print("수량을 선택하세요 : ");
            quantity = sc.nextInt();
            System.out.print("추가 주문 여부를 선택하세요 : ");
            additional = sc.next().charAt(0);
            System.out.println();

            switch (menu) {
                case "원조김밥":
                    price = 1500;
                    break;
                case "치즈김밥":
                    price = 2000;
                    break;
                case "참치김밥":
                    price = 2300;
                    break;
                case "그냥라면":
                    price = 3000;
                    break;
                case "치즈라면":
                    price = 3500;
                    break;
                case "짬뽕라면":
                    price = 4000;
                    break;
                case "떡볶이":
                    price = 2500;
                    break;
                case "순대":
                    price = 2500;
                    break;
                case "오뎅":
                    price = 1000;
                    break;
                case "음료수":
                    price = 1000;
                    break;
            }

            sumEach = price * quantity;
            result += menu + ": " + quantity + "개 - " + sumEach + "원\n";
            sumAll += sumEach;

        } while(additional == 'y'); // 추가주문 y일 동안

        System.out.println("주문하신 정보는 다음과 같습니다.");
        System.out.println("==============================");
        System.out.print(result);
        System.out.println("------------------------------");
        System.out.println("합계 : " + sumAll + "원");
        System.out.println("==============================");
        System.out.println("감사합니다 😃");
    }
}
