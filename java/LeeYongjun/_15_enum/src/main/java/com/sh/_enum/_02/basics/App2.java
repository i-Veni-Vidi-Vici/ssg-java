package com.sh._enum._02.basics;

/**
 * <pre>
 * enum 클래스가 제공하는 메소드
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // name() : 상수값을 문자열로 변환. toString()과 비슷
        SubjectType type1 = SubjectType.JAVA;
        String type1Name = type1.name();
        System.out.println(type1Name);

        // ordinal() : 상수가 선언된 순서
        System.out.println(SubjectType.JAVA.ordinal());
        System.out.println(SubjectType.MYSQL.ordinal());
        System.out.println(SubjectType.HTML.ordinal());

        // Enum.valueOf(name:String):Enum
        String subject = "JAVA";
        SubjectType java = SubjectType.valueOf(subject);
        System.out.println(java instanceof SubjectType); // true

        // 추가 메소드를 선언 후 사용
        System.out.println(SubjectType.HTML.toLowercase()); //html
        System.out.println(SubjectType.MYSQL.toLowercase()); //mysql
        System.out.println(SubjectType.JAVA.toLowercase()); //java
    }
}
