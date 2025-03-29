package com.sh.inheritance._04.override.other;

import com.sh.inheritance._04.override.SubClass;

public class App {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method(1);
        subClass.finalMethod();
        subClass.protectedMethod();
        // _04.override.SubClass와 _0.4.override.other.App 패키지
        // subClass.privateMethod(); // privateMethod() has private acess

    }
}

