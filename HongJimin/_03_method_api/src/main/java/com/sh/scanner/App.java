package com.sh.scanner;

import java.util.Scanner;

/**
 * java.util.Scanner 클래스 API
 * - 사용자 표준 입력(키보드 임력)을 읽어들어들이는 기능 제공
 *
 * 표준 입력
 * - System.in 키보드
 *
 * 표준 출력
 * -system.out 콘솔
 */
public class App {
    public static void main(String[] args) {
        //1. Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        //2. 그리고 사용자 입력값 읽어오기
        System.out.println("이름 입력 : ");
        String name = sc.next();
        System.out.println("> 입력한 이름은 "+ name + "입니다.");

        //3. 정수 입력값 읽어오기
        System.out.println("나이 입력 : ");
        int age = sc.nextInt();
        System.out.println(">입력한 나이는 " + age + "세 입니다.");

        //4. 실수 double 입력값 읽어오기
        System.out.println("키 입력 (예 : 158) : ");
        double height = sc.nextDouble();
        System.out.println("> 입력한 키는 " + height + "cm 입니다.");

        // 5. 논리 입력 값 읽어오기
        System.out.println("결혼했어? true / false : ");
        boolean married = sc.nextBoolean();
        System.out.println("> 입력한 결혼 여부는 " + (married ? "기혼" : "미혼"));

        // 6. 문자값 읽어오기
        //Scanner에는 char를 읽어오는 메소드를 지원하지 않는다.
        //String#charAt(int) 메소드를 이용해 0번 째 인덱스 문자를 가져온다.
        System.out.println("성별 입력 (남 / 여) : ");
        char gender = sc.next().charAt(3);
        System.out.println("> 입력하신 성별은 " + gender + "입니다.");
    }
}
