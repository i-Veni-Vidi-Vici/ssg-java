package com.sh.api._02.string;

/**
 * <pre>
 * String
 * - Immutable 불변객체 (String Literal Pool에서 문자열은 별도로 관리된다. 생성된 문자열은 변경할 때마다 새로운 객체를 생성한다)
 * - 리터럴 생성시와 생성자를 통한 생성의 구조는 다르다.
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        String str1 = "java";// heap -> String Literal Pool 공간에 "java"객체 공간이생기고 주소값이 생긴다
        String str2 = "java";// heap안에 String Literal Pool 공간에 같은 문자가 있으니 같은 주소값을 갖는다
        String str3=new String("java");// String Literal Pool
        String str4 = new String("java");

        //동일 비교
        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str3==str4);

        // 동등성 비교
        System.out.println(str1.equals(str2));
        System.out.println(str2.equals(str3));
        System.out.println(str3.equals(str4));

        // hashCdoe
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str4.hashCode());

        //특정문자열 더하기 연산
        str2+="ssg";
        System.out.println(str1==str2);
        System.out.println(str1.equals(str3));
        System.out.println(str2.equals(str3));

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str4.hashCode());
        System.out.println("");
    }
}
