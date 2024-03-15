package com.sh.loop._for;

import java.util.Scanner;

/**
 * <pre>
 *     for문 표현식
 *
 *     for(초기식; 조건식; 증감식){
 *         //반복실행구문
 *     }
 *
 *     - 초기식 : 증감변수 선언
 *     - 조건식 : 반복문 실행여부
 *     - 증감식 : 증감변수 증가/감소 처리
 *
 *     실행순서
 *     1. 초기식
 *     2. 조건식 : true인 경우 | false인 경우 반복문 탈출
 *     3. 블럭진입 - 반복실행구문
 *     4. 증감식 -> 2번 조건식 이동
 *
 * </pre>
 */
public class For {
    public void test6(){
        Scanner sc = new Scanner(System.in);
        int a = 0;
        for(int i = 1; i<=9; i++){
            a+=i;
        }
        System.out.printf("a = %d",a);

    }

}
