package com.sh.loop._while;

import java.util.Objects;
import java.util.Scanner;

/**
 * <pre>
 * do - while 표현식
 *  - 조건식 - 반복실행
 *  - 일단 1회 실행후 조건을 검사하도록 처리하는 반복문
 *  - 조건여부와 상관없이 최소1회는 실행되어야 할 흐름에 적합하다. 메뉴노출 , 게임실행 등
 * 초기식;
 * do{
 *  //반복실행구문
 *    증감식;
 * } while(조건식);
 * </pre>
 */
public class DoWhile {
    Scanner sc= new Scanner(System.in);
    char yn;
    public void test1() {
        do{
            System.out.println("게임실행....얍러");
            System.out.println("한판 더 하시겠습니까? y/n : ");
            yn = sc.next().charAt(0);
        }while (yn == 'y');

        System.out.println("게임종료");
    }

    /**
     * exit를 입력하기전까지 무한입력 가능 앱
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        String str; //while 조건식에 사용할 변수는 do블럭 밖에서 선언하기
        do{
            System.out.println("문자열을 입력하세요. (exit) : ");
            str = sc.nextLine();
            System.out.println("> " + str);
            // 기본형이 아닌 문자열은 ==가 아닌 equals 메소드를 통해 동등비교해야 한다.
        }while(!str.equals("exit"));
    }
}
