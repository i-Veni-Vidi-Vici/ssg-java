package com.sh.condition._if;

import com.ssg.test.condition._if.Test1;
import com.ssg.test.condition._if.Test2;
import com.ssg.test.condition._if.Test3;

/**
 * 코드의 성격별로 클래스/메소드 등으로 나누어 작성해야 유지보수가 수월함
 *
 * - 실행클래스 : main메소드를 가진 클래스
 * - 기능제공용클래스
 *
 */

public class App {
    public static void main(String[] args) {
        // if
        If _if = new If();
//        _if.test();
//        _if.test2();

        // ifelse
        IfElse _ifElse = new IfElse();
//        _ifElse.test();
//        _ifElse.test2();
//        _ifElse.test3();

        // ifelseif
        IfElseIf _ifElseif = new IfElseIf();
//        _ifElseif.test();
//        _ifElseif.test2();
//        _ifElseif.test3();
    }
}
