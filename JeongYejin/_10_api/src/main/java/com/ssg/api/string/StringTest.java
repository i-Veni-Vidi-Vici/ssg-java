package com.ssg.api.string;

public class StringTest {
    public static void main(String[] args) {
        StringProcess sp = new StringProcess();
//        String result = sp.preChar("hello world");
        String result = sp.preChar2("hello world");
        System.out.println(result);

        int num = sp.charSu("application car cable", 'c');
        System.out.println(num);
    }
}
