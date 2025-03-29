package com.sh._enum._02.basics;

/**
 * <pre>
 * enum 클래스가 제공하는 메소드
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        SubjectType type1 = SubjectType.JAVA;
        String type1Name = type1.name();
        System.out.println(type1Name);

        // ordinal() : SubjectType 내에 상수가 선언된 순서(인덱스)
        System.out.println(SubjectType.JAVA.ordinal());
        System.out.println(SubjectType.MYSQL.ordinal());
        System.out.println(SubjectType.HTML.ordinal());
        // SubjectType 내에서 순서가 변경될 수 있기 때문에 ordinal() 사용시 주의한다

        // Enum.valueOf(name:String):Enum
        String subject = "JAVA";
        SubjectType java = SubjectType.valueOf(subject);
        System.out.println(java instanceof SubjectType); // true
        // String자바가 아니라 enum타입

        // 추가 메소드를 선언 후 사용
        System.out.println(SubjectType.HTML.toLowerCase());
        System.out.println(SubjectType.JAVA.toLowerCase());
        System.out.println(SubjectType.MYSQL.toLowerCase());
    }
}
