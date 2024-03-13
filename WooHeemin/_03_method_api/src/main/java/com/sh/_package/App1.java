package com.sh._package;

import static com.sh.method.Calculator.plus;
import static com.sh.method.Calculator.I;
/**
 * <pre>
 *     import static
 * - static import 를 사용하면, 클래스명을 생략하고 메소드를 호출할 수 있다.
 * - 일반 import문은 클래스를 지정하는 것이고, static import는 static 메소드/필드를 지정
 *
 * </pre>
 */
public class App1 {

    public static void main(String[] args) {

        plus();
        System.out.println(I);
    }
}
