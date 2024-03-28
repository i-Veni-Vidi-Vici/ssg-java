package com.sh.api._04.wrapper;

/**
 * <pre>
 * Wrapper 클래스가 제공하는 상수/메소드
 * - 기본형의 값범위 MIN_VALUE, MAX_VALUE
 * - 문자열 값을 해당타입값으로 변환하는 parsing메소드 제공 "123" -> 123
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // 상수
        System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE); // -2147483648 ~ 2147483647
        System.out.println(Double.MIN_VALUE + " ~ " + Double.MAX_VALUE); // 4.9E-324 ~ 1.7976931348623157E308
        System.out.println(Character.MIN_VALUE + " ~ " + Character.MAX_VALUE); // \u0000 ~ \uFFFF
        System.out.println((int)Character.MIN_VALUE + " ~ " + (int)Character.MAX_VALUE); // 0 ~ 65535
        System.out.println(Boolean.TRUE + ", " + Boolean.FALSE); // true, false

        // 파싱메소드
//        String -> int
        int i = Integer.parseInt("123");
        System.out.println(i); // 123
//        String -> long
        long i2 = Long.parseLong("123456789012345");
        System.out.println(i2);
//        String -> Double
        double d = Double.parseDouble("123.456");
        System.out.println(d); // 123.456
//        String -> boolean
        boolean bool = Boolean.parseBoolean("true");
        boolean bool2 = Boolean.parseBoolean("True");
        boolean bool3 = Boolean.parseBoolean("TRUE");
        boolean bool4 = Boolean.parseBoolean("."); // false는 true가 아닌 모든 문자열
        System.out.println(bool);
        System.out.println(bool2);
        System.out.println(bool3);
        System.out.println(bool4);
//        String -> char
//        char ch = Character.parseCharacter(); // 메소드 없음
        char ch = "abc".charAt(0);
        System.out.println("abc".charAt(0));

        // 해당타입의 값을 문자열로 변환
        String inum = Integer.valueOf(123).toString();
        System.out.println(inum);
        String dnum = Double.valueOf(123.456).toString();
        System.out.println(dnum);
        String boolStr = Boolean.valueOf(true).toString();
        System.out.println(boolStr);
        String chStr = Character.valueOf('k').toString();
        System.out.println(chStr);

        String inum2 = String.valueOf(123);
        System.out.println(inum2);
        String inum3 = ""+ 123;
        System.out.println(inum3);
    }
}
