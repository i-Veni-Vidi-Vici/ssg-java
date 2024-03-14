package com.sh.scanner;

import java.util.Scanner;

/**
 * <pre>
 * - next메소드 ( nextInt, nextDouble, nextBoolean)
 * - 공백, 개행문자 전까지 읽어서 반환
 * ex)이름을 입력합니다 -> "이름을" 반환
 * - nextLine메소드
 * - 개행문자까지 읽어서 개행문자 제거 후 반환
 * ex)이름을 입력합니다 -> "이름을 입력합니다" 반환
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        //주소 읽어오기
        System.out.print("주소 입력 : ");
        //String address = sc.next();//처음 공백까지 입력 받음
        String address = sc.nextLine();//개형 전까지 입력 받음
        System.out.println("주소는 : "+address);
    }
}
