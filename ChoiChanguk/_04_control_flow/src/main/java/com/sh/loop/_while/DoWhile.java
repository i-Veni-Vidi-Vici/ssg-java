package com.sh.loop._while;

import java.util.Scanner;

/**
 * <pre>
 * do~while표현식
 * 초기식 - 반복실행 순으로 처리되는 일반 반복문(for, while)과 달리
 * 일단 1회 실행 후 조건을 검사하도록 저리하는 반복문
 * - 조건 여부와 상관없이 최소1회는 실행되어야 할 흐름에 적합니다.
 * - 메뉴노출, 게임실행 등
 * 초기식
 * do{
 *     //반복실행
 *     증감식
 * }
 * </pre>
 */
public class DoWhile {
    public void test1(){
        Scanner sc=new Scanner(System.in);
        char yn;
        int i=0;
        System.out.println("게임 실행.....최초 실행");
        do {
            System.out.println("한 판 더 하시겠습니까??");
            yn=sc.next().charAt(0);
        }while(yn=='y');
        System.out.printf("게임 종료");
    }

    public void test2() {
        /**
         * exit를 입력하기 전까지 무한입력 가능 앱
         */


        Scanner sc=new Scanner(System.in);
        String str;//while 조건식에 사용할 변수는 do블럭 밖에 선언하기

        do{

            System.out.print("exit를 입력하면 중지됩니다");
            str=sc.nextLine();

        }while(str.equals("exit"));//ㅣ입력값이 exit일떄 false인 조건식 인정
//스트링 비교는 ==, 이게 아닌-> equals 사용한다
        System.out.printf("중비 했습니다");
    }
}
