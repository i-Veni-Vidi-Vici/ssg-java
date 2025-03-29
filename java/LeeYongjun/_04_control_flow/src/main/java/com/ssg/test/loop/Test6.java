package com.ssg.test.loop;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char yn;
        int menu = 0;
        int num = 0;
        int sum = 0;
        int price = 0;
        String order = "";
        System.out.println(
                        "김밥류 ===================\n" +
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
            switch (menu) {
                case 1:
                    price = 1500;
                    sum += price * num;
                    order += "원조김밥: " + num + "개 - " + price + "원";
                    break;
                case 2:
                    price = 2000;
                    sum += price * num;
                    order += "치즈김밥: " + num + "개 - " + sum + "원";

                    break;
                case 3:
                    price = 2300;
                    sum += price * num;
                    order += "참치김밥: " + num + "개 - " + sum + "원";

                    break;
                case 4:
                    price = 3000;
                    sum += price * num;
                    order += "그냥라면: " + num + "개 - " + sum + "원";

                    break;
                case 5:
                    price = 3500;
                    sum += price * num;
                    order += "치즈라면: " + num + "개 - " + sum + "원";

                    break;
                case 6:
                    price = 4000;
                    sum += price * num;
                    order += "짬뽕라면: " + num + "개 - " + sum + "원";

                    break;
                case 7:
                    price = 2500;
                    sum += price * num;
                    order += "떡뽂이: " + num + "개 - " + sum + "원";

                    break;
                case 8:
                    price = 2500;
                    sum += price * num;
                    order += "순대: " + num + "개 - " + sum + "원";

                    break;
                case 9:
                    price = 1500;
                    sum += price * num;
                    order += "오뎅: " + num + "개 - " + sum + "원";

                    break;
                case 10:
                    price = 1000;
                    sum += price * num;
                    order += "음료수: " + num + "개 - " + sum + "원";

                    break;
            }
            System.out.println("추가 주문 y/n : ");
            yn = sc.next().charAt(0);
        } while (yn == 'y');
        System.out.println("==============================");
        System.out.println("주문하신 정보는 다음과 같습니다.");
        System.out.println(order);
        System.out.println("------------------------------");
        System.out.println("합계 : " + sum + "원");
        System.out.println("==============================");
        System.out.println("감사합니다.");
    }
}
