package com.sh._package;

// import com.sh.method.Calculator;
import static com.sh.method.Calculator.plus;

/**
 * import static
 * - static import 를 사용하면, 클래스명을 생략하고 메소드를 호출할 수 있다.
 * - 일반 import 문은 클래스를 지정하는 것이고, static import 는 static 메소드(필드)를 지정한다.
 */
public class App2 {
    public static void main(String[] args) {
        System.out.println(plus(10, 20));
    }
}
