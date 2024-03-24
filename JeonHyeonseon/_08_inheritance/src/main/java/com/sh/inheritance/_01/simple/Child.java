package com.sh.inheritance._01.simple;

// 자식클래스

public class Child extends Parent{

    /**
     * <pre>
     * 어노테이션 = 필드/메소드/클래스 등에 부가기능을 제공한다.
     *
     * @Override 부모메소드와 시그니쳐가 동일한지 문법검사 제공
     * </pre>
     */
    @Override  // 어노테이션 = 필드/메소드/클래스 등에 부가기능을 제공한다.
    public void introduce(){
        System.out.println("자식입니다!");  // 재작성 = 메소드 오버라이드
    }

    public void game(){
        System.out.println("롤 중입니다..ㅎ");
    }
}
