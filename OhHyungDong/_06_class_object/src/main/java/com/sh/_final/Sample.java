package com.sh._final;

import jdk.dynalink.StandardNamespace;

public class Sample {
    //static final 필드는 생성자로 값대입 할 수 없다. => static은 미리 만들어지기 때문에 값을 초기화 시켜놔야함.
    public static final String APP_NAME = "GAME";
    public static final String APP_Version ;
    static{//static 초기화 블럭
        APP_Version =  "1.0";
    }
    private final int value = 5; // 객체 생성시 무조건 값 대입
    private final int value2 ;

//    public Sample(){ 생성자를 이렇게 만들면 value2값에 값이 들어가지 않을 수도 있기 때문에 기본 생성자를 생성해선 안됨.
//
//    }
    public Sample(int value2){ //그래서 의존관계 주입 할 때도 바로 생성자에 값 초기화 시키는거네
        this.value2 = value2;
    }

}
