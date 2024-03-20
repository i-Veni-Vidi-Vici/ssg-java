package com.ssg.oop.mehtod._static;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        String str;
        str=StaticMethod.toUpper("ssg academy");
        System.out.println(str);

        str=StaticMethod.setChar("java",0,'x');
        //System.out.println(str);


        str=StaticMethod.concat("hello","+helloworld");
        System.out.println(str);
    }
}
