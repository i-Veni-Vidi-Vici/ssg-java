package com.sh.scanner;

import java.util.Scanner;

/**
 * java.util.Scanner 클래스 API
 * - 사용자 표준 입력(키보드 입력)을 읽어들이는 기능을 제공
 * - 사용자 입력값 토큰(공백|개행문자등으로 구분된 문자열) 단위로 분리해서 읽어온다
 * - 문자열, 정수, 실수, 논리값등으로 형변환을 지원하는 메소드 제공.
 *
 * 표준 입력
 * - System.in 키보드
 * 표준 출력
 * - System.out 콘솔
 *
 * 구분
 * -next계열 메소드
 *  -nextInt
 *  -nextDouble
 *  -nextBolean
 *  -next
 *      - 버퍼에 입력된 문자나 문자열에서 공백 전까지의 단어를 읽는다
 *      - 개행문자를 가져오지 않는다

 * -nextLine계열 메소드
 *  -nextLine
 *      - 엔터를 치기 전까지의 문장 전체를 입력받는다
 *      - 버퍼에 입력된 문자열을 개행 문자까지 다 가져온다
 */
public class App {
    public static void main(String[] args) {
        //1. Scanner 객체 생성
        Scanner sc = new Scanner(System.in);    //표준 입력을 읽어들이는 Scanner 객체 생성
        //2. 사용자 입력 값 읽어오기
        //공백문자 전까지 읽어온다
        //"박 문수"를 입력하면 '박'만 가져온다
        /*
        System.out.println("이름 입력 : ");
        String name = sc.next();
        System.out.println("> 입력한 이름은 " + name + "입니다.");

        //3. 정수 입력 값 읽어오기

        System.out.println("나이 입력 : ");
        int age = sc.nextInt();
        System.out.println(">입력한 나이는" + age + "세 입니다.");

        //개행문자 전까지 문자열을 모두 가져옴
        //앞의 nextInt()가 남긴 \n을 읽게 되어 바로 종료된다
        sc.nextLine();
        System.out.println("주소 입력 : ");
        String addr = sc.nextLine();
        System.out.println("> 입력한 주소은 " + addr + "입니다.");

         */

        //4. 실수 double 입력값 읽어오기
        /*
        System.out.println("키 입력 (예:177.7 : ");
        double height = sc.nextDouble();
        System.out.println("입력한 키는 " + height + "cm 입니다.");
        */

        //5. 논리 입력 값 읽어오기
        /*
        System.out.println("결혼 하셨습니까? true / false : ");
        boolean married = sc.nextBoolean();
        System.out.println("/> 입력값 결혼 여부는 " + (married ? "기혼" : "미혼") + "입니다.");

         */

        //6. 문자 값 읽어오기
        //Scanner는 char를 읽어오는 메소드를 지원하지 않는다.
        //String#charAt(int)메소드를 이용해서 0번째 인덱스 문자를 가져온다.
        System.out.println("성별 입력 (남 / 여): ");
        char gender = sc.next().charAt(0);
        System.out.println("> 입력하신 성별은 " + gender + "입니다.");



    }

}
