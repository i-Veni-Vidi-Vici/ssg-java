package com.sh.loop._while;


import java.util.Scanner;

/**
 * do~while
 * - 조건식->반복실행 순서와 달리 일단 1회 실행 후 조건을 검사
 * - 조건 참거짓 여부와 관계없이 최소 1회 실행되어야 하는데 사용
 * 초기식;
 * do{
 *     //반복실행문
 * } while(조건식)
 */
public class DoWhile {
    public void test1(){
        Scanner scanner = new Scanner(System.in);
        char yn;
        do{
            System.out.println("게임실행");
            System.out.println("다시 하시겠습니까? Y/N");
            yn = scanner.next().charAt(0);
        } while(yn=='Y');
        System.out.println("게임종료");
    }

    public void test2(){
        Scanner scanner = new Scanner(System.in);
        String str;
        do{
            System.out.println("문자열을 입력하세요. (중지하려면 exit 입력)");
            str = scanner.nextLine();
            System.out.println("> "+str);
            //기본형이 아닌 문자열은 ==가 아닌 equals 메소드로 내용비교
        }while(!str.equals("exit"));

    }
}
