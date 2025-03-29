package com.sh._package;

//import com.sh.method.Calculator; // main에서 1번 작성하면 자동 생성
import static com.sh.method.Calculator.plus;

/**
 * <pre>
 * import static
 * - static import를 사용하면 클래스명을 생략하고 메소드를 호출할 수 있음
 * - 일반 import문은 클래스를 지정하는 것이고 static import 는 static 메소드(필드)를 지정
 *
 * </pre>
 */

public class App2 {
    public static void main(String[] args) {
//        System.out.println(Calculator.plus(10, 20)); // 1번
        System.out.println(plus(10, 20));

    }
}
