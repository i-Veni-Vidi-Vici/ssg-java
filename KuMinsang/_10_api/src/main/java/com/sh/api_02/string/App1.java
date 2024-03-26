package com.sh.api_02.string;

import org.w3c.dom.ls.LSOutput;

public class App1 {
    public static void main(String[] args) {


        String str1 = "java";
        String str2 = "java";
        String str3 = new String("java");
        String str4 = new String("java");

        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str3 == str4);

        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str1.equals(str1));

        System.out.println(str1.hashCode());//3254818
        System.out.println(str1.hashCode());//3254818
        System.out.println(str1.hashCode());//3254818
        System.out.println(str1.hashCode());//3254818

        //특정 문자열에 더하기 연산
        str2 += "ssg";
        System.out.println(str1 == str2);   //false
        System.out.println(str1.equals(str2));  //false
        System.out.println(str1.equals(str3));  //false


    }
}
