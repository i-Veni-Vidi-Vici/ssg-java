package com.sh.scanner;

import java.util.Scanner;

/**
 * java.util.Scanner 클래스 API
 * - 사용자 표준입력(키보드 입력)을 읽어 들이는 기능 제공
 * - 사용자 입력값 토큰(공백/개행문자등으로 구문된 문자열)단위로 분리해서 읽어온다.
 * - 문자열, 정수, 실수, 논리값등으로 형변환을 지원하는 메소드 제공.
 * 표준입력
 * - System.in 키보드
 * 표준출력
 * - System.out 콘솔
 * 구분
 * - next 계열 메소드
 *     - nextInt
 *     - nextDouble
 *     - nextBoolean
 *     - next
 * - nextLine 계열 메소드
 *     - nextLine
 */
public class App {
    public static void main(String[] args) {
        // 1. Scanner 객체 생성
        Scanner sc = new Scanner(System.in); // 표준입력을 읽어들이는 Scanner 객체 생성

        // 2. 사용자 입력값 읽어오기
        //System.out.print("이름 입력: ");
        //String name = sc.next();
        //System.out.println("> 입력한 이름은 " + name + "입니다.");

        // 3. 정수 입력값 읽어오기
        // System.out.print("나이 입력: ");
        // int age = sc.nextInt();
        // System.out.println("> 입력한 나이는 " + age + "입니다.");

        // 4. 실수 double 입력값 읽어오기
        // System.out.print("키 입력 (예: 177.7): ");
        // double height = sc.nextDouble();
        // System.out.println("> 입력한 키는 " + height + "cm 입니다.");

        // 5. 논리 입력값 읽어오기
        // System.out.print("결혼하셨습니까? true / false: ");
        // boolean married = sc.nextBoolean();
        // System.out.println(married ? "기혼" : "미혼");

        // 6. 문자값 읽어 오기
        // Scanner 에는 char 를 읽어오는 메소드를 지원하지 않는다.
        // String$charAt(int) 메소드를 이용해서 0번째 인덱스문자를 가져온다.
        System.out.print("성별을 입력 (남 / 여): ");
        char gender = sc.next().charAt(0);
        System.out.println("> 당신의 성별은: " + gender);
    }
}
