package com.sh._final;

/**
 * <pre>
 * final 키워드
 * 종단을 의미한다.
 *
 * -지역변수 : 초기화 이후 값변경 불가
 * -매개변수 : 메소드 호출이후(매개인자 값대입) 값 변경 불가
 * -전역변수(클래스 변수) : 상수(static 초기화블럭 이전에 무조건 값대입, 이후 값 변경 불가)
 * -전역변수(인스턴스 변수 ) : 상수 (객체생성 시 무조건 값대입, 이후 변경 불가)
 * -메소드 : 오버라이딩(쌍속) 불가
 * -클래스 : 상속 불가 앞에써서 파이널 클래스로 만들 수 있음
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // final 인스턴스 변수는 객체생성 시 무조건 초기화 되어야 함. (이후 setter를 통해 값대입 x)
        Sample sample = new Sample (100);
    }
}
