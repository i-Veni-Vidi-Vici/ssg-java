package com.sh.method;

/**
 * static 메소드 사용하기
 * static 키워드랄 가진 메소드
 * 객체 생성 없이 클래스 명으로 호출가능
 */
public class App8 {
    public static void main(String[] args){
        App8.test();
        int sum = App8.sum(100,30);
        //다른 클래스 static메소드
        System.out.println(Calculator.plus(50,20));
        System.out.println(Calculator.minus(50,20));
        System.out.println(Calculator.multiply(50,20));
        System.out.println(Calculator.divide(50,20));
        System.out.println(Calculator.mod(50,20));
        //같은 클래스인 경우 클래스명을 생략가능하다.
        test();
        //int sum=sum(100,30);
        System.out.println(Foo.max(30,70));
        Bar bar = new Bar();
        System.out.println(bar.min(3,40));
    }


    public static void test(){
        System.out.println("ddd");
    }
    public static int sum(int a,int b){
        return a+b;

    }
}
