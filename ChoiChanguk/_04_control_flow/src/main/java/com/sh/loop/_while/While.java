package com.sh.loop._while;


import javax.swing.plaf.PanelUI;
import java.util.Scanner;

/**
 * while 표현식
 * 초기식;
 * while(조건식)
 * {
 *     //반복실행 구문
 *     증감식;
 * }
 */
public class While {
    public void test1() {
        //1~10까지 출력
//        int i=1;
//        while (i<=10)
//        {
//            System.out.println(i);
//            i++;
//        }

//        //10~1
//        int j=10;
//        while(j>0)
//        {
//            System.out.println(j);
//            j--;
//        }

        //2~20까지 짝수만
        int  k=1;
        while(k<=20)
        {
            if(k%2==0)
            {
                System.out.println(k);
            }
            k++;
        }
    }
    public void test2() {
        /**
         * 누적합 구하기
         */
        int sum=0;
        int i=1;
        while (i<11)
        {
            sum+=i++;
        }
        System.out.println(sum);
    }

    public void test3() {
        /**
         * 문자열에 인덱스별로 접근하기
         * 마지막 인덱스 글자수 -1과 동일하다
         */
//        String str = "apple";
//        int i=0;
//        while (i < 5) {
//            char ch=str.charAt(i);
//            //System.out.println(ch);
//            System.out.printf("%d : %c\n",i,ch);
//            i++;
//        }

        //입력받아서 출력하기
        Scanner sc= new Scanner(System.in);
        String str;
        str=sc.nextLine();
        char ch;
        int i=str.length();

        int start=0;

        while (start < i) {
            ch=str.charAt(start);
            System.out.println(ch);
            start++;
        }
    }
    public void test4() {
        /**
         * 2~9단 출력
         */
        int dan=2;
        while(dan<10)
        {
            int i=2;
            System.out.println(dan+"단입니다");
            while (i<10)
            {
                System.out.printf("%d * %d = %d\n",dan,i,dan*i);
                i++;
            }
            dan++;
        }
    }

}
