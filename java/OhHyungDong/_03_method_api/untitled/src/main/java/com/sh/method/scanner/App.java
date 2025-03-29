package com.sh.method.scanner;

import java.util.Scanner;

/**
 * java.util.Scanner클래스 API
 * - 사용자 표준입력(키보드 입력) 을 읽어들이는 기능을 제공함.
 * - 사용자 입력값 토큰 단위로 분리해서 읽어온다
 * - 문자열, 정수, 실수, 논리값 등으로 형변환을 지원하는 메소드 제공.(토큰 : 문자열 단위, 공백/개행문자로 구분된 문자열을 의미함.)
 *
 * 표준 입력
 * - System.in : 키보드
 * 표준 출력
 * - System.out : 콘솔
 *
 * 구분
 * - next계열 메소드
 *  - nextInt();
 *  - nextDouble();
 *  - nextBoolean();
 *  - next()
 * - nextLine계열 메소드
 *  - nextLine
 */
public class App {
    public static void main(String[] args) {
        // 객체 생성
        Scanner scan = new Scanner(System.in);
        // 사용자 입력값 읽어오기
//        System.out.print("이름 입력 : ");
//        String name = scan.next();
//        System.out.println("입력한 이름 : " + name);
//        // 정수 입력값 읽어오기
//        System.out.println("나이 입력 : ");
//        int age = scan.nextInt();
//        System.out.println("입력한 나이는 " + age + "세 입니다.");
//
//        //4. 실수 double형 입력값 읽어오기.
//        System.out.println("키 입력 : ");
//        double height = scan.nextDouble();
//        System.out.println("입력한 키는 "+ height + "입니다. ");
//
        //5. 논리 입력값 읽어오기
        System.out.println("결혼 하셨습니까? true/false : ");
        boolean married = scan.nextBoolean();
        System.out.println("입력값 결혼 여부는 " + (married ? "기혼" : "미혼") + "입니다. ");

        //6. 문자값 읽어오기 -
        //Scanner에는 char를 읽어오는 메소드를 지원하지 않는다.
        //String#charAt(int)메소드를 이용해서 0번째 인덱스 문자를 가져온다.
        System.out.println("성별 입력 (남/여): ");
        char gender = scan.next().charAt(0); // string -> char "남" -> '남'
        System.out.println("입력하신 성별은 " + gender + "입니다.");


    }
}
