package com.sh.lambda._02.annonymous;

@FunctionalInterface //클래스 레벨 어노테티션
public interface Calculator {
    int calc(int a, int b);

    //람다식으로 사용할 떄 인터페이스 구현 메소드는 하나만 있어야한다. 두개 있으면 실행 안함
}
