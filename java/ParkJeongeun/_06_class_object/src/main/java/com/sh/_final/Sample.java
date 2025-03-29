package com.sh._final;

public class Sample {
    // static final 필드는 생성자로 값대입 할 수 없음
    public static final String APP_NAME = "주사위놀이"; // 초기화
    public static final String APP_VERSION;

    // static 초기화 블럭 : 윗줄과 같이 작성
    static {
        APP_VERSION = "1,0,0";
    }
    private final int value = 100; // 객체 생성시 무조건 값대입
    private final int value2;

//    public Sample(){} //밑에꺼 쓰고 이것도 쓰면 오류
    public Sample(int value2){
        this.value2 = value2;
    }
}
