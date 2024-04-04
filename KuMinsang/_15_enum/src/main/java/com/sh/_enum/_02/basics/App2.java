package com.sh._enum._02.basics;

/**
 * <pre>
 *
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        //name():상수 값을
        SubjectType type1 = SubjectType.JAVA;
        String type1Name = type1.name();
        System.out.println(type1Name);

        //ordinal() 상수가 선언된 순서(인덱스)
        System.out.println(SubjectType.JAVA.ordinal());//0
        System.out.println(SubjectType.MYSQL.ordinal());//1
        System.out.println(SubjectType.HTML.ordinal());//2

//        Enum.valueOf(name:String):Enum
        String subject = "JAVA";
        SubjectType java = SubjectType.valueOf(subject);
        System.out.println(java instanceof SubjectType);    //true

        System.out.println(java);
        System.out.println(java.toLowerCase());
    }
}
