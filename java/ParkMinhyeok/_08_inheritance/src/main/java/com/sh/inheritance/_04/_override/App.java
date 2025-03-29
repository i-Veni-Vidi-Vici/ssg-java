package com.sh.inheritance._04._override;

public class App {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method(100);
        subClass.finalMethod();
        subClass.protectedMethod();
//        subClass.privateMethod(); // 'privateMethod()' has private access in 'com.sh.inheritance._04._override.SuperClass'
    }
}
