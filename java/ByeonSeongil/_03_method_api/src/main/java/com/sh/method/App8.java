package com.sh.method;
/**
 *<pre>
 * static 메서드 사용하기
 * - static키워드를 가진 메서드
 * - 객체 생성 없이 클래스 명으로 호출가능
 *</pre>
 */
public class App8 {
    public static void main(String[] args) {
        App8.test();

        int sum = App8.sum(100, 30);
        System.out.println(sum);

        //같은 클래스인 경우 클래스명을 생략가능
        test(); //이텔리체


        App8 app8 = new App8();
        app8.hello(); // 비 static 메서드

        // 다른 클래스 static 메서드
        System.out.println(Calculator.plus(50,20));
        System.out.println(Calculator.minus(50,20));
        System.out.println(Calculator.multiply(50,20));
        System.out.println(Calculator.devide(50,20));
        System.out.println(Calculator.mod(50,20));

        // 다음 메서드를 작성
        System.out.println(Foo.max(30, 70));

         Bar bar = new Bar();
        System.out.println(bar.min(3,40));
    }

    public void hello() {

    }

    /**
     * static 메서드
     */
    public static void test() {
        System.out.println("😊😊😊");
    }

    public static int sum(int v1, int v2) {
        return v1 + v2;
    }
}
