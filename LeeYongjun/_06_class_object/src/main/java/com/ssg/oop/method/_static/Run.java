package com.ssg.oop.method._static;

public class Run {
    public static void main(String[] args) {
        StaticMethod staticMethod = new StaticMethod();
        String upper = staticMethod.toUpper("ssg academy");
        System.out.println(upper);

        String original = "java";
        String setChar = staticMethod.setChar(original,0,'x');
        System.out.println(setChar);

        String str = "안녕, 난 James야!";
        int count = staticMethod.getLength(str);
        System.out.println(count);

        String str1 = "hello";
        String str2 = "world";
        String concat = staticMethod.Concat(str1,str2);
        System.out.println(concat);

    }
}
