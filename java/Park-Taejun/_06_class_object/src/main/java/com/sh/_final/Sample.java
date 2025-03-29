package com.sh._final;

public class Sample {
    public static final String APP_NAME = "즐거운 주사위놀이"; //초기화 무조건 되어야함

    public static final String APP_VERSION;
    //static 초기화 블럭
    static {
        APP_VERSION ="1.0.0";
    }
    private final int value= 100; //객체 생성 시 무조건 값대입이 일어나야 함 값이 뭐라도 들어가야함
    private final int value2;
//    public Sample(){} //기본생성자로 만들게 되면 값이 안들어감
    public Sample(int value2){
        this.value2 = value2;
    }
}
