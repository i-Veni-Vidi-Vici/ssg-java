package com.sh.scanner;

import java.util.Scanner;

/**
 * java.util.Scanner 클래스
 * - 사용자 표준입력(키보드 입력)을 읽어들이는 기능 제공
 * - 사용자 입력값을 토큰 단위(공백/개행 등으로 구분된 문자열)로 분리해서 읽어온다.
 * - 문자열, 정수, 실수, 논리값 등으로 형변환을 지원하는 매소드 제공.
 *
 * 표준입력
 * - System.in 키보드
 * 표준출력
 * - System.out 콘솔
 *
 * 구분
 * -next계열 메소드
 *  - nextInt
 *  - nextDouble
 *  - nextBoolean
 *  - next
 *
 * -nextLine계열 메소드
 *  - nextLine
 */
public class App {
    public static void main(String[] args) {
        //1.Scanner 객체 생성
        Scanner scanner  = new Scanner(System.in); // 표준입력을 읽어들이는 Scanner 객체 생성
        //2.사용자 입력값 읽어오기
        System.out.println("이름 입력: ");
        String name = scanner.next();
        System.out.println("입력한 이름은 "+name +" 입니다.");
        System.out.println("나이 입력: ");
        int age = scanner.nextInt();
        System.out.println("입력한 나이는 "+age+" 입니다.");

    }
}
