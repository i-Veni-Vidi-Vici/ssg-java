package com.sh.lambda._02.anonymous.clazz;
@FunctionalInterface // 클래스 레벨 어노테이션
public interface Calculator {
    int calc(int a, int b);

    // 람다식으로 사용할 인터페이스는 추상메소드가 딱 하나여야 한다.
//    int calc(int x);
}
