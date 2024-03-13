package com.sh.method;

/**
 * <pre>
 * static 메소드 사용하기
 * - static키워드를 가진 메소드
 * - 객체 생성 없이 클래스 명으로 호출가능
 * - static메소드 안에서는 static메소드만 호출가능하다.
 * </pre>
 */
public class App8 {
    public static void main(String[] args) {
        // 같은 클래스 static메소드
        App8.test(); // italic 기울임 폰트
        int sum = App8.sum(100,30);
        System.out.println(sum);
        System.out.println();
        // 같은 클래스인 경우 클래스명 생략가능하다.
        test();
        int sum2 = sum(100,30);
        //non-static 기본포트
        App8 app = new App8();
        app.hello();
        // 다른클래스 static메소드
        System.out.println(Calculator.plus(50,20));
        System.out.println(Calculator.minus(50,20));
        System.out.println(Calculator.multifly(50,20));
        System.out.println(Calculator.divide(50,20));
        System.out.println(Calculator.mod(50,20));

        // 다음 메소드를 작성하세요.
        System.out.println(Foo.max(30,70)); //70

        Bar bar = new Bar();
        System.out.println(bar.min(3,40)); //3
        //static메소드를 non-static방슥으로 호출은 가능하지만, 자제하자
    }
    public void hello(){

    }

    /**
     * static메소드
     */
    public static void test(){
        System.out.println("eee");
    }

    public static int sum(int a, int b) {
        return a + b;
    }
}
