package com.sh.condition._if;

import java.util.Scanner;

/**
 * if (조건식) {
 * 	//조건식이 true인 경우 실행코드
 * }
 * else {
 * 	// 조건식이 false인 경우 실행 코드
 * }
 *
 * 실행 블럭의 코드가 단 한줄인 경우에는 {} 블럭을 생략할 수 있다.
 */
public class IfElse {
    public void test() {
        Scanner sc = new Scanner(System.in);

        //사용자 입력 정수 홀수  / 짝수 구분
        System.out.println("> 정수 입력 : ");
        int num = sc.nextInt();

        if (num %2 == 1) {
            //조건식이 false : 홀수일 때 실행 코드
            System.out.println("홀수 🎀");
        }
        else {
            //조건식이 true : 짝수일 때 실행 코드
            System.out.println("짝수🎨");
        }
        System.out.println("프로그램 종료!");
    }

    //사용자 성별을 입력받고, 남자인 경우, 장난감을 여자인 경우 장미꽃을 출력하세요
    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("사용자의 성별을 입력하세요(M / F) : ");
        char gender = sc.next().charAt(0);
        if (gender == 'M') {
            //남자인 경우
            System.out.println("🎃🎲🧩♠");
        }
        else {
            //여자인 경우
            System.out.println("🌹🌷🌹🌷🌹🌷");
        }
    }

    /**
     * 사용자 입력 정수에 따라 양수/0/음수를 출력하세요!
     * - 중첩 if 사용 가능
     */

    public void test3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요 : ");
        int num = sc.nextInt();
//        if (num == 0) {
//            System.out.println("0");
//        } else if (num > 0) {
//            System.out.println("양수");
//        } else{
//            System.out.println("음수");
//        }

        if(num != 0 ){
            //0이 아닌 경우
            if (num > 0) {
                //양수인 경우
                System.out.println("양수입니다");
            }
            else {
                //음수인 경우
                System.out.println("음수입니다.");
            }
        }
        else {
            //0인 경우
            System.out.println("000000000");
        }
    }
}
