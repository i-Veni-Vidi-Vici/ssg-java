package com.sh.api._04.wrapper;

/**
 * <pre>
 * Wrapper클래스가 제공하는 상수/메소드
 * - 기본형의 값범위 MIN_VALUE, MAX_VALUE
 * - 문자열 값을 해당타입값으로 변환하는 parsing메소드 제공  "123" -> 123
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // 상수
        System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE); // -2147483648 ~ 2147483647

        // 파싱 메소드
        int i = Integer.parseInt("123");
        long l = Long.parseLong("123123123123123123");
        boolean bool1 = Boolean.parseBoolean("true"); // true, True, TRUE
        boolean bool2 = Boolean.parseBoolean("false"); // true 가 아닌 모든 문자열
        System.out.println(bool2);
        // char 는 파싱 메소드가 없다.
        char ch = "abc".charAt(0);

        // 해당 타입의 값을 문자열로 변환
        String inum = Integer.valueOf(i).toString();
        String dnum = Double.valueOf(123.456).toString();
        String chStr = Character.valueOf('k').toString();
        System.out.println(String.valueOf('k'));
    }
}
