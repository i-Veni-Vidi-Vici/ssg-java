package com.sh.method;

/**
 * static 메소드 사용하기
 * static 키워드를 가진 메소드
 * 객체 생성 없이 클래스 명으로 호출가능
 * static 메소드 안에서는
 */
public class App8 {
    public static void main(String[] args){
        // 같은 클래스 static 메소드
        App8.test();

       int sum = App8.sum(100, 30);
        System.out.println(sum);
        // 같은 클래스인 경우 클래스명을 생략 가능함.
        // test();
         int sum2 = sum(100, 30);

         // non- static 기본폰트
         App8 app = new App8();
         app.hello();

        // 다른클래스 static 메소드
        System.out.println(Calculator.plus(50, 20));
        System.out.println(Calculator.minus(50, 20));
        System.out.println(Calculator.multiply(50, 20));
        System.out.println(Calculator.divide(50, 20));
        System.out.println(Calculator.mod(50, 20));


        // 다음 메소드를 작성하세요
        System.out.println(Foo.max(30,70));//70

        Bar bar = new Bar();
        System.out.println(bar. min(3,40));//3
    }

    public void hello(){

    }
    /**
     * static 메소드
     */
    public static void test(){
        System.out.println("아아아");
    }
    public static int sum(int m , int n){
        return m + n;
    }

}
