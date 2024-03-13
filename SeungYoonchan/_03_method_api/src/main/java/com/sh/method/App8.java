package com.sh.method;

public class App8 {
    public static void main(String[] args){
        // 같은 클래스인 경우 클래스명 생략 가능
        //test();
//        App8.test();

//        int sum = App8.sum(100, 30);
//        System.out.println(sum);

        // 다른 클래스 static 메소드
        System.out.println(Calculator.plus(50,20));
        System.out.println(Calculator.minus(50,20));
        System.out.println(Calculator.multiply(50,20));
        System.out.println(Calculator.divide(50,20));
        System.out.println(Calculator.mod(50,20));

        System.out.println();
        System.out.println();

        System.out.println(Foo.max(30,70)); // 70
        Bar bar = new Bar();
        System.out.println(bar.min(3, 40)); // 3
    }



    /**
     * static 메소드
     */

    public static void test(){
        System.out.println("👍👍👍");
    }
    public static int sum(int m, int n){
        return m + n;
    }
}
