package com.sh.condition._if;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * if 표현식
 * if (조건식){
 *     //조건식이 true 인 경우 실행코드
 * }
 */
public class If {
    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.print(">정수 입력하세요 : ");
        int num = sc.nextInt();
        if(num%2==0){
            System.out.println("짝수🐱‍👓🐱‍👓🐱‍👓🐱‍👓🐱‍👓🐱‍👓🐱‍👓🐱‍👓🐱‍👓🐱‍👓");
        }
        if(num<0){
            System.out.println("음수❤❤❤❤❤❤");
        }
        System.out.println("프로그램 종료!!!");
    }

    public void test2(){
        Scanner sc= new Scanner(System.in);
        System.out.println(">정수 입력");
        int num=sc.nextInt();
        if(num>0&&num%2==0){
            System.out.println("양짝😊😊😊😊");
        }
        System.out.println("프로그램 종료!!!");
    }


}
