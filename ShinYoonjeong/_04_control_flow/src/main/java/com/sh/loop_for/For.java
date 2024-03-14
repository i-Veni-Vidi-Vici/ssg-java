package com.sh.loop_for;

import java.util.Scanner;

/**
 * for문 표현식
 *
 * for(초기식;조건식;증감식){
 *     // 반복실행구문
 * }
 *
 * - 초기식 : 증감변수 선언
 * - 조건식 : 반복문 실행여부
 * - 증감식 : 증감변수 증가/감소처리
 * - 증감변수 : 반복횟수, 반복시 ㅂㄴ하는 값 등을 위해 선언한 변수
 *
 * 실행 순서
 * 1. 초기식
 * 2. 조건식 : true인 경우 | false인 경우 반복문 탈출
 * 3. 블럭진입 - 반복실행구문
 * 4. 증감식 -> 2번 조건식
 */
public class For {
    public void test1(){
        // 1~10까지 출력
        for(int i = 1; i <= 10 ; i++)
        {
            System.out.println(i);
        }
    }
    public void test2(){
        for(int i = 11;i <= 20;i++)
        {
            System.out.println(i);
        }
        for(int i = 1; i < 20;i+=2)
        {
            System.out.println(i);
        }
        for(int i=10;i>0;i--)
        {
            System.out.println(i);
        }
        for(int i=20;i>=2;i-=2)
        {
            System.out.println(i);
        }
    }

    /**
     * - 언제 반복문을 적용해야 하는가
     * - 몇번 반복해야 하는가
     * - 매턴마다 달라지는 부분은 어떻게 처리할 것인가
     */
    public void test3(){
        // 10명의 학생이름 입력받아 출력
        Scanner sc = new Scanner(System.in);
        String name;
        for(int i=1;i<=10;i++)
        {
            System.out.println(i + " 번 학생 이름 입력");
            name = sc.nextLine();
            System.out.println(i + " 번 학생 이름은 " + name);
        }
    }

    /**
     * 1 ~ 10까지 합 구하기
     */
    public void test4(){
        int sum = 0;
        for(int i=1;i<=10;i++){
            sum+=i;
        }
        System.out.println(sum);
    }
    public void test5(){
        // 난수가 6일때, 1 ~ 6까지의 합
        // 난수가 7일때, 1 ~ 7까지의 합
        // 8
        // 9
        // 10
        int n = (int)(Math.random() * 5) + 6;
        int sum = 0;
        for(int i=1;i <= n;i++)
        {
            sum += i;
        }
        System.out.println(sum);
    }
    public void test6(){
        Scanner sc = new Scanner(System.in);
        System.out.println("단수 입력 : ");
        int num = sc.nextInt();
        for(int i=1;i<=9;i++)
        {
            System.out.println(num + "*" + i + "=" + num*i);
        }
    }
}
