package com.sh.inheritance._01.simple;

public class Child extends Parent {

    /**
     * <pre>
     * 어노테이션 (필드/메소드/클래스등에 부가기능 제공)
     *
     * @Override 부모메소드와 시그니쳐가 동일한지 문법검사 제공
     * </pre>
     */
    @Override
    public void introduce(){
        System.out.println("자식입니다~~~~~");
    }

    public void game(){
        System.out.println("롤 중입니다~~~~ ");
    }
}
