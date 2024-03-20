package com.ssg.oop.mehtod._static;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        String str;
        int n;
        str=StaticMethod.toUpper("ssg academy");
        System.out.println("대문자 출력 : "+str);

        str=StaticMethod.setChar("java",0,'x');
        System.out.println(str);

        n=StaticMethod.getAlphabetLenght("안녕, 난 James야!");
        System.out.printf("알바벳 수 = %d\n",n);



        str=StaticMethod.concat("hello"," +Helloworld");
        System.out.println("결합 : "+str);
    }
}
