package com.sh._final;

public class Sample {
    // static final 필드는 생성자로 값대입 할 수 있다!!
    public static final String APP_NAME = "즐거운 주사위놀이"; // 초기화 필수

    public static final String APP_VERSION;

    //static
    static {
        APP_VERSION = "1.0.0";
    }

    private final int value = 100; // 객체 생성시 무조건 값 대입이 일어남 그래서 초기화 꼭 해줘야됨!
    private final int value2;


//    public Sample(){} // 기본 생성자 적었더니 오류난다~ 왜냐? 값이 안들어가니까

    public Sample(int value2) {
        this.value2 = value2;
    }
}
