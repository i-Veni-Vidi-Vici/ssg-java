package com.sh.inheritance._01.simple;

// 부모가 자식 클래스 상속
public class Child extends Perent{


    /**
     * <pre>
     * 어노테이션 ( 필드/메소드/클래스 등에 부가기능 제공)
     *
     * @Override 부모메소드와 시그니쳐가 동일한지 문법검사 제공
     * </pre>
     *
     */

    //메소드 재작성함
    @Override // 이거 쓰면 부모안에 있는 메소드, 필드 다 일치하는지 알려줌
    public void introduce() {
        System.out.println("자식입니다");
    }

    public void game(){
        System.out.println("롤 중입니다~~~~~");
    }

}
