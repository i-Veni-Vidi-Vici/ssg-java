package com.sh.api._02.string;

public class App1 {
    public static void main(String[] args) {
        String str1 = "java";
        String str2 = "java";
        String str3 = new String("java");
        String str4 = new String("java");

        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str3.equals(str4));

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str4.hashCode());

        str2 += "ssg";
        System.out.println(str1.equals(str2));
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
    }
}
