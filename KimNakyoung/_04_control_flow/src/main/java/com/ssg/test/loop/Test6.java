package com.ssg.test.loop;

import java.util.Scanner;

/**
 * - 분식집 주문 받는 프로그램을 만들어 보세요.
 * 1. 메뉴선택
 * 2. 수량선택
 * 3. 추가주문여부선택
 * 4. `y`면 1번부터 다시 시작. 단 데이터는 누적.
 * 5. `n`면 주문결과서 출력
 */
public class Test6 {
    public static void main(String[] args) {

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


        Scanner sc = new Scanner(System.in);

//        if(num == 1) {
//            System.out.println("메뉴선택");
//        }
//        if(num == 2) {
//            System.out.println("메뉴선택");
//        }
//        if(num == 3) {
//            System.out.println("메뉴선택");
//        }
//        if(yn == 'y' ) {
//            num = 1 ;
//        }

        String menu = ""; // 메뉴
        int menuNum = 0; // 메뉴 개수
        int cnt = 0; // 개수
        String money = ""; //가격

//        System.out.println(
//                "1. 메뉴선택\n" +
//                        "2. 수량선택\n" +
//                        "3. 추가주문여부선택(y/n)\n");
//
//        System.out.println("어디로 가시겠습니까? ");
//        int choice = sc.nextInt();

        for (; ; ) {

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

                System.out.println("");
                System.out.print("메뉴선택 : ");
                int num = sc.nextInt();

                switch (num) {
                    case 1:
                        menu = "원조김밥";
                        money = "1500";
                    case 2:
                        menu = "치즈김밥";
                        money = "2000";
                    case 3:
                        menu = "참치김밥";
                        money = "2300";
                    case 4:
                        menu = "그냥라면";
                        money = "3000";
                    case 5:
                        menu = "치즈라면";
                        money = "3500";
                    case 6:
                        menu = "짬뽕라면";
                        money = "4000";
                    case 7:
                        menu = "떡볶이";
                        money = "2500";
                    case 8:
                        menu = "순대";
                        money = "2500";
                    case 9:
                        menu = "오뎅";
                        money = "1000";
                    case 10:
                        menu = "음료수";
                        money = "1000";
                }

                System.out.print("수량선택 : ");
                menuNum = sc.nextInt(); // 수량

                System.out.println("추가 주문 하시겠습니까(y/n)?");
                int yN = sc.next().charAt(0);

                if (yN == 'y') {
                    // 1 메뉴선택으로 돌아가기
                }

                if (yN == 'n') {
                    System.out.println("주문하신 정보는 다음과 같습니다.");
                    System.out.println("============================");
                    break;
                }
            }

        }

    }


