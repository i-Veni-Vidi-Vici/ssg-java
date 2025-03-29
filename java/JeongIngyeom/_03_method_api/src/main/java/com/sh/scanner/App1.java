package com.sh.scanner;

import java.util.Scanner;

/**
 * java.util.Scanner 클래스 API
 * - 사용자 표준입력(키보드 입력)을 읽어들이는 기능 제공
 * - 사용자 입력값을 토큰(공백, 개행문자 등으로 구분된 문자열) 단위로 분리해서 읽어온다.
 * - 문자열, 정수, 실수, 논리값 등으로 형변환을 지원하는 메소드 제공
 *
 * 표준 입력
 * - 키보드 -> System.in이라는 변수에 담아둠
 *
 * 표준 출력
 * - 콘솔 -> System.out이라는 변수에 담아둠
 *
 * 구분
 * - next 계열 메소드
 * - nextInt
 * - nextDouble
 * - nextBoolean
 * - next
 *
 * - nextLine 계열 메소드
 * - nextLine
 */
public class App1 {

    public static void main(String[] args) {
        // 1. Scanner 객체 생성
        Scanner sc = new Scanner(System.in);        // 표준 입력을 읽어들이는 Scanner 객체 생성

        // 2. 사용자 입력값 읽어오기
        System.out.print("이름 입력 : ");
        String name = sc.next();
        System.out.println("> 입력한 이름은 " + name + "입니다.");

        // 3. 정수 int 입력값 읽어오기
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();
        System.out.println("> 입력한 나이는 " + age + "입니다.");
    }
}
