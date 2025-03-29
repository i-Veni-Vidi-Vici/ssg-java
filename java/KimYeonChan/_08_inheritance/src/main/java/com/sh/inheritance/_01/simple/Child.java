package com.sh.inheritance._01.simple;

public class Child extends Parent {
    /**
     * 어노테이션 (필드/메소드/클래스 등에 부가기능 제공
     * @Override 부모메소드와 시그니쳐가 동일한지 문법검사 제공
     */
    @Override
    public void introduce() {
        System.out.println("자식");
    }

    public void game() {
        System.out.println("게임 중");
    }
}
