package com.sh.condition.loop._while;

import java.util.Scanner;

public class DoWhile {
    /**
     * <pre>
     * do ~ while 표현식
     * - 조건식 - 반복 실행 순으로 처리되는 일반 반복문과 달리 do안에 있는 코드가 1회 먼저 실행 후 조건 검사
     * - 조건 여부와 상관 없이 최소 1회는 실행되어야 할 흐름에 적합하다. 메뉴 노출, 게임 실행 등
     * do{
     *     //반복 실행 구문
     *     증감식;
     * }while(조건식);
     *
     * </pre>
     */
    public void test()
    {
        Scanner scanner = new Scanner(System.in);
        char yn;
        do {
            System.out.println("게임 실행 .......");
            System.out.println("한판 더 하시겠습니까 ? y/n : ");
            yn = scanner.next().charAt(0);
        }while(yn == 'y');
        System.out.println("게임 종료.");
    }

    /**
     * exit를 입력하기전까지 무한 입력 가능 앱
     */
    public void test2()
    {
        Scanner scanner = new Scanner(System.in);
        String exit; // while조건식에 사용할 변수는 do블럭 밖에 선언하기.
        do{
            System.out.println("문자열 입력 : (중지하려면 exit) : ");
            exit =  scanner.nextLine();
            System.out.println(">" + exit);
        }while(!exit.equals("exit"));
    }

}
