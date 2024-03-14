package com.sh.condition._if;

import java.util.Scanner;

/**
 * if-else 표현식
 * if(조건식){
 *     //조건식이 true 인 경우 실행코드
 *
 * }
 * else{
 *     //조건식이 false인 경우 실행코드
 * }
 *실행블럭의 코드가 단한줄인 경우만 {} 블럭을 생략할 수 있다.
 */
public class Ifelse {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수입력해주세요 : ");
        int num = sc.nextInt();
        if(num%2==0){
            System.out.println("짝수입니다");
        }
        else{
            System.out.println("홀수입니다.");

        }
        System.out.println("끝났습니다.");
    }
    public void test2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("성별을 입력하세요 : ");
        char gender = sc.nextLine().charAt(0);
        if(gender=='M'){
            System.out.println("남자입니다.");

        }
        else{
            System.out.println("여자입니다.");

        }

    }
    public void test3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요 : ");
        int num = sc.nextInt();
        if(num>=0){
            if(num==0){
            System.out.println("0");
            }
            else {
                System.out.println("양수");
            }

        }
        else{
            System.out.println("음수");
        }
    }
}
