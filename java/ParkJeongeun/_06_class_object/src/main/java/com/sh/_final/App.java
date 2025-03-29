package com.sh._final;

/**
 * <pre>
 * final 키워드
 * - 종단을 의미
 *
 * 아래 형태 앞에 사용 가능
 * - 지역변수 : 초기화 이후 값변경 불가
 * - 매개변수 : 메소드 호출(매개인자 값대입) 이후 값변경 불가
 * - 전역변수(클래스변수) : 상수(static 초기화 블럭 이전에 무조건 값대입, 이후 변경 불가)
 *                       변수명 모두 대문자로 작성
 * - 전역변수(인스턴스 변수): 상수(객체 생성시 무조건 값대입, 이후 변경 불가
 * - 메소드 : 오버라이딩(상속) 불가
 * - 클래스 : 상속 불가
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        // final 인스턴스 변수는 객체 생성시 무조건 초기화되어야 함
        Sample sample = new Sample(100);
    }
}
