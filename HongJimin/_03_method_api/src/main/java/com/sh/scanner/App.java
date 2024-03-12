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
    }
}
