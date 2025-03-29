package com.ssg.test.loop;

import java.util.Scanner;

public class Test6 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        char yn;
        int menu = 0;
        int num = 0;
        int sum = 0;
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
        do {
            System.out.println("주문해 주세요.");
            menu = sc.nextInt();
            System.out.println("수량을 선택해 주세요.");
            num = sc.nextInt();
            switch (menu)
            {
                case 1:
                    sum += 1500 * num;
                    break;
                case 2:
                    sum += 2000 * num;
                    break;
                case 3:
                    sum += 2300 * num;
                    break;
                case 4:
                    sum += 3000 * num;
                    break;
                case 5:
                    sum += 3500 * num;
                    break;
                case 6:
                    sum += 4000 * num;
                    break;
                case 7:
                    sum += 2500 * num;
                    break;
                case 8:
                    sum += 2500 * num;
                    break;
                case 9:
                    sum += 1000 * num;
                    break;
                case 10:
                    sum += 1000 * num;
                    break;
            }
            System.out.println("추가 주문 하시겠습니까? y/n : ");
            yn = sc.next().charAt(0);
        } while(yn == 'y');
        System.out.println("주문하신 정보는 다음과 같습니다.");
        System.out.println("합계 : " + sum+ "원");
        System.out.println("감사합니다.");
    }
}
