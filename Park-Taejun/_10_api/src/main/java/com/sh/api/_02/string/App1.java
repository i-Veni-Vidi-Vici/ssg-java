package com.sh.api._02.string;

/**
 *String
 * - Immutable 불변객체 (String Literal Pool 에서 문자열은 별도로 관리된다. 생성된 문자열은 변경할 수 없다.)
 * - 리터럴 생성시와 생성자를 통한 생성의 구조는 다르다
 */
public class App1 {
    public static void main(String[] args) {
        String str1 = "java";
        String str2 = "java";
        String str3 = new String( "java");
        String str4 = new String( "java");
        //동일 비교
        System.out.println(str1 == str2); // true
        System.out.println(str2 == str3); // false
        System.out.println(str3 == str4); // false

        // 동등성 비교
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3)); //그래서 문자열에 대한 값비교는 equals로 해야함
        System.out.println(str1.equals(str4)); //문자열이 같으므로 다 true


        //hashCode 비교
        System.out.println(str1.hashCode()); //equals 비교가 true라면 동일한 hashcode값을 뱉어낼 수 있어야함 . 3254818
        System.out.println(str2.hashCode()); // equlas와 hashcode는 동일한 기준으로 override 되어 있을 것 이므로
        System.out.println(str3.hashCode());
        System.out.println(str4.hashCode());
        // 특정문자열에 더하기 연산
        str2 += "ssg";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str2.equals(str3)); //문자열은 == 쓰면 안되고 반드시 equals 사용한다.

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str4.hashCode());
    }
}
