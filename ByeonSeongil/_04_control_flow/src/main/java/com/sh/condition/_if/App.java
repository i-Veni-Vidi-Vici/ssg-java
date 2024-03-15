package com.sh.condition._if;

/**
 * 코드의 성격별로 클래스/메서드등으로 나누어 작성해야 유지보수가 수월하다.
 * 실행 클래스 - main 메소드를 가진 클래스
 * - 기능 제공용 클래스
 *
 */
public class App {
    public static void main(String[] args) {
        //if
        If _if = new If();
//        _if.test();
//        _if.test2();

        // if~else
        IfElse ifElse = new IfElse();
//        ifElse.test();
//        ifElse.test2();
//        ifElse.test3();

        // if-else if
        IfElseIf ifElseIf = new IfElseIf();
        ifElseIf.test();
    }
}
