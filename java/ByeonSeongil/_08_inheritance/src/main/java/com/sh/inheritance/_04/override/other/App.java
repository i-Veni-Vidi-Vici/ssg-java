package com.sh.inheritance._04.override.other;

import com.sh.inheritance._04.override.SubClass;

public class App {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method(100);
        subClass.finalMethod();
//        subClass.protectedMethod(); // Subclass와 App 클래스가 패키지가 서로 다르고,  상속관계가 아님
//        subClass.privateMethod();
    }
}
