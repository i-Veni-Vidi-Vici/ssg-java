package com.sh.method;

public class App8 {
    public static void main(String[] args) {
        // 같은 클래스 static 메소드
        App8.test(); // italic 기울임 폰트

        int sum = App8.sum(100, 30);
        System.out.println(sum);
        // 같은 클래스인 경우 클래스명을 생략가능하다.
//        test();
//        int sum2 = sum(100, 30);

        //non-static 기본 폰트
        App8 app = new App8();
        app.hello("hello");

        // 다른 클래스 static 메소드
        System.out.println(Calculator.plus(50, 20));
        System.out.println(Calculator.minus(50, 20));
        System.out.println(Calculator.multiply(50, 20));
        System.out.println(Calculator.divide(50, 20));
        System.out.println(Calculator.mod(50, 20));

        // 다음 메소드를 작성하세요.
        System.out.println(Foo.max(30, 70));

        Bar bar = new Bar();
        System.out.println(bar.min(3, 40));
    }
    public static void test() {
        System.out.println("🐶🐶🐶");
    }

    public static int sum(int m, int n) {
        return m + n;
    }

    public void hello(String str) {
        System.out.println(str);
    }
}
