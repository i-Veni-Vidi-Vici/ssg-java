package com.ssg.test.loop;

import java.util.Scanner;

/**
 * - 분식집 주문 받는 프로그램을 만들어 보세요.
 *     1. 메뉴선택
 *     2. 수량선택
 *     3. 추가주문여부선택
 *     4. `y`면 1번부터 다시 시작. 단 데이터는 누적.
 *     5. `n`면 주문결과서 출력
 */

public class Test6 {
    public static void main(String[] args) {
        Test6 t = new Test6();
        t.test();
    }

    public void test(){
        Scanner sc = new Scanner(System.in);
        String menu = "김밥류 ===================\n"
                + "1.원조김밥===========1500원\n"
                + "2.치즈김밥===========2000원\n"
                + "3.참치김밥===========2300원\n"
                + "라면류 ===================\n"
                + "4.그냥라면===========3000원\n"
                + "5.치즈라면===========3500원\n"
                + "6.짬뽕라면===========4000원\n"
                + "분식류 ===================\n"
                + "7.떡볶이=============2500원\n"
                + "8.순대==============2500원\n"
                + "9.오뎅==============1000원\n"
                + "기타 ====================\n"
                + "10.음료수===========1000원\n";

        int sum=0;
        String order = "";
        char moreYN = ' ';

        do{
            System.out.println(menu);

            // 1. 메뉴 선택
            System.out.print("메뉴 선택(숫자로) -> ");
            int menuNum = sc.nextInt();
            //2. 수량 선택
            System.out.print("수량 선택 -> ");

            int count = sc.nextInt();
            int price=0;

            switch(menuNum) {
                case 1:
                    price = 1500 * count;
                    sum += price;
                    // count,price는 int형이지만 string인 order는 str원조김밥으로 +가 시작하므로 str로 자동형변환 된다.
                    order += "원조김밥: " + count + "개 -" + price + "원";
                    break;
                case 2:
                    price = 2000 * count;
                    sum += price;
                    order += "치즈김밥: " + count + "개 - " + price + "원";
                    break;
                case 3:
                    price = 2300 * count;
                    sum += price;
                    order += "참치김밥: " + count + "개 - " + price + "원";
                    break;
                case 4:
                    price = 3000 * count;
                    sum += price;
                    order += "그냥라면: " + count + "개 - " + price + "원";
                    break;
                case 5:
                    price = 3500 * count;
                    sum += price;
                    order += "치즈라면: " + count + "개 - " + price + "원";
                    break;
                case 6:
                    price = 4000 * count;
                    sum += price;
                    order += "짬뽕라면: " + count + "개 - " + price + "원";
                    break;
                case 7:
                    price = 2500 * count;
                    sum += price;
                    order += "떡볶이: " + count + "개 - " + price + "원";
                    break;
                case 8:
                    price = 2500 * count;
                    sum += price;
                    order += "순대: " + count + "개 - " + price + "원";
                    break;
                case 9:
                    price = 100 * count;
                    sum += price;
                    order += "오뎅: " + count + "개 - " + price + "원";
                    break;
                case 10:
                    price = 1000 * count;
                    sum += price;
                    order += "음료수: " + count + "개 - " + price + "원";
                    break;
                default:
                    System.out.println("잘못 입력했습니다");
                    break;
            }

            //3. 추가주문여부 선택
            System.out.print("추가주문 하시겠습니까?(y/n)");
            moreYN = sc.next().charAt(0);

            if(moreYN == 'y')
                order += "\n";

        }while(moreYN == 'y');
        System.out.println("\n주문하신 정보는 다음과 같습니다.");
        System.out.println("==============================");
        System.out.println(order);
        System.out.println("------------------------------");
        System.out.println("합계 : " + sum + "원");
        System.out.println("==============================");
        System.out.println("감사합니다😊");
    }
}
