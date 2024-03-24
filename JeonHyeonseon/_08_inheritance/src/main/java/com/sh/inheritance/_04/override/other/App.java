package com.sh.inheritance._04.override.other;

import com.sh.inheritance._04.override.SubClass;

public class App {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method(100);
        subClass.finalMethod();
        subClass.protectedMethod(); // protrcted인 경우 _04.ovverride.SubClass와 _04.ovverride.other.App 패키지가 다르고 상속관계 아니므로 접근
//        subClass.privateMethod(); // 'privateMethod()' has private access in 'com.sh.inheritance._04.override.SuperClass'


    }
}
