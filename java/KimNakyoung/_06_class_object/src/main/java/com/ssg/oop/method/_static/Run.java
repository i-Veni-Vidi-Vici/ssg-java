package com.ssg.oop.method._static;

/**
 *
 * 실행 클래스
 */
public class Run {
    public static void main(String[] args) {
        //1 toUpper메소드 호출시 "ssg academy"를 전달하면, "SSG ACADEMY"가 리턴
        StaticMethod staticMethod = new StaticMethod();
//        staticMethod.toUpper("ssg academy");

        //2 setChar메소드 호출시  "java", 0, 'x'를 전달하고, "xava" 리턴
        StaticMethod staticMethod1 = new StaticMethod();
//        staticMethod1.setChar("java",0,'x');

        //3 getAlphabetLength호출시 "안녕, 난 James야!" 전달하고, 5 리턴
        StaticMethod staticMethod2 = new StaticMethod();
//        staticMethod2.getAlphabetLength("안녕, 난 James야!");

        //4 concat 호출시 "hello", "world" 호출후 "helloworld" 리턴
        StaticMethod staticMethod3 = new StaticMethod();
        staticMethod3.concat("hello","World");
    }
}
