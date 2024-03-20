package com.ssg.oop.field;

public class Test {
    int a = 100;
    static int s = 99;

    public static void main(String[] args) {
        Test t = new Test();
        t.test1();

        t.test2();

        Test t3 = new Test();
        t.test3(t3);
        System.out.println(t3.a);

        t.test4(t);

    }

    public void test1() {
        int a = 1000;
        int s = 999;
        System.out.println(this.a); // Test 필드에 있는 값이 대입
        System.out.println(Test.s); // s가 static 이기때문에 바로 접근이 가능하다
    }

    public void test2() {
        Test t = new Test();
        t.a = 1000;
        System.out.println(a); // 여기서 a는 Test필드에 있는 자료이고, 객체 t를 쓰고 싶다면 , t.a써야 한다
    }

    public void test3(Test t) {
        t.a = 10;// t객체의 a값
        this.a = 200;// test 필드에 있는 a
        System.out.println(t.a);//t 객체를 받았기 때문에 t객체의 값이 나온다
    }

    public void test4(Test t) {
        t.a = 1000;//객체 t의 a값이다
        System.out.println(this.a);// this까지 쓴 이유는 test필드에 있는 a값이다 여기서는 this.a와 a로 써도 같다
    }

}