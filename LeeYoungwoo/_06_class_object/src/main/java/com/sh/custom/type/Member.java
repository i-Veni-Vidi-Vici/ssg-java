package com.sh.custom.type;

/**
 * 사용자 정의 자료형 (참조형)
 * - 서로다른 타입의 값 n개에 해당하는 변수를 선언하고, 묶어낼 수 있다.
 */
public class Member {
    // 전역 변수 - 인스턴스 변수(non-static변수) 클래스 하위에서 어디든지 쓸 수 있는 변수
    String id;
    String pwd;
    String name;
    int age;
    char gender;
    String[] hobbies;
}
