package com.sh.inheritance._04.override;

import org.ietf.jgss.GSSContext;

public class App {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method(100);
        subClass.finalMethod();
        subClass.protectedMethod();
        subClass.finalMethod();
//        subClass.privateMethod();// 'privateMethod()' has private access in 'com.sh.inheritance._04.override.SuperClass'

    }
}
