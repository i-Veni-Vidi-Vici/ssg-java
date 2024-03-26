package com.sh.api._02.string;

/**
 * <pre>
 * String
 * - Immutable 불변객체 (heap의 String Literal Pool에서 문자열은 별도로 관리됨, 생성된 문자열은 변경 불가)
 * - 리터럴 생성시와 생성자를 통한 생성의 구조는 다름
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        String str1 = "java";
        String str2 = "java";
        String str3 = new String("java");
        String str4 = new String("java");

        // 동일비교
        System.out.println(str1 == str2); // true
        System.out.println(str2 == str3); // false
        System.out.println(str3 == str4); // false

        // 동등비교
        System.out.println(str1.equals(str2)); // true
        System.out.println(str2.equals(str3)); // true
        System.out.println(str3.equals(str4)); // true

        // hashCode
        System.out.println(str1.hashCode()); //3254818
        System.out.println(str2.hashCode()); //3254818
        System.out.println(str3.hashCode()); //3254818
        System.out.println(str4.hashCode()); //3254818

        // 특정 문자열 더하기 연산
        str2 += "ssg";
        System.out.println(str1 == str2); // false
        System.out.println(str1.equals(str2)); // false
        System.out.println(str2.equals(str3)); // false

        // hashCode
        System.out.println(str1.hashCode()); //3254818
        System.out.println(str2.hashCode()); //-1819850587
        System.out.println(str3.hashCode()); //3254818
        System.out.println(str4.hashCode()); //3254818
    }
}
