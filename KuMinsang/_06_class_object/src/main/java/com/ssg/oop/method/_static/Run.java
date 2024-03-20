package com.ssg.oop.method._static;

public class Run {
    public static void main(String[] args) {
        //1 toUpper메소드 호출시 "ssg academy"를 전달하면, "SSG ACADEMY"가 리턴
        String str1 = StaticMethod.toUpper("ssg academy");
        System.out.println(str1);

        //2 setChar메소드 호출시  "java", 0, 'x'를 전달하고, "xava" 리턴
        String str2 = StaticMethod.setChar("java",0,'x');
        System.out.println(str2);

        //3 getAlphabetLength호출시 "안녕, 난 James야!" 전달하고, 5 리턴
        int k = StaticMethod.getAlphabetLength("안녕, 난 James야");
        System.out.println(k);

        //4 concat 호출시 "hello", "world" 호출후 "helloworld" 리턴
        System.out.println(StaticMethod.concat("hello", "world"));
    }
}
