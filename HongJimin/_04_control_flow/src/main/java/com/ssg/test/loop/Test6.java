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


        // 주문을 1번은 무조건 함!, 그 이후에는 y, n 선택해서 추가 주문 여부를 선택함
        // 메뉴 선택은 번호로, 만약 2번째 주문부터 똑같은 메뉴를 선택할 경우, 개수 누적 증가
        // 메뉴 별로 주문 개수 누적하는 변수 필요

        Scanner sc = new Scanner(System.in);



        do {
            System.out.println("메뉴 선택 : ");
            int menu = sc.nextInt();

            switch (menu) {
                for (int i = 0; i <= 10; i++) {
                    i
                }
            }

            System.out.println("수량 선택 : ");
            int oderNum = sc.nextInt();
        }
        while ("추가주문 선택 여부 변수가 들어올 예정".equals("Y") ) ;
        System.out.println("주문하신 정보는 다음과 같습니다.\n" +
                "==============================");

    }
}
