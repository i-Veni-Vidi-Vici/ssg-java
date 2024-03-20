package com.ssg.oop.field;

public class Test {
    int a = 100;
    static int s = 99;

    public static void main(String[] args) {
        Test t = new Test();
        t.test1(); // 100, 99 출력

        t.test2();

        Test t3 = new Test();
        t.test3(t3);
        System.out.println(t3.a);


        t.test4(t);

    }

    public void test1() {
        int a = 1000;
        int s = 999;
        System.out.println(this.a); //100
        System.out.println(Test.s); // static int s = 99
    }

    public void test2() {
        Test t = new Test();
        t.a = 1000; //t객체에 있는 변수 a 를 1000으로 설정
        System.out.println(a); //전역변수 a값 출력
    }

    public void test3(Test t) {
        t.a = 10;
        this.a = 200;
        System.out.println(t.a); // 10 참조값을 바꿧기 때문에 t.a = 10
    }

    public void test4(Test t) {
        t.a = 1000;
        System.out.println(this.a);
    }

}
