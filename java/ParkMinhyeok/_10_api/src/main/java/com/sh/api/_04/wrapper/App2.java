package com.sh.api._04.wrapper;

/**
 * Wrapper 클래스가 제공하는 상수 / 메소드
 * - 기본형의 값범위 MIN_VALUE, MAX_VALUE
 * - 문자열 값을 해당 타입값으로 변환하는 parsing 메소드 제공 "123 -> 123
 */
public class App2 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
        System.out.println(Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
        System.out.println((int) Character.MIN_VALUE + " ~ " + (int) Character.MAX_VALUE);
        System.out.println(Boolean.TRUE + " , " + Boolean.FALSE);

        // 파싱메소드
        int i = Integer.parseInt("123");
        long l = Long.parseLong("1234567890123412222");
        double d = Double.parseDouble("123.456");
        boolean bool = Boolean.parseBoolean("true"); // "true", "True", "TRUE"
        boolean bool2 = Boolean.parseBoolean("false"); // true가 아닌 모든 문자열

//        char ch = Character.parseCharacter(); // 메소드 없음
        char ch = "abc".charAt(0);

        // 해당 타입의 값을 문자열로 변환
        String inum = Integer.valueOf(123).toString();
        System.out.println(inum);


    }
}
