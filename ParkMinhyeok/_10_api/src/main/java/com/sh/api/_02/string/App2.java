package com.sh.api._02.string;

public class App2 {
    public static void main(String[] args) {
        // charAt(int):char 특정인덱스 문자반환
//        String str = "apple";
//        for (int i = 0; i < str.length(); i++) {
//            System.out.println("charAt(" + i + ") :" + str.charAt(i));
//        }
//        System.out.println();

        // compareTo(String) : 문자열을 비교한 결과값을 정수로 반환
        // - 0 : 같은 경우
        // - 음수 : 문자열이 작은경우 (사전에서 앞에 나오는 경우)
        // - 양수 : 문자열이 큰경우 (사전에서 뒤에 나오는 경우)
        String txt1 = "java";
        String txt2 = "java";
        String txt3 = "JAVA";
        String txt4 = "ssg";

        System.out.println(txt1.compareTo(txt2)); // 0
        System.out.println(txt2.compareTo(txt3)); // 32
        System.out.println(txt3.compareTo(txt2)); // -32
        System.out.println(txt2.compareTo(txt4)); // -9

        String abc = "abcdefg";
        String newAbc = abc.substring(2, 5);
        System.out.println(newAbc);

        String word = "I hate you";
        System.out.println(word.replace("hate", "love"));

        String test = " ";
        System.out.println(test.isEmpty());

        String hello = "hello world";
        System.out.println(hello.indexOf("world"));
    }
}
