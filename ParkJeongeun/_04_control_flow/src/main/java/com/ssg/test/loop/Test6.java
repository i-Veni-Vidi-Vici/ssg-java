package com.ssg.test.loop;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menu = "김밥류===============\n"
                    + "1. 원조김밥====1500원\n"
                    + "2. 치즈김밥====2000원\n"
                    + "3. 참치김밥====2300원\n"
                    + "라면류===============\n"
                    + "4. 그냥라면====3000원\n"
                    + "5. 치즈라면====3500원\n"
                    + "6. 짬뽕라면====4000원\n"
                    + "분식류===============\n"
                    + "7. 떡볶이======2500원\n"
                    + "8. 순대=======2500원\n"
                    + "9. 오뎅=======1000원\n"
                    + "기타================\n"
                    + "10. 음료수=====1000원\n";

        System.out.println(menu);

        String name = "";
        int price = 0;
        int sum = 0;
        char add;

        String result = "주문하신 정보는 다음과 같습니다.\n"
                      + "==========================\n";

        do {
            System.out.print("> 메뉴 선택 (1 ~ 10) : ");
            int choiceMenu = sc.nextInt();
            System.out.print("> 수량 선택 : ");
            int cnt = sc.nextInt();

            switch (choiceMenu) {
                case 1:
                    name = "원조김밥";
                    price = 1500 * cnt;
                    sum += price;
                    result += "원조김밥 : " + cnt + "개 - " + price + "원\n";
                    break;

                case 2:
                    name = "치즈김밥";
                    price = 2000 * cnt;
                    sum += price;
                    result += "치즈김밥 : " + cnt + "개 - " + price + "원\n";
                    break;

                case 3:
                    name = "참치김밥";
                    price = 2300 * cnt;
                    sum += price;
                    result += "참치김밥 : " + cnt + "개 - " + price + "원\n";
                    break;

                case 4:
                    name = "그냥라면";
                    price = 3000 * cnt;
                    sum += price;
                    result += "그냥라면 : " + cnt + "개 - " + price + "원\n";
                    break;

                case 5:
                    name = "치즈라면";
                    price = 3500 * cnt;
                    sum += price;
                    result += "치즈라면 : " + cnt + "개 - " + price + "원\n";
                    break;

                case 6:
                    name = "짬뽕라면";
                    price = 4000 * cnt;
                    sum += price;
                    result += "짬뽕라면 : " + cnt + "개 - " + price + "원\n";
                    break;

                case 7:
                    name = "떡볶이";
                    price = 2500 * cnt;
                    sum += price;
                    result += "떡볶이 : " + cnt + "개 - " + price + "원\n";
                    break;

                case 8:
                    name = "순대";
                    price = 2500 * cnt;
                    sum += price;
                    result += "순대 : " + cnt + "개 - " + price + "원\n";
                    break;

                case 9:
                    name = "오뎅";
                    price = 1000 * cnt;
                    sum += price;
                    result += "오뎅 : " + cnt + "개 - " + price + "원\n";
                    break;

                case 10:
                    name = "음료수";
                    price = 1000 * cnt;
                    sum += price;
                    result += "음료수 : " + cnt + "개 - " + price + "원\n";
                    break;
            }
            System.out.print("> 추가주문여부 (y/n) : ");
            add = sc.next().charAt(0);

        } while (add == 'y');

        result += "--------------------------\n"
                + "합계 : " + sum + "\n"
                + "==========================\n"
                + "감사합니다. 😀";

        System.out.println(result);
    }
}
