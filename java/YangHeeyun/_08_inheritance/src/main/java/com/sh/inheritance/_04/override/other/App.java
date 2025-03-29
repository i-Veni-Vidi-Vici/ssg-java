package com.sh.inheritance._04.override.other;

import com.sh.inheritance._04.override.SubClass;

public class App {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method(100);
        subClass.finalMethod();
        subClass.protectedMethod(); // protected인 경우 _04.override.SubClass와 _04.override.other.App 패키지 다르고, 상속관계 아니므로 접근 불가
//      subClass.privateMethod(); 'privateMethod()' has private access in 'com.sh.inheritance._04.override.SuperClass
    }
}
