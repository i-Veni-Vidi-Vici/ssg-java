package com.sh.method;


/**
 * static메소드
 * -static 키워드를 가진 메소드
 * -객체 생성 없이 클래스 명으로 호출가능
 * -static 메소드 안에서는 static 메소드만 호출 가능
 *
 */
public class App8 {
    public static void main(String[] args) {
        App8.test();
        int sum = App8.sum(100,30);
        //같은 클래스 내에선 클래스명 생략가능
        test();

        System.out.println(Calculator.plus(50,20));
        System.out.println(Calculator.diff(50,20));
        System.out.println(Calculator.product(50,20));
        System.out.println(Calculator.quotient(50,20));
        System.out.println(Calculator.mod(50,20));

        System.out.println(Foo.max(30,70));
        Bar bar = new Bar();
        System.out.println(bar.min(3,40));
    }
    public static void test(){
        System.out.println("Hello");
    }
    public static int sum(int a, int b){return a+b;}


}
