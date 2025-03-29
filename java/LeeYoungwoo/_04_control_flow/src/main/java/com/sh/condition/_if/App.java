package com.sh.condition._if;

import com.sun.source.tree.IfTree;

/**
 * <pre>
 * 코드의 성격별로 클래스/메소드등으로 나누어 작성해야 유지보수가 수월하다.
 *
 * 실행클래스 - main 메소드를 가진 클래스
 * 기능제공용클래스 - 실행코드를 가진 클래스
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // if
        If _if = new If();
//        _if.test();
//        _if.test2();

        // if~else
//        IfElse ifElse = new IfElse();
//        ifElse.test();

//        // if~else if
//        IfElseIf ifElseIf = new IfElseIf();
//        ifElseIf.test();



//        // 문제1
//        IfElse _ifQ1 = new IfElse();
//        _ifQ1.test2();

//        // 문제2
//        IfElse _ifQ2 = new IfElse();
//        _ifQ2.test3();

//        // 문제3
//        IfElseIf _ifQ3 = new IfElseIf();
//        _ifQ3.test2();

        // 문제4
        IfElseIf _ifQ4 = new IfElseIf();
        _ifQ4.test3();
    }
}
