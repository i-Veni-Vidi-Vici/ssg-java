package com.ssg.oop.method._static;

<<<<<<< HEAD
import jdk.dynalink.beans.StaticClass;

public class Run {
    public static void main(String[] args) {
        //1 toUpper메소드 호출시 "ssg academy"를 전달하면, "SSG ACADEMY"가 리턴
        //StaticMethod.toUpper("ssg academy");


        //2 setChar메소드 호출시  "java", 0, 'x'를 전달하고, "xava" 리턴


        //3 getAlphabetLength호출시 "안녕, 난 James야!" 전달하고, 5 리턴


        //4 concat 호출시 "hello", "world" 호출후 "helloworld" 리턴


=======
public class Run {
    public static void main(String[] args) {
        //1 toUpper메소드 호출시 "ssg academy"를 전달하면, "SSG ACADEMY"가 리턴
        StaticMethod.toUpper("ssg academy");

        //2 setChar메소드 호출시  "java", 0, 'x'를 전달하고, "xava" 리턴
        StaticMethod.setChar("java", 0, 'x');

        //3 getAlphabetLength호출시 "안녕, 난 James야!" 전달하고, 5 리턴

        //4 concat 호출시 "hello", "world" 호출후 "helloworld" 리턴
>>>>>>> bb92cf9fc765e01a87aea7fd5f84a1a37520c15b
    }
}
