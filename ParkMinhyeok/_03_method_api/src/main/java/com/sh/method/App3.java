package com.sh.method;

/**
 * 매개변수 Parameter
 */
public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();
        String id = "홍길동";
        int age = 33;
        app.printUserNameAndAge(id, age);

        id = "신사임당";
        age = 45;
        app.printUserNameAndAge(id, age);

        // 매개인자와 매개변수의 타입은 일치해야 한다.
        byte bnum = 100;
        app.test(bnum); // int n = bnum; int = byte -> int = int

        long lnum = 1L;
        app.test((int) lnum); // long -> int 자동형 변환 되지 않으므로, 명시적으로 형변환 처리
    }
    public void printUserNameAndAge(String id, int age) {
        System.out.println("이름은 " + id + "입니다.");
        System.out.println("나이는 " + age + "입니다.");
    }
    public void test(int n) {
        System.out.println(n);
    }
}
