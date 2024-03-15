package com.sh.method;


/**
 * static 메소드 사용하기
 */
public class App8 {
    public static void main(String[] args) {
        //같은 클래스 static 메소드
        App8.test(); // italic 기울임 폰트
        int sum = App8.sum(100, 30);
        System.out.println(sum);
        //같은 클래스인 경우, 클래스 명은 생략 가능하다.
        test();
//        int sum = sum(100, 30);



        //다른 클래스 static 메소드
        System.out.println(Calculator.plus(5, 2));
        System.out.println(Calculator.minus(5, 2));
        System.out.println(Calculator.multiply(5, 2));
        System.out.println(Calculator.divide(5, 2));
        System.out.println(Calculator.mod(5, 2));


        //다음 메소드를 작성하세요.
        System.out.println(Foo.max(30, 70)); //70


        Bar bar = new Bar();
        System.out.println(bar.min(3, 40)); //3
    }



    /**
     * static 메소드
     */

    public static void test () {
        System.out.println("😍😚🐸");
    }

    public static int sum(int a, int b) {
        return a + b;
    }

}
