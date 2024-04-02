package com.sh.api._04.wrapper;

/**
 * <pre>
 * Wrapper 클래스가 제공하는 상수/메소드
 * - 기본형의 값 범위 MIN_VALUE, MAX_VALUE
 * - 문자열 값을 해당 타입 값으로 변환하는 parsing 메소드 제공 "123" -> 123
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // 상수
        System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
        System.out.println(Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
        System.out.println((int) Character.MIN_VALUE + " ~ " + (int) Character.MAX_VALUE);
        System.out.println(Boolean.TRUE + ", " + Boolean.FALSE);

        // 파싱 메소드
        int i = Integer.parseInt("123"); // "123" -> 123
        long l = Long.parseLong("123456789012345");
        double d = Double.parseDouble("123.456");
        boolean bool = Boolean.parseBoolean("true");
        boolean bool2 = Boolean.parseBoolean("false");
        System.out.println(bool);

        // char ch = Character.parseCharacter(); // 메소드 없음
        char ch = "abc".charAt(0);

        // 해당 타입의 값을 문자열로 변환
        String inum = Integer.valueOf(123).toString(); // 123 -> "123"
        String dnum = Double.valueOf(123.456).toString();
        String boolstr = Boolean.valueOf(true).toString();
        String chStr = Character.valueOf('k').toString();

        String inum2 = String.valueOf(123);
        String inum3 = "" + 123;
    }
}
