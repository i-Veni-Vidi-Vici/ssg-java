package com.sh.condition._if;

/**
 * <pre>
 * 코드의 성격별로 클래스/메소드등으로 나누어 작성해야 유지보수가 수월하다.
 * 실행클래스 - main메소드를 가진 클래스
 * 기능제공용 클래스 - 새로운 클래스
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        //If _if = new If();
        //_if_test();// 짝수 양수-음수, 홀수 양수-음수
        //_if.test2();

        //IfElse ifElse=new IfElse();
        //ifElse.test();// 홀짝
        //ifElse.test2();// 남자 장난감, 여자 장미꽃
       // ifElse.test3();// 양수/0/음수 비교

        IfElseIf ifElseIf=new IfElseIf();
        //ifElseIf.test();
        //ifElseIf.test2();
        ifElseIf.test3();
    }
}
