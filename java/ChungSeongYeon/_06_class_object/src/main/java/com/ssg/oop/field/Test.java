package com.ssg.oop.field;

public class Test {
    int a = 100; // 인스턴스 변수 a를 100으로 초기화
    static int s = 99; // 정적 변수 s를 99로 초기화

    public static void main(String[] args) {
        Test t = new Test(); // Test 클래스의 인스턴스 t 생성
        t.test1(); // test1 메서드 호출 -> 출력: 100, 99

        t.test2(); // test2 메서드 호출 -> 출력: 100

        Test t3 = new Test(); // 새로운 Test 인스턴스 t3 생성
        t.test3(t3); // test3 메서드 호출, t3 인스턴스 전달 -> 출력: 10
        System.out.println(t3.a); // t3의 인스턴스 변수 a 출력 -> 출력: 10


        t.test4(t); // test4 메서드 호출, t 인스턴스 전달 -> 출력: 1000

    }

    public void test1() {
        int a = 1000; // 지역 변수 a를 1000으로 초기화
        int s = 999; // 지역 변수 s를 999로 초기화
        System.out.println(this.a); // 현재 객체의 인스턴스 변수 a 출력 -> 출력: 100
        System.out.println(Test.s); // Test 클래스의 정적 변수 s 출력 -> 출력: 99
    }

    public void test2() {
        Test t = new Test(); // 새로운 Test 인스턴스 t 생성
        t.a = 1000; // t의 인스턴스 변수 a 값을 1000으로 변경
        System.out.println(a); // 현재 객체의 인스턴스 변수 a 출력 -> 출력: 100
    }

    public void test3(Test t) {
        t.a = 10; // 전달된 t 인스턴스의 인스턴스 변수 a 값을 10으로 변경
        this.a = 200; // 현재 객체의 인스턴스 변수 a 값을 200으로 변경
        System.out.println(t.a); // 전달된 t 인스턴스의 인스턴스 변수 a 출력 -> 출력: 10
    }

    public void test4(Test t) {
        t.a = 1000; // 전달된 t 인스턴스의 인스턴스 변수 a 값을 1000으로 변경
        System.out.println(this.a); // 현재 객체의 인스턴스 변수 a 출력 -> 출력: 1000
    }

}
