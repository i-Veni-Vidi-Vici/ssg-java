package com.sh.inheritance._04.override.other;

import com.sh.inheritance._04.override.SubClass;

public class App {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
//        subClass.method(100); //같은 패키지가 아님 에러
        subClass.finalMethod();
//        subClass.protectedMethod(); //같은 패키지가 아님 에러
//        subClass.privateMethod();

    }

}