package com.sh.api._02.string;

/**
 * <pre>
 * String
 * - Immutable 불변객체 (String Literal Pool에서 문자열은 별도로 관리된다. 생성된 문자열은 변경할 수 없다)
 * - 리터럴 생성시와 생성자를 통한 생성의 구조는 다르다.
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        String str1 = "java";
        String str2 = "java";
        String str3 = new String("java");
        String str4 = new String("java");

        // 동일비교
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str3 == str4);

        // 동등성 비교
        System.out.println(str1.equals(str2));
        System.out.println(str2.equals(str3));
        System.out.println(str3.equals(str4));

        // hashCode비교
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str4.hashCode());

        // 특정문자열 더하기 연산
        str2 += "ssg"; // "javassg"
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str2.equals(str3));

    }
}
