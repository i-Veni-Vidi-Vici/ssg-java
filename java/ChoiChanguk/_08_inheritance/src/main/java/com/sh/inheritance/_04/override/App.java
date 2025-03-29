package com.sh.inheritance._04.override;

public class App {
    public static void main(String[] args) {
        SubClass subClass=new SubClass();
        subClass.finalMethod();
        subClass.method(1);
//        subClass.privateMethod(); private라서 접근 안됨
        subClass.protectedMethod();

    }
}
