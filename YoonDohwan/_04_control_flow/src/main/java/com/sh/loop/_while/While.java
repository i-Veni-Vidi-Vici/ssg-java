package com.sh.loop._while;

import java.util.Scanner;

/**
 * while 표현식
 * 초기식
 * while(조건식)
 * {
 *     //반복실행구문
 *     증감식;
 * }
 */
public class While {
    public void test(){
        //1~10 출력
        int i=2;
        while(i<=20){
            System.out.println(i);
            i+=2;
        }
    }
    public void test2(){
        int sum=0;
        int i=1;
        while(i<=10){
            sum+=i++;
        }
        System.out.println(sum);
    }
    /**
     * 문자열에 인덱스별로 접근하기
     * "apple"
     */
    public void test3(){
        //마지막 인덱스는 글자수 -1과 동일하다.
        Scanner sc = new Scanner(System.in);
        System.out.println("아무말이나 하세요 : ");
        String str = sc.nextLine();
        int i = 0; // str.length() = 문자열의 길이 반환
        while(i<str.length()){
            char ch = str.charAt(i);
            System.out.println(i + " : "+ch);
            i++;
        }

    }
    public void test4(){
        int i=2;
        while(i<10) {
            int j=1;
            System.out.println(i + "단");
            while (j < 10) {
                System.out.printf("%d*%d=%d\n", i, j, i * j);
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
