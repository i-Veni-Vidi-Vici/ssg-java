package com.sh.inheritance._04.override;

public class App {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method(100);
        subClass.finalMethod();
        subClass.protectedMethod(); // _04.override.SubClass 와 _04.override.other.App 패키지 다르고, 상속관계가 아니므로 접근이 불가능함
//        subClass.privateMethod(); privateMethod()' has private access in 'com.sh.inheritance._04.override.SuperClass'
    }
}
