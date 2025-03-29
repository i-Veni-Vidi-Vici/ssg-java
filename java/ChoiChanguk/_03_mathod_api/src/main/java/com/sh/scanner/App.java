package com.sh.scanner;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Scanner;

/**
 * <pre>
 * java.util.Scanner클래스 API
 * - 사용자 표준입력(키보드 입력)을 읽어들이는 기능 제공
 * - 사용자 입력값 토큰(공백 개행문자등으로 구분된 문자열)단위로 분리해서 읽어온다.
 * - 문자열, 정수, 실수, 논리값등으로 형변환을 지원하는 메소드 제공.
 *
 * 표준 입력
 * - System.in 키보드
 * 표준 입력
 * - System.out 콘솔
 *
 * 구분
 * - next계열 메소드
 * - nextint
 * - nextDouble
 * - nextBoolean
 * - next
 *
 * - nextLine계열 메소드
 * - nextLine
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //1. scanner객체 생성
        Scanner scanner = new Scanner(System.in);// 표준 입력을 읽어드이는 Scanner객체 생성
        int age;

//        //2. 사용자 입력값 읽어오기
//        System.out.print("이름 입력 : ");
//        String name = scanner.next();// 공백이 나온 순간 입력 끝
//        System.out.println("입력한 이름 : " + name);
//
//        //String name2 = scanner.nextLine();// 문자열처럼 받음, 엔터치면 끝
//        //System.out.println("입력한 문자 : " + name2);
//
//        //3. 정수 입력값 읽어오기
//        System.out.print("나이 입력 : ");
//        age=scanner.nextInt();
//        System.out.println("입력한 나이는 : " + age);
//
//        //4. 실수 double 입력값 읽어오기
//        //Scanner = 기본을 String으로 받음
//        // nextInt-> String을 -> int형으로 변환
//        // double도 마찬가지
//        System.out.println("키 입력 (예 : 177");
//        double height = scanner.nextDouble();
//        System.out.println("입력 한 키 값 = " + height);

//        //5. 논리 입력값 읽어오기
//        System.out.println("결혼하셨습니까?? true / false");
//        boolean married = scanner.nextBoolean();
//        System.out.println(married?"기혼":"미혼");
//
        //6. 문자값 읽어오기
        // scanner에는 char를 읽어오는 메소드를 지원하지 않는다.
        // String#charAt(int) 메소드를 이용해서 0번째 인덱스 문자를 가져온다.
        System.out.println("성별을 입력 (남 / 여) ");
        char gender = scanner.next().charAt(0);
        System.out.println("성병 : "+gender);
        //charAt(x) x= x번째 문자를 줘 ex)cstangga - charAt(2)=t를 반환
        //cstangga - > String - > char 이단 스트링으로 받고 char처리를 한다
    }

}
