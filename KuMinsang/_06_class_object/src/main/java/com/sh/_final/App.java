package com.sh._final;

/**
 * <pre>
 *     final 키워드
 *     - 종단을 의미한다
 *     - 지역변수 : 초기화 이후 값 변경 불가
 *     - 매개변수 : 메소드 호출(매개인자 값 대입) 이후 값 변경 불가
 *     - 전역변수(클래스 변수) : 상수 (static 초기화 블럭) <- 대문자로만 작성
 *     - 전역변수(인스턴스 변수) : 상수 (객체 생성시 무조건 값 대입, 이후 변경 불가)
 *     - 메소드
 *     - 클래스
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //final 인스턴스 변수는 객체 생성시 무조건 초기화 되어야함 (이후 setter를 통해 값 대입이 되지 않음)
        Sample sample1 = new Sample(100);
        Sample sample2 = new Sample(22);
        System.out.println(sample1.getValue2());
        System.out.println(sample2.getValue2());

    }
}
