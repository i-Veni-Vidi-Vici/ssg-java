package com.ssg.oop.field;

public class Test {
    int a = 100;
    static int s = 99;

    public static void main(String[] args) {
        Test t = new Test();
        t.test1();
        /**
         * 100
         * 99
         */

        t.test2();
        /** 틀렸다 (1000 <- t.a)
         * 100
         */

        Test t3 = new Test();
        t.test3(t3);
        /**
         * 10
         */
        System.out.println(t3.a);
        /** 틀렸다 (200)
         * 10
         * 위에서 t3.a == 10이므로 여기서도 10
         */


        t.test4(t);
        /** 틀렸다 (100)
         * 1000
         * test4 안에 매개인자 Test 객체인 t를 넣었으므로 t.a와 this.a는 같다
         */

    }

    public void test1() {
        int a = 1000;
        int s = 999;
        System.out.println(this.a);
        System.out.println(Test.s);
    }

    public void test2() {
        Test t = new Test();
        t.a = 1000;
        System.out.println(a);
    }

    public void test3(Test t) {
        t.a = 10;
        this.a = 200;
        System.out.println(t.a);
    }

    public void test4(Test t) {
        t.a = 1000;
        System.out.println(this.a);
    }

}