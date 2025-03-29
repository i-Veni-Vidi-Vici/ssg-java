package com.sh.loop._for;

import javax.management.relation.RelationNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * <pre>
 * for문 표현식
 *
 * for(초기식; 조건식; 증감식)
 * {
 *     //반복문 실행구문
 * }
 *
 * - 초기식 : 증감변수 선언
 * - 조건식 : 반복문 실행여부
 * - 증감식 : 증감변수 증가/감소처리
 * - 증감변수 : 반복횟수, 반복시 변하는 값 등을 위해 선언한 변수
 *
 * 실행순서
 * 1. 초기식
 * 2. 조건식 : true인 경우, false인 경우 반목문 탈출
 * 3. 블럭진입 : 반복실행구문
 * 4. 증감식 -> 2번으로 돌아감
 * </pre>
 *
 */
public class For {
    public void test1(){
        //1~10까지 출력
        int i;
//        for(i=0;i<10;i++)
//        {
//            System.out.println(i+1);
//        }

        // 증감식이 없다면
        // i = 1인채로 무한반복
//        for(i=0;i<10;)
//        {
//            System.out.println(i+1);
//        }

        //조건식이 없다면
        // defalut값 = true이기 때문에 계속 증가하는 상태가 된다
        // i가 끝없이 증가하며 무한반복
//        for(i=0;;i++)
//        {
//            System.out.println(i+1);
//        }

        //초기식, 조건식, 증감식 없는 경우
        // 무한루프가 된다
//        for(;;)
//        {
//            System.out.println(1);
//        }
//        System.out.println("현재 i = "+i);
    }


    /**
     * 반복횟수 n번
     * 증감변수 범위 start ~ end
     */
    public void test2() {
        int i;
        //0~9까지 출력
//        for(i=0;i<10;i++)
//        {
//            System.out.println("i = "+i);
//        }

        //11~20까지 출력
//        for(i=11;i<21;i++)
//        {
//            System.out.println("i = "+i);
//        }

        //1~19까지 홀수만 출력
//        for(i=1;i<20;i=i+2) {
//            System.out.println(i);
//        }

//        //10~1까지 출력
//        for(i=10;i>0;i--) {
//            System.out.println(i);
//        }

        //20~2까지 짝수만
//        for(i=20;i>1;i-=2)
//        {
//            System.out.println(i);
//        }

    }

    /**
     * - 언제 반복문을 적용해야 하는가
     * - 몇번 반복해야 하는가
     * - 매턴마다 달라지는 부분은 어떻게 처리할 것인가
     */
    public void test3() {
        int i;
        Scanner sc=new Scanner(System.in);
        String name;
        //10명의 학생이름을 입력받아 출력

        for(i=0;i<5;i++)
        {
            System.out.print(i+1+"번 학생 이름 : ");
            name=sc.next();
            System.out.println("저장된 학생 이름 : "+name);
        }
        System.out.println("i값 = "+i);

    }

    /**
     * 1~10까지 합 구하기
     */
    public void test4() {
        int i;
        int sum=0;

        for(i=0;i<11;i++)
        {
            sum+=i;
        }
        System.out.println(sum);

        //블럭안에 있는 변수는 외부에서 접근이 안된다
    }

    /**
     * 1~난수까지 합 구하기
     */
    public void test5() {
        int i;
        int sum=0;

        Scanner sc=new Scanner(System.in);

        System.out.print("숫자 입력 하세요 : ");
        int num=sc.nextInt();

        int n=(int)(Math.random()*num)+7;//*n가지, m부터 시작

        System.out.println("n 값 = "+n);

        for(i=1;i<n+1;i++)
        {
            sum=sum+i;
            System.out.println("i값 = "+i);
            System.out.println("sum값 = "+sum);
        }
    }

    /**
     * 입력받은 수의 구구단 출력
     */
    public void test6() {
        int i;
        int n;
        System.out.print(" 몇단을 출력 할까요?? : ");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();

        for(i=1;i<=9;i++)
        {
            //System.out.println(n+" * "+i+ " = "+n*i);
            System.out.printf("%d * %d = %d \n",n,i,n*i);
        }
    }
}
