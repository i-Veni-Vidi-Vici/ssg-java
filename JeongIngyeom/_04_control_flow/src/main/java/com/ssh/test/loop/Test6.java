package com.ssh.test.loop;

import java.util.Arrays;
import java.util.Scanner;

public class Test6 {

    public static void main(String[] args) {
        String[] menu = {"원조김밥", "치즈김밥", "참치김밥", "그냥라면", "치즈라면", "짬뽕라면", "떡볶이", "순대", "오뎅", "음료수"};
        int[] price = {1500, 2000, 2300, 3000, 3500, 4000, 2500, 2500, 1000, 1000};
        int[] orderQuantity = new int[10];
        Arrays.fill(orderQuantity, 0);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-메뉴판-\n김밥류 ===================\n" +
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

            System.out.print("메뉴 번호 선택 : ");
            int menuNum = sc.nextInt();

            if (menuNum > 10 || menuNum < 1) {
                System.out.println("1 ~ 10번까지만 입력 가능합니다. 다시 주문해주세요.\n");
                continue;
            }

            System.out.print("주문 수량 입력 : ");
            int quantity = sc.nextInt();

            orderQuantity[menuNum - 1] += quantity;

            while (true) {
                System.out.print("추가 주문 여부 선택(y / n) : ");
                char continueOrderYN = sc.next().charAt(0);

                if (continueOrderYN == 'y') {
                    System.out.println();
                    break;
                } else if (continueOrderYN == 'n') {
                    System.out.println("\n주문하신 정보는 다음과 같습니다.\n==============================");

                    int sum = 0;
                    for (int i = 0; i < 10; i++) {
                        if (orderQuantity[i] > 0) {
                            System.out.printf("%s: %d개 - %d원\n",
                                    menu[i], orderQuantity[i], price[i] * orderQuantity[i]);

                            sum += price[i] * orderQuantity[i];
                        }
                    }

                    System.out.println("------------------------------\n" +
                            "합계 : " + sum  + "원\n" +
                            "==============================\n감사합니다 😀");
                    return;
                } else {
                    System.out.println("y 또는 n만 입력해주세요.\n");
                }
            }
        }
    }
}
