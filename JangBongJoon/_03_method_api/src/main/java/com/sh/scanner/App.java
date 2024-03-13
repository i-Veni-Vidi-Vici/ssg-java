package com.sh.scanner;

import java.util.Scanner;

/*
java.util.Scanner
사용자 표준입력(키보드 입력)을 읽어들이는 기능 제공
사용자 입력값 토큰(공백/개행문자등으로 구분된 문자열)단위로 분리해서 읽어온다
문자열 정수 실수 논리값으로 형변환을 지원
표준입력
    system.in 키보드
표준출력
구분
 -next계열 메소드
 nextInt
 nextDouble
 nextBoolean
 next
 nextLine
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //2.사용자 입력값 읽어오기
        System.out.println("이름 입력: ");
        String name = scanner.next();
        System.out.println(">입력한 이름은 " +
                name +
                "입니다.");
        //3 정수 입력값 읽어오기
        System.out.println("나이 입력: ");
        int age = scanner.nextInt();
        System.out.println("> 입력한 나이는  " +
                age + "세 입니다.");
    }
}
