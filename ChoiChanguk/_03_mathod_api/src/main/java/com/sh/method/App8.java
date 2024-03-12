package com.sh.method;

/**
 * <pre>
 * static 메소드 사용하기
 * - static 키워드를 가진 메소드
 * - 객체 생성 없이 클래스 명으로 호출할 수 있음
 * - static 메소드 안에서는 static 메소드만 호출 가능하다
 * </pre>
 */
public class App8 {

    public static void main(String[] args) {
        // 같은 클래스 static메소드

        int sum1;
        // static, 합을 구한다
        //같은 클래스 같은 경우 클래스명 생략 가능
        //메소드 이름이 기울어져 있다 = static 클래스다
        //기본 폰트 = non-static
        sum1=sum(100,30);
        //sum = sum(a,b);
        System.out.println(sum1);

        //다른 클래스 static 메소드
        System.out.println(Calculator.plus(50,20));
        System.out.println(Calculator.minus(50,20));
        System.out.println(Calculator.multiply(50,20));
        System.out.println(Calculator.divide(50,20));
        System.out.println(Calculator.mod(50,20));

        //다음 메소드를 작성하세요.
        System.out.println(Foo.max(30,70));//70

        Bar bar = new Bar();
        System.out.println(bar.min(3,40));//3
    }

    public static int sum(int a, int b) {
        return a+b;
    }


    /**
     * static메소드
     */
    public static void test() {
        System.out.println("😁😁😁");
    }
}
