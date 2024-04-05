package com.sh._enum._03.advanced;

/**
 * <PRE>
 *      enum은 필드를 가질 수 있음
 *      - 상수값과 내부적으로 처리되는 다른 값들을 1개 이상 필드로 선언할 수 있음
 * </PRE>
 */
public enum DevType {
    WEB(1234),
    IOS(3333),
    ANDROID(7777);
    private int code;

    DevType(int code) {
        this.code = code;
    }


    public static DevType valuOf(int code) {
        return switch (code) {
            case 1234 -> WEB;
            case 3333 -> IOS;
            case 7777 -> ANDROID;
            default -> throw new IllegalArgumentException("존재하지 않는 코드입니다." +  code);
        };
    }
    public int getCode() {
        return this.code;
    }


}
