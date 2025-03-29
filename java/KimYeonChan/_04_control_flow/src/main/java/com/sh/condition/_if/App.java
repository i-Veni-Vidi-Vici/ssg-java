package com.sh.condition._if;

/**
 * 코드의 성격별로 클래스/메소드 등으로 나누어 작성해야 유지보수가 수월하다.
 * - 실행 클래스: main 메소드를 가진 클래스
 * - 기능제공용 클래스
 */
public class App {
    public static void main(String[] args) {
        If _if =  new If();
        // _if.test1();
        // _if.test2();

        IfElse ifElse = new IfElse();
        // ifElse.test1();
        // ifElse.test2();
        // ifElse.test3();

        IfElseIf ifElseIf = new IfElseIf();
        ifElseIf.test1();
    }
}
