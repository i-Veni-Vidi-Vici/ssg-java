package com.sh._enum._03.advanced;

/**
 * <pre>
 *   enum은 필드를 가질 수 있다,
 *   - 상수값과 내부적으로 처리되느 다른 값들을 1개이상 필드로 선언할 수 있다.
 *   - 생성자를 통해서 이 값들을 각 객체에 설정한다.
 * </pre>
 */
public enum DevType {
    WEB(1234),
    IOS(3333),
    ANDROID(7777);

    private  int code;

    DevType(int code){
        this.code = code;
    }

    public int getCode(){
    return this.code;
    }

    public static DevType valueOf(int code){
        return switch(code){
            case 1234 -> WEB;
            case 3333 -> IOS;
            case 7777 -> ANDROID;
            default -> {
                throw new IllegalArgumentException("존재하지 않는 코드입니다." + code);
            }
        };
    }
}
