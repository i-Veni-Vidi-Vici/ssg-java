package com.sh._03.has_a;

/**
 * <pre>
 *  Has - a 포함관계
 *  - 한 클래스에서 인스턴스 변수로 다른 클래스 타입의 참조변수를 가지고 있는 경우
 *   => private MemberCreateService memberCreateService = new MemberCreateService() 이런 느끔
 *   -> memberCreateService가 MemberCreateService타입의 참조변수를 가지고 있음
 *  - UML(통합 모델링 언어) 클래스 다이어그램 상에서는 연관(Association)관계
 *  - Person has a home , Person has a phone
 * </pre>
 *
 * 구분
 * - 단방향 / 양방향 관계
 *      - 단방향 Person -> Phone (Person은 phone을 가지고 있지만 phone은 Person을 가지고 있지 않다.)
 *      - 양방향 Person <-> Home (둘다 서로에 대한 객체를 가지고 있기 떄문에 양방향 관계이다.
 * - 집약/합성 관계
 *      - 집약 관계 : 객체 생명주기 독립적. 외부에서 객체를 주입 받는 경우 ㅁ---> (ㅁ:빈 ㅁ)
 *      - 합성 관계 : 객체 생명주기 의존적. 내부에서 객체를 생성하는 경우 ㅁ(ㅁ : 색칠해진 ㅁ)
 */
public class App {
}
