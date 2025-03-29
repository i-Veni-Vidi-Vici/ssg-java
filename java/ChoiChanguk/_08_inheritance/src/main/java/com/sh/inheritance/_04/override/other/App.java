package com.sh.inheritance._04.override.other;

import com.sh.inheritance._04.override.SubClass;

public class App {
    public static void main(String[] args) {
        SubClass subClass=new SubClass();
        subClass.finalMethod();
        subClass.method(1);
//        subClass.privateMethod(); private라서 접근 안됨

        //패키지가 달라서 안된다+상속 관계가 안되면 오류가 난다
        //오버라이드 할 때 public으로 바꿔준다면 실행 된다
        //subClass.protectedMethod();


    }
}
