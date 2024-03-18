package com.ssg.test.loop;

import java.util.Scanner;

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
                "10.음료수===========1000원");


        Scanner sc = new Scanner(System.in);
        int[] orderNum = new int [10];
        String[] menuName = new String[10];

        do {
            System.out.println("메뉴 선택 : ");
            int menu = sc.nextInt();

            // orderNum은 선택했을 때의 개수 증가

            System.out.println("수량 선택 : ");
            int productNum = sc.nextInt();

            if (menu == 1){
                orderNum[0] += productNum;
                menuName[0] = "원조 김밥";
            }
            else if (menu == 2) {
                orderNum[0] += productNum;
                menuName[0] = "치즈 김밥";
            }
            else if (menu == 3) {
                orderNum[0] += productNum;
                menuName[0] = "참치 김밥";
            }
            else if (menu == 4) {
                orderNum[0] += productNum;
                menuName[0] = "그냥 라면";
            }
            else if (menu == 5) {
                orderNum[0] += productNum;
                menuName[0] = "치즈 라면";
            }
            else if (menu == 6) {
                orderNum[0] += productNum;
                menuName[0] = "짬뽕 라면";
            }
            else if (menu == 7) {
                orderNum[0] += productNum;
                menuName[0] = "떡볶이";
            }
            else if (menu == 8) {
                orderNum[0] += productNum;
                menuName[0] = "순대";
            }
            else if (menu == 9) {
                orderNum[0] += productNum;
                menuName[0] = "오뎅";
            }
            else if (menu == 10) {
                orderNum[0] += productNum;
                menuName[0] = "음료수";
            }


        }
        System.out.println("추가 주문 하시나요? (y / n) : ");
        char addOrder = sc.next().charAt(0);
        while (
                addOrder == 'y');
        System.out.println("주문하신 정보는 다음과 같습니다.\n" +
                "==============================");


        System.out.println();

    }
}
