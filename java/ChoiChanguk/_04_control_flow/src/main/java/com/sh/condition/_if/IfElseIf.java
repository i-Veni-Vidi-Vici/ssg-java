package com.sh.condition._if;

import java.util.Scanner;

/**
 * <pre>
 * 조건식1->조건식2->조건식3~~~조건식N 순차적으로 가다가 조건식이 만족하면 실행 후 종료
 *
 * if(조건식1)
 * {
 *     ~~~//조건식1이 true면 실행 -> 탈출
 * }
 * else if(조건식1)
 * {
 *     ~~~//조건식2가 true면 실행 -> 탈출
 * }
 * </pre>
 */
public class IfElseIf {
    Scanner sc=new Scanner(System.in);
    public void test()
    {
        //금도끼, 은도끼, 쇠도끼예제
        System.out.println(" 풍덩 펑!! ");
        System.out.print("산신령 : 어느것이 네 도끼냐?? 1. 금도끼, 2.은도끼, 3.쇠도끼 :");

        int num=sc.nextInt();

        if(num==1)
        {
            System.out.println("고얀놈!! 황금에 눈이 멀었구나!! ");
        }
        else if(num==2)
        {
            System.out.println("고얀놈!! 은이 그리도 좋았더냐!!");
        }
        else
        {
            System.out.println("정직하구나~ 셋 다 가져가라~");
        }

    }

    /**
     * 학점 부여
     * - 90~100 = A
     * - 80~89 = B
     * - 70~79 = C
     * - 60~69 = D
     * - 0~59 = F
     */
    public void test2()
    {
        System.out.print("점수입력 : ");
        int score = sc.nextInt();

        System.out.print(score+"점은");
        if(score>=90 && score<=100)
        {
            System.out.println(" A 학점입니다");
        }
        else if(score>=80 && score<90)
        {
            System.out.println(" B 학점입니다");
        }
        else if(score>=70 && score<80)
        {
            System.out.println(" C 학점입니다");
        }
        else if (score>=60 && score<70)
        {
            System.out.println(" D 학점입니다");
        }
        else
        {
            System.out.println(" F 학점입니다");
        }
    }

    /**
     * 학점 부여
     * - 95 ~ 100 = A+
     * - 90 ~ 94 = A
     * - 85 ~ 89 = B+
     * - 80 ~ 84 = B
     * - 75 ~ 79 = C+
     * - 70 ~ 74 = C
     * - 65 ~ 69 = D+
     * - 60 ~ 64 = D
     * - 0 ~ 59 = F
     */
    public void test3()
    {
        System.out.print("점수입력 : ");
        int score = sc.nextInt();

        String grade;

        if(score>=95 && score<=100)
        {
            grade="A+";
            if(score>=90)
            {
                grade="A";
            }
        }
        else if(score>=85)
        {
            grade="B+";
            if(score>=80) {
                grade = "B";
            }
        }
        else if(score>=75)
        {
            grade="C+";
            if(score>=70) {
                grade = "C";
            }
        }
        else if(score>=65)
        {
            grade="D+";
            if(score>=60) {
                grade = "D";
            }
        }
        else
        {
            grade="F";
        }
        System.out.println(score+"점수는 "+grade+"학점입니다");
    }
}
