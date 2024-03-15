package com.sh.loop._for;
import java.util.Random;
import java.util.Scanner;
/**
 * for문 표현식
 * for(초기식;조건식;증감식){
 *     //반복실행구문
 * }
 * 초기식 : 증감변수 선언
 * 조건식 : 반복문 실행여부
 * 증감식 : 증감변수 증가/감소처리
 *
 * 실행순서
 * 1.초기식
 * 2.조건식 : true 인 경우
 * 3.블럭진입 - 반복실행구문
 * 4.증감식 -> 2번 조건식 이동
 *
 */
public class For {
    public void test1(){
        for(int i=1;i<=10;i++){
            System.out.println(i);
        }
        //초기식 조건식 증감식 모두없는경우,무한반복
        for(;;){
            System.out.println("helloworld");
        }
    }

    public void test2(){
        for(int i=0;i<=9;i++){
            System.out.println(i);
        }
    }
    public void test3(){

       Scanner sc = new Scanner(System.in);
       for(int std=1;std<=5;std++){
        System.out.println(std+"번 학생 입력 : ");
        String std1=sc.next();
        System.out.println(std+"번 학생명 : "+std1);
       }
    }

    public void test4() {
            int sum=0;
            for(int i=1;i<=10;i++){
            sum=sum+i;
        }
        System.out.println(sum);
    }
    public void test5(){
        Random rnd = new Random();
        int num = (int)(Math.random()*5)+6;
        int sum=0;
        System.out.println(num);
        for(int i=1;i<=num;i++){
            sum=sum+i;
        }
        System.out.println(sum);
    }
    public void test6(){
        Scanner sc=new Scanner(System.in);
        System.out.println("숫자 입력 : ");
        int n = sc.nextInt();
        int multi = 1;
        System.out.println(n+"단출력");
        for(int i=1;i<=9;i++){
            multi=n*i;
            //%d 정수 , %f 실수 %s 문자열
            //printf는 기본적으로 개행을 지원하지 않는다.
            System.out.printf("%d * %d = %d",n,i,  multi);
        }

    }
}
