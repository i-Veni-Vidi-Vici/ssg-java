package com.sh.inheritance._04.override;

public class App {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method(100);
        subClass.finalMethod();
        subClass.protectedMethod();
//        subClass.privateMethod(); // 접근제한자가 private 여서 접근 불가
    }
}
