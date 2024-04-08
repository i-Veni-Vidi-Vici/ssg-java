package com.sh._enum._02.basics;

/**
 * <pre>
 * enum 클래스가 제공하는 메소드
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // name() : 상수값을 문자열로 반환, toSting() 과 비슷
        SubjectType type1=SubjectType.JAVA;
        String type1Name= type1.name();
        System.out.println(".name : "+type1Name); // JAVA 출력

        //ordinal() : 상수가 선언된 순서(인덱스)
        System.out.println("인덱스 : "+SubjectType.JAVA.ordinal());// 인덱스 0 출력
        System.out.println("인덱스 : "+SubjectType.HTML.ordinal());// 인덱스 2 출력
        System.out.println("인덱스 : "+SubjectType.MYSQL.ordinal());// 인덱스 1 출력

        //Enum.valueOf(name:String):Enum
        String subject="JAVA";
        SubjectType java = SubjectType.valueOf(subject);
        System.out.println(".valueOf : "+java); //JAVA 출력
        System.out.println("instanceof : "+(java instanceof SubjectType)); // true

        //추가 메소드를 선언 후 사용
        System.out.println("메소드를 선언 후 필드를 사용할 수 있다(toLowerCase) : "+SubjectType.JAVA.toLowerCase());
        System.out.println("메소드를 선언 후 필드를 사용할 수 있다(toLowerCase) : "+SubjectType.MYSQL.toLowerCase());
        System.out.println("메소드를 선언 후 필드를 사용할 수 있다(toLowerCase) : "+SubjectType.HTML.toLowerCase());
    }
}
