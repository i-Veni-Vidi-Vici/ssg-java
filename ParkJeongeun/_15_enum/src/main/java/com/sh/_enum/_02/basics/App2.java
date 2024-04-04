package com.sh._enum._02.basics;

/**
 * <pre>
 * enum 클래스가 제공하는 메소드
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // name() : 상수값을 문자열로 반환, toString()과 비슷
        SubjectType type1 = SubjectType.JAVA;
        String type1Name = type1.name();
        System.out.println(type1Name);

        // ordinal() : 상수가 선언된 순서(인덱스 반환)
        // 주의!) SubjectType 클래스에서 순서바꾸면 인덱스값도 바뀜
        System.out.println(SubjectType.JAVA.ordinal()); // 0
        System.out.println(SubjectType.MYSQL.ordinal()); // 1

        // Enum.valueOf(name:String):Enum
        // Scanner에서 입력값 받아서 enum으로 바꿀때 사용가능
        String subject = "JAVA";
        SubjectType java = SubjectType.valueOf(subject);
        System.out.println(java instanceof SubjectType); // true

        // 추가 메소드를 선언 후 사용 가능
        System.out.println(SubjectType.HTML.toLowerCase()); // html
    }
}
