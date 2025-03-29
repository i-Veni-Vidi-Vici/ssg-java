package com.sh._final;

public class Sample {
    // static final 필드는 생성자로 값대입할 수 없다.
    public static final String APP_NAME = "즐거운 주사위놀이"; // 초기화 필수
    public static final String APP_VERSION;

    // static 초기화블럭
    static {
        APP_VERSION = "1.0.0";
    }

    private final int value = 100; // 객체 생성시 무조건 값대입
    private final int value2;

    //    public Sample(){}
    public Sample(int value2) {
        this.value2 = value2;
    }
}