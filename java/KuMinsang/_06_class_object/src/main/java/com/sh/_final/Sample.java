package com.sh._final;

public class Sample {
    //static final 필드는 생성자로 값 대입 할 수 없다
    public static final String APP_NAME = "즐거운 주사위놀이";
    public static final String APP_VERSION;

    //static 초기화 블럭
    static{
        APP_VERSION = "1.0.0";
    }

    private final int value = 100;
    private final int value2;

    public Sample(int value2){
        this.value2 = value2;
    }

    public int getValue2() {
        return value2;
    }
}
