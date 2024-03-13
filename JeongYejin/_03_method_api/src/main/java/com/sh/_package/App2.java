package com.sh._package;
// 다른 패키지의 클래스를 가져올 때 필요한 것 => import
//import com.sh.method.Calculator;
import static com.sh.method.Calculator.plus; // 메소드를 import

/**
 * <pre>
 * import static
 * - static import를 사용하면, 클래스명을 생략하고 메소드를 호출할 수 있다.
 * - 일반 import문은 클래스를 지정하는 것이고, static import는 static 메소드(필드)를 지정한다.
 *  </pre>
 */

public class App2 {
    public static void main(String[] args) {
//        System.out.println(Calculator.plus(10, 20));
        System.out.println(plus(10, 20));
    }
}
