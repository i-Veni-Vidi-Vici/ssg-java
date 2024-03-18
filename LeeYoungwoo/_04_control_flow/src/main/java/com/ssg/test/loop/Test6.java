package com.ssg.test.loop;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menu = ("김밥류 ===================\n" +
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

        System.out.println(menu);
        // 사용자로부터 입력값 받기
        System.out.println("> 메뉴선택 : ");
        int choice = sc.nextInt();
        System.out.println("> 수량선택 : ");
        int num = sc.nextInt();
        System.out.println("> 추가주문여부선택 (y/n) : ");
        String yn = sc.nextLine();

        String name= "";
        int price = 0;


        switch (choice) {
            case 1 :
                name = "원조김밥";
                price = 1500;
                break;

            case 2 :
                name = "치즈김밥";
                price = 2000;
                break;

            case 3 :
                name = "참치김밥";
                price = 2300;
                break;

        }



    }
}
