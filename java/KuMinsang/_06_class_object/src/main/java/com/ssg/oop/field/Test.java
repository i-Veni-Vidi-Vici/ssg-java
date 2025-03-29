package com.ssg.oop.field;

public class Test {
    int a = 100;
    static int s = 99;

    public static void main(String[] args) {
        Test t = new Test();

        t.test1(); //100 99
        t.test2(); //호출한 객체 t의 a는 100

        Test t3 = new Test();
        t.test3(t3);    //10
        System.out.println(t3.a);   //10


        t.test4(t);//1000

    }

    public void test1() {
        int a = 1000;   //현재 메소드의 지역변수 a에 1000할당
        int s = 999;    //현재 메소드의 s
        System.out.println(this.a); //객체의 a = 100
        System.out.println(Test.s); //static s = 99
    }

    public void test2() {
        Test t = new Test();    //새로운 객체 t 생성
        t.a = 1000; //새로운 객체 t.a에 1000 할당
        System.out.println(a);  //호출한 객체의 a를 출력
    }

    public void test3(Test t) {
        t.a = 10;   //매개인자 t.a 값 변경
        this.a = 200;   //호출한 객체의 a를 200으로 변경
        System.out.println(t.a);    //매개인자 t의 a값 호출
    }

    public void test4(Test t) {
        t.a = 1000;
        System.out.println(this.a);
    }
}
