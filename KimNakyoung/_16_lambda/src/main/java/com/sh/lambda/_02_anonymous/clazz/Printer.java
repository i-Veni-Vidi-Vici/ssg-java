package com.sh.lambda._02_anonymous.clazz;

@FunctionalInterface
public interface Printer {

    void print(String str);

//    void print(int i);
    // 추상메소드 두개 안돼 @FunctionalInterface 이거 붙이면 검사해줌!
}
