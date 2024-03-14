package com.sh.scanner;

import java.util.Scanner;

/**
 * <pre>
 *     java.util.Scanner 클래스 API
 *     - 사용자 표준입력(키보드 입력)을 읽어들이는 기능 제공
 *     - 사용자 입력을 토큰 단위(공백, 개행문자 등으로 구분된 문자열)로 분리해서 읽어들인다.
 *     - 문자열, 정수, 실수, 논리값 등으로 변환하여 리턴하는 메소드 제공
 *
 *     표준 입력 // 키보드
 *     - System.in
 *     표준 출력 // 콘솔
 *     - System.out
 *
 *     구분
 *     - next 계열 메소드
 *     - nextInt()
 *     - nextBoolean()
 *     - next()
 *
 *     - nextLine() 계열 메소드
 *     - nextLine()
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        // 1. Scanner 객체 생성, Scanner 클래스 사용하기 위해 import 필요
        Scanner sc = new Scanner(System.in);            // 표준 입력을 읽어들이는 Scanner 객체 생성
//
//        // 2. 문자열 String 입력값 읽어오기
//        System.out.print("이름 입력 : ");
//        String name = sc.next();
//        System.out.println("> 입력한 이름은 " + name + "입니다.");
//
//        // 3. 정수 int 입력 값 읽어오기
//        System.out.print("나이 입력: ");
//        int age = sc.nextInt();
//        System.out.println("> 입력한 나이는 " + age + "세 입니다.");
//
//        // 4. 실수 double 입력값 읽어오기
//        System.out.println("키 입력 (예 : 177.7) : ");
//        double height = sc.nextDouble();
//        System.out.println("> 입력한 키는 " + height + "cm 입니다.");
//
//        // 5. 논리 입력값 읽어오기
//        System.out.println("결혼하셨습니까? true / false : ");
//        boolean isMarried = sc.nextBoolean();
//        System.out.println("> 입력값 결혼여부는 " + (isMarried ? "기혼" : "미혼") + "입니다.");
//
        // 6. 문자값 읽어오기
        // Scanner에는 char를 읽어오는 메소드를 지원하지 않는다.
        // String#charAt(int)메소드를 이용해서 0번째 인덱스 문자를 가져온다.
        // "남" --> '남'
        System.out.println("성별 입력 (남 / 여): ");
        char gender = sc.next().charAt(0);
        System.out.println("> 입력하신 성별은 " + gender + "입니다.");
    }
}
