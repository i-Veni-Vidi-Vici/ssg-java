package com.sh.lambda._02.anonymous.clazz;

@FunctionalInterface // 클래스 레벨 어노테이션 = 추상메소드처럼 @Override 같은 개념이다
// 여기서는 어?? 너 람다로 썻는데 왜 메소드 더 넣을려고 해?? 안돼!! 하는 느낌이다
public interface Calculator {
    int calc(int a, int b);
    //람다식으로 사용할 인터페이스는 추상메소드가 딱 하나여야 한다.
}
