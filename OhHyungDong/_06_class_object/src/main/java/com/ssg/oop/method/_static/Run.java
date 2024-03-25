package com.ssg.oop.method._static;

public class Run {

    public static void main(String[] args) {


        // 소문자 -> 대문자로 리턴
        StaticMethod staticMethod = new StaticMethod("ssg academy");
        System.out.println( staticMethod.toUpper("ssg academy"));

        //java , 0 , x -> "xava"리턴
        System.out.println(staticMethod.setChar("java",0,'x'));

        //GetAlphabetLength -> "안녕, 난 james야 !" 5return
        System.out.println(staticMethod.getAlphabetLength("안녕, 난 James야!"));

        //concat 호출 -> hello, world -> helloworld 리턴
        System.out.println( staticMethod.concat("hello","world"));

    }
}
