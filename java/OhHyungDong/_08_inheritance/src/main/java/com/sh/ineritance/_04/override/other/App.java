package com.sh.ineritance._04.override.other;

import com.sh.ineritance._04.override.SubClass;

/**
 *
 */
public class App {

    public static void main(String[] args)
    {
        SubClass subClass = new SubClass();
        subClass.method(100);
        subClass.finalMethod();
        //subClass.protectedMethod();
        //protected에서 subClass와 패키지가 다르고, 상속관계가 아니므로 접근이 불가능하다.
        //SubClass에서 오버라이드 할 때 protected가 아닌 public으로 바꾸면 접근이 가능하다.

    }
}
