package com.sh.loop._for;

import java.util.Scanner;

/**
 * for문 표현식
 *
 * for(초기식; 조건식; 증감식){
 *     //반복실행구문
 * }
 * - 초기식: 증감변수 선언
 * - 조건식: 반복문 실행여부
 * - 증감식: 증감변수 증가/감소처리
 * - 증감변수: 반복횟수,
 *
 * 실행순서
 * 1. 초기식
 * 2. 조건식: true인 경우
 * 3. 블럭진입: -반복실행구문
 * 4. 증감식 -> 2번 조건식으로 이동
 */
public class For {
    public void test1(){
        for(int i =1; i<=10; i++){
            System.out.println(i);
            //증감식이 없는 경우 조건식이 항상 true이고 무한히 반복문 수행

            //조건식이 없는 경우 true가 작성된 것과 동일하고 무한히 반복문 수행

            //초기식, 조건식, 증감식이 모두 없는 경우도 위와 동일
        }
    }

    /**
     *
     * - 반복획수 n번
     * - 증감변수 범위 start~end
     *
     */

    public void test2(){
        /*
        for(int i=0; i<10; i++){
            System.out.println(i);
        }
        */
        for(int i =11; i<=20; i++){
            System.out.println(i);
        }
        // 1~20사이의 홀수 출력
        for(int i = 0; i<=9; i++){
            System.out.println(2*i+1);
        }
        for(int i=10; i>0; i--){
            System.out.println(i);
        }
        for(int i =20;i>0;i-=2){
            System.out.println(i);
        }
    }

    /**
     * - 언제 반복문을 적용해야 하는가
     * - 몇번 반복해야 하는가
     * - 매턴마다 달라지는 부분은 어떻게 처리할 것인가
     */
    public void test3(){
        //5명의 학생이름을 입력받아 출력
        Scanner scanner = new Scanner(System.in);
        String name;
        for(int i=0; i<5;i++){
            System.out.println((i+1)+"번 학생 이름 입력: ");
            name = scanner.nextLine();
            System.out.println((i+1)+"번째 학생 이름: "+name);
        }


    }
    public void test4(){
        //누적합 초기화는 0으로
        //누적곱 초기화는 1로
        int sum =0;
        for(int i = 1; i<=10; i++){
            sum+=i;
        }
        System.out.println(sum);

    }

    public void test5(){
        int rnd = (int)(Math.random()*5) + 6;
        int sum  = 0;
        //증감변수의 범위를 난수에 따라 결정
        for(int i=1; i<=rnd; i++){
            sum+=i;
        }
        System.out.println("rnd = " + rnd);
        System.out.println("sum = " + sum);
    }

    public void test6(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("출력할 구구단 숫자를 입력하세요. : ");
        int num = scanner.nextInt();
        for(int i =1; i<=9; i++){
            //System.out.println(num + " * " + i + " = " + num*i);
            System.out.printf("%d * %d = %d\n", num, i, num*i);
        }

    }
}
