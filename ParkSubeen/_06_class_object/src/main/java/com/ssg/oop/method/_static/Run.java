package com.ssg.oop.method._static;

public class Run {
    public static void main(String[] args) {
        //1 toUpper메소드 호출시 "ssg academy"를 전달하면, "SSG ACADEMY"가 리턴
//        StaticMethod staticMethod1 = new StaticMethod();
//        String toUpperMethod = staticMethod1.toUpper("ssg academy");
//        System.out.println(toUpperMethod);
        System.out.println(StaticMethod.toUpper("ssg academy"));

        //2 setChar메소드 호출시  "java", 0, 'x'를 전달하고, "xava" 리턴
//        StaticMethod staticMethod2 = new StaticMethod();
//        String setCharMethod = staticMethod2.setChar("java", 0, 'x');
//        System.out.println(setCharMethod);
        System.out.println(StaticMethod.setChar("java", 0, 'x'));

        //3 getAlphabetLength호출시 "안녕, 난 James야!" 전달하고, 5 리턴
//        StaticMethod staticMethod3 = new StaticMethod();
//        int cnt = staticMethod3.getAlphabetLength("안녕, 난 James야!");
//        System.out.println(cnt);
        System.out.println(StaticMethod.getAlphabetLength("안녕, 난 James야!"));

        //4 concat 호출시 "hello", "world" 호출후 "helloworld" 리턴
//        StaticMethod staticMethod4 = new StaticMethod();
//        String concatValue = staticMethod4.concat("hello", "world");
//        System.out.println(concatValue);
        System.out.println(StaticMethod.concat("hello", "world"));

    }
}
