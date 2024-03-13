package com.sh.method;

/**
 * static 메소드 사용하기
 * - static 키워드를 가진 메소드
 * - 캑체 생성 없이 클래스명으로 호출 가능
 * - static 메소드 안에서는 static 메소드만 호출 가능하다.
 */
public class App8 {
    public static void main(String[] args) {
        App8.test();
        int sum = App8.plus(100, 30);
        System.out.println(sum);

        // 다른 클래스 static 메소드
        System.out.println(Calculator.plus(50, 20));
        System.out.println(Calculator.minus(50, 20));
        System.out.println(Calculator.multiply(50, 20));
        System.out.println(Calculator.divide(50, 20));
        System.out.println(Calculator.mod(50, 20));

        // 다음 메소드를 작성하세요.
        System.out.println(Foo.max(30, 70)); // 70
        Bar bar = new Bar();
        System.out.println(bar.min(3, 40)); // 3
        // static 메소드를 non-static 방식으로 호출은 가능하지만, 자제하자
    }

    public static void test() {
        System.out.println("ddd");
    }

    public static int plus(int a, int b) {
        return a + b;
    }
}
