package com.ssg.test.loop;

import java.util.Scanner;

/**
 * - 분식집 주문 받는 프로그램을 만들어 보세요.
 1. 메뉴선택
 2. 수량선택
 3. 추가주문여부선택
 4. `y`면 1번부터 다시 시작. 단 데이터는 누적.
 5. `n`면 주문결과서 출력
 *
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] menu = new int[10];
        int select = 0;
        int many = 0;
        char ch = ' ';
        int [] price = {1000, 2000, 3000, 3000, 3500, 4000, 2500, 2500, 1000, 1000};
        String [] str = {"원조김밥", "치즈김밥", "참치김밥", "그냥라면", "치즈라면", "치즈라면", "짬뽕라면", "떡볶이", "순대", "어묵", "음료수"};
        int sum = 0;


        System.out.println(
                "김밥류============================\n"+
                "1.원조김밥======================1500원\n"+
                "2.치즈김밥======================2000원\n"+
                "3.참치김밥======================3000원\n"+
                        "라면류============================\n"+
                "4.그냥라면======================3000원\n"+
                "5.치즈라면======================3500원\n"+
                "6.짬뽕라면======================4000원\n"+
                "분식류============================\n"+
                "7.떡볶이======================2500원\n"+
                "8.순대======================2500원\n"+
                "9.어묵======================1000원\n"+
                "분식류============================\n"+
                        "10.음료수====================1000원\n"
        );

        do {
            System.out.print("1. 메뉴를 선택하세요 : ");
            select = sc.nextInt();
            System.out.print("2. 수량 선택하세요 : ");
            many = sc.nextInt();
            menu[select-1] += many;
            System.out.print("3. 추가 주문 하시겠습니까? : ");
            ch = sc.next().charAt(0);
        }while((ch == 'y') || (ch == 'Y'));

        System.out.println("주문하신 정보는 다음과 같습니다");
        System.out.println("============================");
        for(int i =0; i<10; i++){
            if(menu[i]!=0){
                sum += menu[i]*price[i];
                System.out.println(str[i]+": " + menu[i]+"개 - "+sum);

            }
        }
        System.out.println("합계 : "+sum+"원");
        System.out.println("=======================");
        System.out.println("감사합니다");


    }
}
