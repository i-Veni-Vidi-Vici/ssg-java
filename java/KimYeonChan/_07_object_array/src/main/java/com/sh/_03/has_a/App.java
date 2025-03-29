package com.sh._03.has_a;

/**
 * Has-a 포함관계
 * - 한 클래스에서 인스턴스 변수로 다른 클래스 타입의 참조변수를 가지고 있는 경우
 * - UML (통합모델링언어) 클래스 다이어그램상에서는 연관관계
 * 구분
 * - 단방향/양방향
 *      - 단방향 Person -> Phone (Person 은 Phone 을 가지고 있지만, Phone 은 Person 을 가지고 있지 않다.)
 *      - 양방향 Person <-> Home (Person 은 Home 을 가지고 있고, Home 도 Person 을 가지다.)
 * - 집약/합성
 *      - 집약 Aggregation 관계: 객체생명주기 독립적. 외부에서 객체를 주입받는 경우. 빈마름모-->
 *      - 합성 Composition 관계: 객체생명주기 의존적. 내부에서 객체를 생성하는 경우. 찬마름모-->
 */
public class App {

}
