package com.sh._enum._02.basics;

import javax.security.auth.Subject;

/**
 * <pre>
 * enum 클래스가 제공하는 메소드
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // name() : 상수값을 문자열로 반환. toString()과 비슷
        SubjectType type1 = SubjectType.JAVA;
        String type1name = type1.name();
        System.out.println(type1name); // JAVA

        // ordinal() : 상수가 선언된 순서(인덱스)
        System.out.println(SubjectType.JAVA.ordinal()); // 0
        System.out.println(SubjectType.MYSQL.ordinal()); // 1
        System.out.println(SubjectType.HTML.ordinal()); // 2

        // Enum.valueOf(name:String):Enum
        String subject = "JAVA";
        SubjectType java = SubjectType.valueOf(subject);
        System.out.println(java instanceof SubjectType); // Eum타입 true

        // 추가 메소드 선언 후 사용
        System.out.println(SubjectType.JAVA.toLowerCase()); // java
        System.out.println(SubjectType.MYSQL.toLowerCase()); // mysql
        System.out.println(SubjectType.HTML.toLowerCase()); // html
    }
}
