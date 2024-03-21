package com.sh._03.has_a;


/**
 *
 * <pre>
 *  Has-a 포함관계
 *  - 한 클래스에서 인스턴스변수로 다른 클래스타입의 참조변수를 가지고 있는 경우
 *  - UML ( 통합모델링언어) 클래스다이어그램상에서는 연관(Association)관계
 *  Person has a Home. Person has a Phone
 * </pre>
 *
 * 구분
 * - 단방향/양방향 관계
 *          - 단방향 Person -> Phone (person은 phone을 가지고 있지만, Phone은 Person을 가지고 있지 않다.)
 *          - 양방향 Person <-> Home (Person은 Home을 가지고 있고, Home도 Person을 가지고 있다.)
 * - 집약/합성 관계
 * - 집약 Aggregation 관계 : 객체생명주기 독립적. 외부에서 객체를 주입받는 경우 ◇ -->
 * - 합성 Composition 관계 : 객체생명주기 의존적. 내부에서 객체를 생성하는 경우 ◆ -->
 *
 *
 *
 *
 */
public class App {
    public static void main(String[] args) {

    }
}
