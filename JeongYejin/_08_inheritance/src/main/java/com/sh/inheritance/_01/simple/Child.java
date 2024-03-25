package com.sh.inheritance._01.simple;

public class Child extends Parent {

    @Override // 어노테이션 (필드/메소드/클래스 등에 부가기능 제공)
    public void introduce() {
        System.out.println("자식입니다~~~~");
    }

    public void game() {
        System.out.println("게임 중입니다!!");
    }
}
