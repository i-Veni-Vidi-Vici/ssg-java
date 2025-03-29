package com.sh.condition.loop._for;


import java.util.Random;
import java.util.Scanner;

/**
 * <pre>
 *  for문 표현식
 *
 * for(초기식; 조건식; 증감식){
 *    //반복 실행 구문
 * }
 * - 초기식 : 증감 변수 선언
 * - 조건식 : 반복문 실행여부
 * - 증감식 : 증감변수 증가/감소 처리
 * - 증감변수 : 반복횟수, 반복시 변하는 값 등을 위해 선언한 변수
 *
 * 실행순서
 * 1. 초기식
 * 2. 조건식 : true인 경우 | false인 경우 반복문 탈출
 * 3. 블럭진입 - 반복실행구문
 * 4. 증감식 -> 조건식으로 다시 이동
 *
 * 증감식이 없다면 -> i = 1인 상태로 무한 반복문 실행
 * 조건식이 없다면 -> 조건식이 true로 고정된 상태에서 무한반복문 실행
 * 초기식, 조건식, 증감식이 모두 없는 경우 => 무한반복문 실행
 * </pre>
 */
public class For {
    public void test() {
        //1-10;
        //for(int i = 1; i<=10; i++) System.out.print(i + " ");

        //증감식이 없다면 -> i = 1인 상태로 무한반복문 실행
        //for(int i = 1; i <= 10;)
//        {
//
//        }
        //조건식이 없다면 -> 조건식이 True로 고정되고 무한반복문 실행
        for(int i = 1; ; i++)
        {
            System.out.println(i);
        }

        //초기식, 조건식, 증감식이 모두 없는 경우 => 무한반복문 실행
        //for(;;){
        // System.out.println("hello world");
        }
    public void test2()
    {
        //0 ~ 9 출력
//        for(int i = 0; i<10; i++)
//        {
//            System.out.println(i + " ");
//        }
//        //11 ~ 20 출력
//        for (int i = 1; i<=20; i++) {
//            System.out.println(i);
//        }
//
//        //홀수
//        for(int i = 1; i <= 20; i+=2)
//        {
//
//                System.out.println(i);
//        }
        //10 - 1 출력
//        for(int i = 10; i>0; i--){
//            System.out.println(i);
//        }
        // 20
        for(int i = 20; i>=2; i-= 2)
        {
            System.out.println(i);
        }
    }

    /**
     * - 언제 반복문을 적용해야 하는가?
     * - 몇번 반복해야 하는가 ?
     * - 매턴마다 달라지는 부분은 어떻게 처리할 것인가 ?
     */
    public void test3()
    {
        // 10명의 학생 이름을 입력 받아 출력해야 함.
        Scanner scanner = new Scanner(System.in);
        String name ;
        for(int i =1; i<=5; i++)
        {
            System.out.print(i+"번 학생 이름 입력 : " );
            name =  scanner.next();
            System.out.println(i+"번 학생명 : " + name);
        }

    }

    //1부터 10까지 합 더하기
    public void test4()
    {
        int sum = 0;
        for(int i = 1; i<= 10 ; i++)
        {
            sum += i;
        }
        System.out.println(sum);

        //실수 포인트 : sum 변수를 for문 블럭 안에 선언하면 안된다. 블럭 안에 선언하면 외부에서 접근이 불가능하고,
        // 매턴마다 0으로 초기화 됨.
    }

    //1부터 난수까지의 합 구하기
    public void test5()
    {
        Random rnd = new Random();
        int number = rnd.nextInt(5) + 6;
        System.out.println("랜덤 숫자 : " + number);
        int sum = 0;

        // 반복횟수, 증감변수의 범위를 난수에 따라 결정
        for(int i = 1; i<=number; i++)
        {
            sum += i;
        }
        System.out.println("숫자 합 : " + sum);
    }

    /**
     * 사용자로부터 입력 받은 단수의 구구단 출력
     */

    public  void test6()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("단수 입력 : ");
        int number = scan.nextInt();

        for(int i =1; i<=9; i++)
        {
            //System.out.println( number + "*" + i + "=" + (number * i));
            //prinf는 기본적으로 개행을 지원하지 않는다. %d 정수, %f 실수 , %s문자열
            System.out.printf("%d * %d = %d\n", number, i, number*i );
        }
    }


}
