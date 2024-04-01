package com.sh.api._04.wrapper;

/**
 * <pre>
 * Wrapper 클래스가 제공하는 상수 / 메소드
 * - 기본형의 값 범위를 MIN_VALUE, MAX_VALUE 제공
 * - 문자열 값을 해당타입 값으로 변환하는 parsing메소드 제공 "123" -> 123
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        //상수
        System.out.println(Integer.MAX_VALUE);

        //parse메소드
        int i = Integer.parseInt("123"); // 정수값 123 출력하고 i에 대입
        long a  = Long.parseLong("1234567812345");

        //해당 타입의 값을 문자열로 변환
        String inum = Integer.valueOf(123).toString(); //123 -> "123"
        String dnum = Double.valueOf(123.456).toString();//"123.456"
    }
}
