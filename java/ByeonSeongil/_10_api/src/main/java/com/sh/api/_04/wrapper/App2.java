package com.sh.api._04.wrapper;

/**
 * <pre>
 * Wrapper클래스가 제공하는 상수/메서드
 * - 기본형의 값범위 MIN_VALUE, MAX_VALUE
 * - 문자열 값을 해당타입값으로 변환하는 parsing메서드 제공 "123" ->123
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE +" ~"+Integer.MAX_VALUE);
        System.out.println(Double.MIN_VALUE+ "~" + Double.MAX_VALUE);
        System.out.println((int) Character.MIN_VALUE + "~"+ (int)Character.MAX_VALUE);
        System.out.println(Boolean.TRUE + "," + Boolean.FALSE);

        // 파싱
        int i = Integer.parseInt("123");
        long l = Long.parseLong("123213123123");
        double v = Double.parseDouble("123.456");
        boolean aTrue = Boolean.parseBoolean("tRue"); // "true"
        boolean aTrue2 = Boolean.parseBoolean("false"); // "false"
        System.out.println(aTrue);
        System.out.println("aTrue2 = " + aTrue2);
        
        // 해당타입의 값을 문자열로 변환
        String inum = Integer.valueOf(123).toString();
        String string = ((Double) 123.56).toString();

    }
}
