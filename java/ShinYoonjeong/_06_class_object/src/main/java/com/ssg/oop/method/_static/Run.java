package com.ssg.oop.method._static;

public class Run {
    public static void main(String[] args) {
        String toUpper = StaticMethod.toUpper("ssg academy");
        String setChar = StaticMethod.setChar("java", 0, 'x');
        int getAlphabetLength = StaticMethod.getAlphabetLength("안녕, 난 James야!");
        String concat = StaticMethod.concat("hello", "world");
        System.out.println("toUpper 결과: " + toUpper);
        System.out.println("setChar 결과: " + setChar);
        System.out.println("getAlphabetLength 결과: " + getAlphabetLength);
        System.out.println("concat 결과: " + concat);
    }
}
