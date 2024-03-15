package com.sh.scanner;

import java.util.Scanner;

/**
 * <h3>java.util.Scanner 클래스 API</h3>
 * <pre>
 *     - 사용자 표준 입력(키보드 입력)을 읽어들이는 기능 제공
 *     - 사용자 입력자 토늨(공백/개행문자 등으로 구분된 문자열) 단위로 분리해서 읽어온다.
 *     - 문자열, 정수, 실수, 논리값 등으로 형변환을 지원하는 메소드 제공
 *
 *     표준입력
 *     - System.in 키보드
 *     표준출력
 *     - System.out 콘솔
 *
 *     구분
 *     - next 계열 메소드
 *     - nextInt
 *     - nextDouble
 *     - next Boolean
 *     - next
 *홍
 *     - nextLine 계열 메소드
 *     - nextLine
 * </pre>
 *
 */
public class App {
    public static void main(String[] args) {
        // 1. Scanner 객체 생성
        Scanner sc = new Scanner(System.in);
        // 2. 사용자 입력값 읽어오기
        System.out.print("이름 입력 : ");
        String name = sc.next(); // 문자열 반환
        System.out.println("> 입력한 이름은 " + name + " 입니다.");

        // 3. 정수 입력값 읽어오기
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();
        System.out.println("> 입력한 나이는 " + age + "세 입니다.");

        // 4. 실수 double 입력값 일겅오기
        System.out.println("키 입력 (예 : 177.7) :");
        double height = sc.nextDouble();
        System.out.println(" > 입력한 키는 " + height + " cm 입니다.");

        // 5. 논리 입력값 읽어오기
        System.out.println("결혼하셨습니까? true / false : ");
        boolean married = sc.nextBoolean();
        System.out.println(" > 입력한 결혼 여부는 " + (married ? "기혼" : "미혼") + " 입니다.");

        // 6. 문자값 읽어오기
        // Scanner는 char 지원 x
        // String#charAt(int) 메소드를 사용해서 int번째 인덱스 문자를 가져온다.
        System.out.println("성별입력 ( 남/여 ) : ");
        char gender = sc.next().charAt(0);

        // 주소 읽어오기
        System.out.println(" 주소 입력 : ");
//        String address = sc.next(); // 공백 전까지만 저장
        String address = sc.nextLine();

        System.out.println(address);
    }
}
