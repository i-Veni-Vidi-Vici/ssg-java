package com.sh.inheritance._04.override.other;

import com.sh.inheritance._04.override.SubClass;

public class App {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method(100);
        subClass.finalMethod();
        // protected는 패키지가 다르고 상속관계가 아니면 오버라이드 불가
        // subClass에서 protected -> public으로 변경하면 가능
        subClass.protectedMethod();
//        subClass.privateMethod(); // private은 안됨
    }
}
