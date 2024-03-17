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

        Scanner sc = new Scanner(System.in);



        int totalCost = 0; // 총 비용
        String order = " "; // 주문목록

        do {

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
                int option = sc.nextInt();

                String product = ""; // 메뉴


                System.out.print("수량선택 : ");
                int quantity = sc.nextInt(); // 수량
                int price = 0; //메뉴가격


                switch (option) {
                    case 1:
                        price = 1500 * quantity;
                        totalCost += price;
                        order += "원조김밥: " + quantity + "개" + price + "원";
                        break;
                    case 2:
                        price = 2000 * quantity;
                        totalCost += price;
                        order += "치즈김밥: " + quantity + "개" + price + "원";
                        break;

                    case 3:
                        price = 2300 * quantity;
                        totalCost += price;
                        order += "참치김밥: " + quantity + "개" + price + "원";
                        break;
                    case 4:
                        price = 3000 * quantity;
                        totalCost += price;
                        order += "그냥김밥: " + quantity + "개" + price + "원";
                        break;
                    case 5:
                        price = 3500 * quantity;
                        totalCost += price;
                        order += "치즈라면: " + quantity + "개" + price + "원";
                        break;

                    case 6:
                        price = 4000 * quantity;
                        totalCost += price;
                        order += "짬뽕라면: " + quantity + "개" + price + "원";
                        break;
                    case 7:
                        price = 2500 * quantity;
                        totalCost += price;
                        order += "떡볶이: " + quantity + "개" + price + "원";
                        break;
                    case 8:
                        price = 2500 * quantity;
                        totalCost += price;
                        order += "순대: " + quantity + "개" + price + "원";
                        break;
                    case 9:
                        price = 1000 * quantity;
                        totalCost += price;
                        order += "오뎅: " + quantity + "개" + price + "원";
                        break;
                    case 10:
                        price = 1000 * quantity;
                        totalCost += price;
                        order += "음료수: " + quantity + "개" + price + "원";

                }

                System.out.println("추가 주문 하시겠습니까(y/n)?");
                char yN = sc.next().charAt(0);
                if (yN == 'y') {
                    order += "\n";
                    continue;
                }

                if (yN == 'n') {
                    break; // 반복문 탈출
                }
            }while (true);

        System.out.println("주문하신 정보는 다음과 같습니다.");
        System.out.println("====================================");
        System.out.println(order);
        System.out.println("====================================");
        System.out.println("합계 : " + totalCost + "원");

        }

    }


