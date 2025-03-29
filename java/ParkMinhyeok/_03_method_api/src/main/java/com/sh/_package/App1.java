package com.sh._package;
import com.sh.method.Calculator;
// 자주 사용되는 package java.lang의 클래스에 대해서는 compiler가 자동으로 import문을 추가해준다.
import java.lang.String;
/**
 * <pre>
 * 패키지 (package)
 *
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
//        App1 app = new App1();
        com.sh._package.App1 app = new com.sh._package.App1();
        app.test();

//        App1.test2();
        com.sh._package.App1.test2();

        // 다른 패키지의 클래스를 호출하는 경우
        // 1. 패키지 포함한 풀네임을 작성
        System.out.println(com.sh.method.Calculator.plus(10, 20));
        // 2. import문 작성 후 사용
        System.out.println(Calculator.plus(20, 30));
        // 3. 다른 패키지이지만, import 문을 작성하지 않아도 되는 경우 - java.lang 패키지의 클래스인 경우
        String str = "ㅋㅋㅋ";

        // method 패키지의 App1 클래스의 a, b, c 메소드를 호출
        com.sh.method.App1 app1 = new com.sh.method.App1();
        app1.a();
        app1.b();
        app1.c();
    }
    public void test() {
        System.out.println("🐶🐶🐶 test 🐶🐶🐶");
    }
    public static void test2() {
        System.out.println("🍊🍊🍊 test2 🍊🍊🍊");
    }
}
