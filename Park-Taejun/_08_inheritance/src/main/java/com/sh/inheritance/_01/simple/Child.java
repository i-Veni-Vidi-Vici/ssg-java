package com.sh.inheritance._01.simple;

public class Child extends Parent {

    // 메소드 오버라이드

    /**
     * @OVerride 는 부모 메소드와 시그니쳐가 동일한지 문법검사를 제공함
     */
    @Override// 어노테이션 이라고 부름 ( 필드/메소드/클래스등에 부가기능을 실행)
    public void introduce(){
        System.out.println("자식입니다~~~~~");    //재작성 메소드 오버라이드라고함 , 재작성한 메소드가 먼저 실행되는 것을 알 수 있음.
        //선언하진 않았지만 name info age 다 있는 것임

    }
    public void game(){
        System.out.println("롤 중입니다~~~~~~");
    }
}
