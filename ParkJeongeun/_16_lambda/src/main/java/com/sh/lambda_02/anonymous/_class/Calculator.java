package com.sh.lambda_02.anonymous._class;

@FunctionalInterface // 클래스 레벨 어노테이션
public interface Calculator {
    int calc(int a, int b);

    // 람다식으로 사용할 인터페이스는 추상메소드가 딱 하나여야 함
//    int calc(int x) ;
}
