package com.sh.condition._if;

/**
 * <pre>
 *   코드의 성격 별로 클래스/메소드 등으로 분리하여 작성해야 유지보수가 수월하다.
 *   실행 클래스 - main 메소드를 가진 클래스
 *   기능제공용 클래스 - 실행 코드들을 가진 클래스
 * </pre>
 */

public class App {
    public static <IfElseIf> void main(String[] args) {
        //if
//        If _if = new If();
//        //_if.test();
//        _if.test2();

        //if ~ else
//      IfElse iFElse = new IfElse();
//      iFElse.test2();
//      iFElse.test3();

        com.sh.condition._if.IfElseIf elseIf = new com.sh.condition._if.IfElseIf();
       // elseIf.test2();
        elseIf.test3();

    }
}
