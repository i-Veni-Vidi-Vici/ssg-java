package com.sh._enum._03.advanced;

/**
 * <pre>
 * enum은 필드를 가질 수 있다.
 * - 상수값과 내부적으로 처리되는 다른 값들을 1개 이상 필드로 선언할 수 있다.
 * - 생성자(=필드값을 초기화하는 요소)를 통해 이 값들을 각 객체에 설정한다.
 * </pre>
 */
public enum DevType {
    WEB(1234),
    IOS(5555),
    ANDROID(7777);

    private int code; // 필드 선언

    DevType(int code) {
        this.code = code;
    }

    public static DevType valueOf(int code) {
        return switch(code){    // 값을 뱉어내는 것은 switch(){}
            case 1234 -> WEB;
            case 5555 -> IOS;
            case 7777 -> ANDROID;
            default -> throw new IllegalArgumentException("존재하지 않는 코드입니다. : " + code); // default구문은 필수
        };
    }

    public int getCode(){
        return this.code;
    }
}
