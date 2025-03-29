package com.ssg.oop.method._static;

public class Run {
    public static void main(String[] args) {
        StaticMethod staticMethod = new StaticMethod();
        System.out.println(staticMethod.toUpper("ssg academy"));

        System.out.println(staticMethod.setChar("java", 0, 'x'));
        System.out.println(staticMethod.getAlphabetLength("안녕, 난 James야!"));
        System.out.println(staticMethod.concat("hello", "world"));
    }
}
