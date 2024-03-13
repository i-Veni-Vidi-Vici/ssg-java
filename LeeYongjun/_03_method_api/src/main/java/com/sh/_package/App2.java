package com.sh._package;

//import com.sh.method.Calculator;
import static com.sh.method.Calculator.plus;
/**
 * <pre>
 * import static
 * - static import를 사용하려면, 클래스명을 생략하고 메소드를 호출할 수 있다.
 * - 일반 import문은 클래스를 지정하는 것이고, static import는 static메소드(필드)를 지정한다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        //System.out.println(Calculator.plus(10,20));
        System.out.println(plus(10,20));
    }
}
