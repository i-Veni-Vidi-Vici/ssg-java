package com.sh.abstraction.car;

/**
 * <pre>
 * 객체지향 프로그래밍 OOP
 * - Object Oriented Programming
 * - 현실세계의 모든 사건은 객체와 객체와의 상호작용이란 것에서 힌트를 얻어 프로그래밍 세계로 옮겨놓은것.
 * - 객체와 상호작용을 코드로 구현하기위해 각 객체들에 의인화가 적용된다.
 * - 객체는 스스로 책임을 가지고 행동을 수행하게 된다.
 * - 객체는 적절한 책임 가질수 있게 클래스단위로 잘 분리해 작성해야 한다.
 *   (SOLID 객체지향 설계원칙중 Single Responsibility Principle 단일책임원칙)
 *
 * 자바 프로그래밍에서의 객체란?
 * - 클래스를 기반으로 메모리에 적재된 형태를 가리킴.
 * - 클래스의 선언된 필드구조 그대로 메모리에 적재된다.
 * - 클래스 1 : 객체 n 구조를 가진다.
 *
 * 추상화란?
 * - 현실세계의 복잡함을 단순화에서 해당 프로그램에 최적화된 상태로 클래스를 설계하는 것.
 * - 공통점을 뽑아내고, 불필요한 것을 제거하는 것.
 *
 * 객체와 상호작용
 * - 프로그래밍에서 객체는 메세지를 통해서 상호작용.
 * - 송신자객체가 메세지를 보내고(메소드 호출), 수신자 객체는 메세지의 내용(매개인자)에 따라 특정작업을 수행한다.
 * - 수행한 작업결과를 답장(리턴값)으로 보낸다.
 *
 * 운전프로그램
 * 1. 객체 도출
 *  - 자동차
 *  - 운전자
 *  - 사용자
 * 2. 객체간의 상호작용 - 커뮤니케이션 다이어그램
 *  - 사용자선택 -> 운전자객체 -> 자동차객체
 *  - 시동켜기메뉴선택 -> 운전자 시동켜기 -> 자동자 시동켜기
 *  - 가속메뉴선택 -> 운전자 가속 -> 자동차 가속(현재속도를 변경)
 *  - 감속메뉴선택 -> 운전자 감속 -> 자동차 감속(현재속도를 변경)
 *  - 시동끄기메뉴선택 -> 운전자 시동끄기 -> 자동차 시동끄기
 * 3. 클래스 설계
 * - 사용자클래스 (실행클래스)
 * - 운전자클래스 (시동켜기, 시동끄기, 가속, 감속 메소드)
 * - 자동차클래스 (시동켜기, 시동끄기, 가속, 감속 메소드| 시동상태, 속도 상태값)
 *
 * 각 객체가 수신할 수 있는 메세지 (역할/책임 정의)
 * - CarMenu
 *   - 사용자 선택할 수 있는 메뉴 제공
 * - Driver
 *   - 시동켜기
 *   - 가속
 *   - 감속
 *   - 시동끄기
 * - Car
 *  - 시동 켜기
 *  - 가속
 *  - 감속
 *  - 시동끄기
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        CarMenu carMenu = new CarMenu();
        carMenu.menu();
    }
}