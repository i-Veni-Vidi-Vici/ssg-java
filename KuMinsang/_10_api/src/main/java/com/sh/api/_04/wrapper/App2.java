package com.sh.api._04.wrapper;

/**
 *
 */
public class App2 {
    public static void main(String[] args) {
        //상수
        System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE); //-2147483648 ~ 2147483647
        System.out.println(Double.MIN_VALUE + " ~ " + Double.MAX_VALUE); //4.9E-324 ~ 1.7976931348623157E308
        System.out.println((int)Character.MIN_VALUE + " ~ "+ (int)Character.MAX_VALUE); //0 ~ 65535
        System.out.println(Boolean.TRUE + " , " + Boolean.FALSE);

        //파싱메소드
        int i = Integer.parseInt("123"); //"123 ->123
        long i2 = Long.parseLong("123456789012345");
        double d = Double.parseDouble("123.456");   // "123.456" -> 123.456
        boolean bool = Boolean.parseBoolean("TRue");    //대소문자 구분 안함 true가 아닌 모든 문자를 false로 처리
        System.out.println(bool);
        // char ch = Character.parseCharacter();    //메소드 없음
        char ch = "abc".charAt(0);
        //
        String inum = Integer.valueOf(123).toString(); //123->"123
        String dnum = Double.valueOf(123.456).toString(); //123.456->"123.456
        String boolStr = Boolean.valueOf(true).toString(); //true -> "true"
        String chStr = Character.valueOf('A').toString(); //'A'->"A"
        //String.valueOf와 동일함
        String inum2 = String.valueOf(123);
        String inum3 = "" + 123;

    }
}
