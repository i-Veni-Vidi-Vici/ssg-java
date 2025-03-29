package com.sh._final;

public class Sample {
    public static final String APP_NAME="집에가고 싶다";
    public static final String APP_VERSION;
    private final int value=1;// 객체 생성시 무조건 값대입
    private final int value2;

    static {
        APP_VERSION= "1.0.0";
    }
    public Sample(int value2) {
        this.value2=value2;
    }

}
