package com.sh._final;

import java.security.spec.RSAMultiPrimePrivateCrtKeySpec;

/**
 *  final 키워드
 *
 * - 종단을 의미함
 * - 지역변수 : 초기화 이후, 값변경 불가
 * - 매개변수 : 메소드 호출(매개인자 값 대입) 이후, 값 변경 불가
 * - 전역변수(클래스 변수) : 상수(static 초기화 블럭 이전에 무조건 값대입, 이후 변경 불가), 변수명 모두 대문자로 작성
 * - 전역변수(인스턴스 변수) : 상수(객체 생성시 무조건 값대입, 이후 변경 불가)
 * - 메소드 : 오버라이딩 (상소걔 불가
 * - 클래스 : 상속 불가
 */
public class App {
    public static void main(String[] args) {
        //final 인스턴스 변수는 객체 생성시 무조건 초기화 디어ㅑ 한다.
        Sample sample = new Sample(100);
    }
}
