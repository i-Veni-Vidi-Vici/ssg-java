package com.sh.api._04.wrapper;

/**
 * <pre>
 * Wrapper클래스가 제공하는 상수/메소드
 * - 기본형의 값범위 MIN_VALUE, MAX_VALUE
 * - 문자열 값을 해당 타입값으로 변환하는 parsing 메소드 제공 ex)"123"(문자열) -> 123(정수)
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // 상수
        System.out.println(Integer.MIN_VALUE + "~" + Integer.MAX_VALUE); // -2147483648~2147483647
        System.out.println(Double.MIN_VALUE + "~" + Double.MAX_VALUE); // 4.9E-324~1.7976931348623157E308
        System.out.println((int)Character.MIN_VALUE + "~" + (int)Character.MAX_VALUE); // 0~65535
        System.out.println(Boolean.TRUE + ", " + Boolean.FALSE); // true, false

        // 파싱메소드
        int i = Integer.parseInt("123"); // "123"(문자열) -> 123(정수)
        long l = Long.parseLong("1234567890123456");
        double d = Double.parseDouble("123.456");
        boolean bool = Boolean.parseBoolean("trUe"); // "true"(대소문자 상관없음)를 제외한 모든 문자는 false
        System.out.println(bool);
//        char ch = Character.parseCharacter(); // 메소드 없음
        char ch = "abc".charAt(0);

        // 해당 타입의 값을 문자열로 변환
        String inum = Integer.valueOf(123).toString(); // 123 -> "123"
        String dnum = Double.valueOf(123.456).toString(); // 123.456 -> "123.456"
        String boolStr = Boolean.valueOf(true).toString(); // true -> "true"
        String chStr = Character.valueOf('k').toString(); // 'k' -> "k"

        String inum2 = String.valueOf(123); // 위보다 더 간단
        String inum3 = "" + 123;





    }
}
