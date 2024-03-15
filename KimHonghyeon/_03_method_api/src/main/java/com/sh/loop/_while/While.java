package com.sh.loop._while;


import java.util.Scanner;

/**
 *
 * while 표현식
 *
 * 초기식;
 * while(조건식){
 *     //반복실행구문
 *
 *     증감식
 * }
 */
public class While {
    public void test1() {
        //int i=10;
        //while(i>=1){
        //    System.out.println("i = " + i--);
        //}

        int i=2;
        while(i<=20){
            System.out.println("i = " + i);
            i +=2;
        }
    }

    public void test2(){
        int sum =0;
        int i =1;
        while(i<=10){
            sum += i;
            i++;
        }
    }

    /**
     * 문자열에 인덱스별로 접근하기
     */
    public void test3(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("아무 문장이나 입력하세요.");
        String str = scanner.nextLine();
        int i =0;
        //인덱스 시작은 0, 끝은 글자수-1 과 동일
        while(i<str.length()){
            char ch = str.charAt(i);
            System.out.println(ch);
            i++;
        }
    }

    public void test4(){
        int dan =2;
        int num =1;
        while(dan<=9){
            System.out.println("----" + dan+"단----");
            while(num<=9){
                System.out.printf("%d * %d = %d\n", dan, num, dan*num);
                num++;
            }
            System.out.println();
            num = 1;
            dan++;
        }
    }

}
