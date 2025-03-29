package com.sh.api._04.wrapper;

import java.util.concurrent.BlockingDeque;

public class App2 {
    public static void main(String[] args) {
        //상수
        System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE); //-2147483648 ~ 2147483647
        System.out.println(Double.MIN_VALUE + " ~ " + Double.MAX_VALUE); //4.9E-324 ~ 1.7976931348623157E308
        System.out.println( (int) Character.MIN_VALUE + " ~ " + (int) Character.MAX_VALUE); // 0 ~ 65535
        System.out.println(Boolean.TRUE + ", " + Boolean.FALSE); //true, false

        // 파싱메소드
        int i = Integer.parseInt("123"); // "123" -> 123 / 숫자 123으로 변환됨
//        int i2 = Integer.parseInt("123456789912345"); //.NumberFormatException
        long i2 = Long.parseLong("123456789912345");
        double d = Double.parseDouble("123.456"); //"123.456" -> 123.456 으로 변환됨
        boolean bool = Boolean.parseBoolean("TRUE"); // "true" "True" "TRUE" -> true/ "flase" "False" "FALSE" -> false, true가 아닌 모든 문자열은 false로 출력됨
        boolean bool2 = Boolean.parseBoolean("false"); //
        System.out.println(bool + ", " + bool2);

//        char ch = Character.parseCharacter(); //메소드 없음
        char ch = "abc".charAt(0);

        //해당 타입의 값을 문자열로 변환
        String inum = Integer.valueOf(123).toString(); //123 -> "123" 문자열이 됨
        String dnum = Double.valueOf(123.456).toString(); //123.456 -> "123.456"
        String boolstr = Boolean.valueOf(true).toString(); //true -> "true"
        String chStr = Character.valueOf('k').toString(); //'k' -> "k"

        String inum2 = String.valueOf(123);
        String inum3 = "" + 123;
    }
}
