package com.sh._enum._02.basics;

/**
 * <pre>
 * enum 클래스가 제공하는 메서드
 *
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // name(): 상수값을 문자열로 반환, toString()과 비슷
        SubjectType type1 = SubjectType.JAVA;
        String type1Name = type1.name();
        System.out.println(type1Name);

        // ordinal() : 상수가 선언된 순서(인덱스)
        System.out.println(SubjectType.JAVA.ordinal());
        System.out.println(SubjectType.MYSQL.ordinal());
        System.out.println(SubjectType.HTML.ordinal());

        // Enum.valueOf(name:String):Enum
        String subject = "JAVA";
        SubjectType java = SubjectType.valueOf(subject);
        System.out.println(java instanceof SubjectType);

        // 추가 메서드를 선언후 사용
        System.out.println(SubjectType.HTML.toLowerCase());
        System.out.println(SubjectType.JAVA.toLowerCase());
        System.out.println(SubjectType.MYSQL.toLowerCase());

    }
}
