package com.sh._03.has.a;

/**
 * <pre>
 *   Has - a 포함 관계
 *  - 한 클래스에서 인스턴스 변수로 다른 클래스 타입의 참조변수를 가지고 있는 경우
 *  - UML(통합 모델링 언어) 클래스다이어그램상에서는 연관(Association)관계
 *  - 구분
 *     - 단방향 / 양방향 연관 관계
 *         - 단방향 Person → Phone (Person은 Phone을 가지고 있지만, Phone은 Person을 가지고 있지 않음
 *         - 양방향 Person ↔ Home (Person은 Phone을 가지고 있고, Phone은 Person을 가지고 있음)
 *     - 집약 Aggregation 관계 : 객체 생명주기 독립적, 외부에서 객체를 주입 받는 경우 ◇- -→
 *     - 합성 Composition 관계 : 객체 생명 주기 의존적, 내부에서 객체를 생성하는 경우 ◆- -→
 * </pre>
 */
public class App {
    public static void main(String[] args) {

    }
}
