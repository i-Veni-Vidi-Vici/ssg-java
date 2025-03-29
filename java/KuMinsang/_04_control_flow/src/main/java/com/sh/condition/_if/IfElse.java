package com.sh.condition._if;
import java.util.Scanner;

/**
 * if-else 표현식
 * if(조건식){
 *     //조건식 true인 경우 실행코드
 * }else{
 *    //조건식이 false인 경우 실행코드
 * }
 */
public class IfElse {
    public void test() {
        Scanner sc = new Scanner(System.in);
        //사용자 입력 정수 홀수/짝수 구분
        System.out.println("> 정수 입력 : ");
        int num = sc.nextInt();
        if (num % 2 == 0) {
            //짝수
            System.out.println("짝수입니다");

        } else {
            //홀수
            System.out.println("홀수 입니다");
        }
    }

        /**
         * 사용자 성별(M/F) 입력 받고, 남자인 경우 장난감을, 여자인경우 장미꽃을 출력
         */
        public void test2(){
            Scanner sc = new Scanner(System.in);
            System.out.println("> 성별 입력 : ");
            char a = sc.nextLine().charAt(0);

            if(a == 'M'){
                System.out.println("장난감");
            }else{
                System.out.println("장미꽃");
            }

        }

        /**
         * 사용자 입력 정수에 따라 양수/0/음수를 출력하세요
         * -중첩 if 사용가능
         */
        public void test3(){
            Scanner sc = new Scanner(System.in);
            System.out.println("> 정수 입력 : ");
            int a = sc.nextInt();

            if (a != 0){
                if(a > 0){
                    //양수
                    System.out.println("양수");
                }else{
                    //음수
                    System.out.println("음수");
                }
            }else{
                //0
                System.out.println("0");
            }

        }
}
