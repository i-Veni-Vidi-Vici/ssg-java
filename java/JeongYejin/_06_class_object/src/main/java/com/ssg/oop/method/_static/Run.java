package com.ssg.oop.method._static;

import static com.ssg.oop.method._static.StaticMethod.*;

public class Run {
    public static void main(String[] args) {
        System.out.println(toUpper("hi y"));
        System.out.println(setChar("java", 0, 'x'));
        System.out.println(getAlphabetLength("안녕, 난 James야!"));
        System.out.println(concat("hello", "world"));
    }
}
