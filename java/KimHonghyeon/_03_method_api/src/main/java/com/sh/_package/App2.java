package com.sh._package;

import static com.sh.method.Calculator.plus;

/**
 * import static
 * -static import를 사용하면 클래스 명을 생략하고 메소드 호출 가능.
 * -일반 import문은 클래스를 지정하는 것. static import는 static 메소드(필드)를 지정
 */
public class App2 {
    public static void main(String[] args) {
        System.out.println(plus(10,20));
    }
}
