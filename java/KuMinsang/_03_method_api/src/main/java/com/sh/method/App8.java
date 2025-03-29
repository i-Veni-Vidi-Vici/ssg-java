package com.sh.method;

import java.util.prefs.BackingStoreException;

/**
 * <pre>
 *     static메소드 사용하기
 *     -static 키워드를 가진 메소드
 *     -객체 생성 없이 클래스 명으로 호출가능
 *     -static메소드 안에서는 static 메소드만 호출 가능하다
 *
 * </pre>
 */
public class App8 {
    public static void main(String[] args) {

        //같은 클래스의 static 메소드
        App8.test();
        int sum = App8.sum(100,30);
        System.out.println(sum);
        //같은 클래스인 경우 클래스명 생략가능
        System.out.println(sum(50,30));

        System.out.println("Calculator클래스 정적 호출");
        System.out.println(Calculator.plus(50,20));
        System.out.println(Calculator.minus(50,20));
        System.out.println(Calculator.multiply(50,20));
        System.out.println(Calculator.divide(50,20));
        System.out.println(Calculator.mod(50,20));

        System.out.println(Foo.max(30,70)); //70
        Bar bar = new Bar();
        System.out.println(bar.min(3,40));

    }

    /**
     * static 메소드
     */
    public static void test(){
        System.out.println("1.2.3.4");
    }

    public static int sum(int a, int b) {
        return a + b;
    }
}
