package com.sh.inheritance._01.simple;

public class Child extends Parent{
    /**
     * <pre>
     *     부모 메소드와 시그니쳐가 동일한지 문법 검사제공
     * </pre>
     */
    @Override // ANNOTATION (필드/ 메소드/ 클래스 등에 부가 기능을 제공
    public void introduce(){
        System.out.println("오버라이딩된 자식 메소드입니다");
    }

    public void game(){
        System.out.println("롤 중입니다~~~~");

    }
}
