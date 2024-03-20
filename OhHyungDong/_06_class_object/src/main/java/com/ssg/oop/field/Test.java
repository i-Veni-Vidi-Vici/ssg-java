package com.ssg.oop.field;

public class Test {
    int a = 100;
    static int s = 99;

    public static void main(String[] args) {
        Test t = new Test();
        t.test1();
        //this.a : t가 가리키는 객체 안에 있는 변수값 : a  -> 100 출력
        //Test.s : static 변수 s : 99출력

        t.test2();
        // t.a = 1000은 t 객체가 가지고 있는 변수 a값을 가리킨 것이고 출력하는 값은 전역변수인 a값이기 때문에 출력 : 100

        Test t3 = new Test();
        t.test3(t3);
        // t3객체 안에 있는 변수 a 값을 10으로 변경시킨 것이고 전역변수인 a값은 200으로 변경한 것이기 때문에
        // 출력 값 : 10

        System.out.println(t3.a);
        // t.test3(t3) 값에서 t3 객체 안에서 a값을 10으로 변경 해놨기 때문에 출력 값 : 10


        t.test4(t);
        //현재 t객체 안에 있는 멤버 변수 a 값을 변경한 값이 t.a = 1000이고
        // this.a는 this 현재 객체는 t이기 때문에 this.a랑 t.a랑 서로 같은 값을 가리키고 있는 것임  따라서 출력 값 : 1000

    }

    public void test1() {
        int a = 1000;
        int s = 999;
        System.out.println(this.a); 
        System.out.println(Test.s);
    }

    public void test2() {
        Test t = new Test();
        t.a = 1000; //t객체에 있는 변수 a 를 1000으로 설정
        System.out.println(a); //전역변수 a값 출력
    }

    public void test3(Test t) {
        t.a = 10;
        this.a = 200;
        System.out.println(t.a); //
    }

    public void test4(Test t) {
        t.a = 1000;
        System.out.println(this.a);
    }


}
