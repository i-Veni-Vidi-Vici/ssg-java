package com.sh.abstraction.car;

/**
 * <pre>
 * 객체지향 프로그래밍 OOP
 * - Object Oriented Programming
 * - 현실세계의 모든 사건은 객체와 객체와의 상호작용이란 것에서 힌트를 얻어
 * - 프로그래밍 세계로 옮겨놓은 것.
 * - 객체와의 상호작용을 코드로 구현하기 위해 각 객체들에 의인화가 적용된다.
 * - 객체는 스스로 책임을 가지고 행동을 수행하게 된다.
 * - 객체는 적절한 책임을 가질 수 있게 클래스 단위로 잘 분리해 작성해야 한다.
 *   (SOLID 객체지향 설계원칙중 Single Responsibility Principle 단일책임원칙에 해당)
 *
 * 자바 프로그래밍에서의 객체란?
 * - 클래스를 기반으로 메모리에 적재된 형태를 가리킨다.(메모리 조각이 객체이다)
 * - 클래스의 선언된 필드구조 그대로 메모리에 적재된다.
 * - 클래스 1개 : 객체는 n개(여러개) 구조를 가진다
 *
 * 추상화란?
 * - 현실세계의 복잡함을 단순화에서 해당 프로그램에 최적화된 상태로 클래스를 설계하는 것.
 * - 공통점을 뽑아내고, 불필요한 것을 제거하는 것이다.
 *
 * 객체와의 상호작용
 * - 프로그래밍에서 객체는 메세지를 통해서 상호작용한다.
 * - 송신자 객체가 메세지를 보내고(메소드 호출), 수신자 객체는 메세지의 내용(호출할 때 전달한 값 = 매개인자)에 따라 특정 작업을 수행한다.
 * - 수행한 작업결과를 답장(리턴값,반환)으로 보낸다.
 *
 * 객체 ex) 사람, 컴퓨터, 모니터, 사랑, 친구, 강사 등..이름을 붙이는 것 자체가 객체이다.
 * --> 객체는 힙에서만 사용됨
 *
 * 운전 프로그램
 * 0. 요구사항 정리
 *   - 운전프로그램을 만들어주세요 라는 요청
 *   - 운전자는 시동걸기, 악셀을 밟거나, 브레이크를 밟거나, 시동을 끌 수 있어야 한다.
 *   - 자동차는 시동걸기, 가속하거나, 감속하거나, 시동이 꺼질 수 있어야 한다.
 *   - 자동차는 처음엔 대기상태로 있습니다.
 *   - 운전자에 의해 시동이 걸리고, 이미 시동이 걸려있다면 다시 걸 수 없어야 합니다.
 *   - 운전자가 악셀을 밟으면 시동이 걸린 상태에서만 가속할 수 있습니다.
 *     악셀을 밟을때마다 10km/h씩 가속되어야 합니다.
 *   - 운전자가 브레이크를 밟으면, 움직이고 있는 상태에서 10km/h씩 감속됩니다.
 *     0km/h 정지된 상태에서는 더이상 감속할 수 없습니다.
 *   - 운전자가 시동을 끄면 더이상 차는 가속/감속(움직)일 수 없습니다.
 *   - 자동차가 달리는 중에는 시동을 끌 수 없습니다.
 * 1. 객체 도출(객체를 뽑아내는 과정)
 *   - 자동차
 *   - 운전자
 *   - (운전자를 제어하는) 사용자
 * 2. 객체 간의 상호작용 - 커뮤니케이션 다이어그램
 *   - 사용자가 선택 -> 운전자객체에게 메시지를 보냄 -> 운전자객체는 다시 자동차 객체를 제어함
 *   - 사용자가 시동켜기 메뉴를 선택 -> 운전자객체는 시동켜기 -> 자동차 시동켜기
 *   - 가속메뉴선택 -> 운전자의 가속메소드 호출 -> 자동차객체의 가속(현재속도를 변경)
 *   - 감속메뉴선택 -> 운전자의 감속메소드 호출 -> 자동차객체의 감속(현재속도를 변경)
 *   - 시동끄기메뉴선택 -> 운전자객체의 시동끄기 -> 자동차객체의 시동끄기
 * 3. 클래스 설계
 * - 사용자클래스 (실행클래스)
 * - 운전자클래스 (시동켜기, 시동끄기, 가속, 감속 메소드)
 * - 자동차클래스 (시동켜기, 시동끄기, 가속, 감속 메소드| 시동상태, 속도 상태값)
 *
 * <정리>
 *  각 객체가 수신할 수 있는 메세지(역할/책임 정의)
 *  - CarMenu
 *   - 사용자가 선택할 수 있는 메뉴 제공
 *  - Driver
 *   - 시동 끄기
 *   - 가속
 *   - 감속
 *   - 시동끄기
 *  - Car
 *   - 시동켜기
 *   - 가속
 *   - 감속
 *   - 시동끄기
 *
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        CarMenu carMenu = new CarMenu();
        carMenu.menu();  // CarMenu라는 클래스명을 만들고 menu라는 메소드를 작성한다.
    }
}
