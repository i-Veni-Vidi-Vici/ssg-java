package com.sh.abstraction.car;

/**
 * <pre>
 *  객체 지향 프로그래밍 OOP
 *  - Object Oriented Programming
 *  - 현실 세계의 모든 사건은 객체와 객체와의 상호작용이란 것에서 힌트를 얻어 프로그래밍 셰게로 옮겨 놓은 것.
 *  - 객체와 상호작용을 코드로 구현하기 위해 각 객체들에 의인화가 적용이 된다.
 *  - 객체는 스스로 책임을 가지고 행동을 수행하게 된다.
 *  - 객체는 적절한 책임을 가질 수 있게 클래스 단위로 잘 분리해 작성해야한다.
 *
 *  자바 프로그래밍에서의 객체란 ?
 *  - 클래스를 기반으로 메모리에 적재된 형태를 가리킴. -> Member member = new Member()와 같이 메모리에 적재되야 객체라고 함.
 *  - 클래스의 선언된 필드 구조 그대로 메모리에 적재된다.
 *  - 클래스 1 : 객체는 여러개의 구조를 가진다.
 *
 *
 *  추상화란 ? 클래스들의 공통적인 요소들을 뽑아서 상위 클래스를 만들어 내는 것으로 클래스들의 공통적인 부분만 뽑아서 설계도 처럼 설계 해놓은 것
 *  -> 구현은 메소드를 오버라이드 하거나 , 인터페이스를 통해서 기능적인 부분을 구현해놓음 .
 *  - 현실세계의 복잡함을 단순화해서 해당 프로그램에 최적화된 상태로 클래스를 설계하는 것 .
 *  - 공통점을 뽑아내고, 불필요한 것을 제거하는 것.
 *  - 공통적인 부분을 추상 클래스에 저장하고, 구현하는 부분은 상속 시켜서
 *
 *  객체와 상호작용
 *  - 프로그래밍에서 객체는 메시지를 통해서 상호작용.
 *  - 송신자 객체가 메세지를 보내고(메소드를 호출하고) ,수신자 객체는 메세지의 내용에(호출할 때 전달한 값들인 매개인자) 따라 특정 작업을 수행하는 구조
 *  - 수행한 작업결과를 답장(리턴값)으로 보낸다.
 *
 *  운전프로그램
 *  0. 요구사항 정리
 *  - 운전 프로그램을 만들어주세요.
 *  - 운전자는 시동 걸기, 악셀 밟기, 브레이크 밟기, 시동을 끌 수 있어야 합니다.
 *  - 자동차는 시동걸기, 가속하거나, 감속을 하거나, 시동이 꺼질 수 있어야합니다.
 *  - 자동차는 처음엔 ㄴ대기 상태로 있습니다.
 *  - 운전자에 의해 시동이 걸리고, 이미 시동이 걸려있다면 다시 걸 수 없어야합니다.
 *  - 운전자가 악셀을 밟으면, 시동이 걸린 상태에서만 가속할 수 있습니다. 악셀을 밟을 때 마다 10Km/h씩 가속되어야합니다.
 *  - 운전자가 브레이크를 밟으면, 시동이 걸린 상태에서만 감속 할 수 있고, 브레이크를 밟을 때 마다 10km/h씩 감속되어야합니다.
 *      정지된 상태에서는 감속할 수 없습니다.
 *   - 운전자가 시동을 끄면 더이상 차는 가속/감속 할 수 없습니다.
 *   - 자동차가 달리는 중에는 시동을 끌 수 없습니다.
 *  1. 객체 도출
 *   - 자동차
 *   - 운전자
 *   - 사용자(플레이어)
 *  2. 객체간의 상호작용 정의 - 커뮤니케이션 다이어그램
 *   - 사용자가 선택 -> 운전자 객체에게 메세지 -> 자동차 객체 제어
 *   사용자 : 시동켜기 메뉴 -> 운전자 : 시동 켜기 메소드 호출 -> 자동차 :  시동켜기
 *   사용자 : 가속 메뉴 선택 -> 운전자 : 가속 메소드 호출 -> 자동차 : 가속(현재속도를 변경하는)
 *   사용자 : 감속 메뉴 선택 -> 운전자 : 감속 메소드 호출 -> 자동차 : 감속(현재속도 변경)
 *   사용자 : 시동끄기 메뉴 -> 운전자 : 시동끄는 메소드 호출 -> 자동차 : 시동끄기
 *  3. 클래스 설계
 *  - 사용자 클래스(실행 클래스)
 *  - 운전자 클래스(시동 켜기, 시동끄기, 가속, 감속 메소드 제공)
 *  - 자동차 클래스(시동 켜기, 시동끄기, 가속, 감속 메소드 | 시동 상태, 속도 상태값)
 *
 *  각 객체가 수신할 수 있는 메세지 (역할/ 책임 정의)
 *  - CarMenu
 *    - 사용자 선택할 수 있는 메뉴 제공
 *  - Driver
 *     - 시동켜기
 *     - 가속
 *     - 감속
 *     - 시동끄기
 *  - Car
 *     - 시동 켜기
 *     - 가속
 *     - 감속
 *     - 시동 끄기
 * </pre>
 */
public class App {

    public static void main(String[] args) {
        CarMenu carMenu = new CarMenu();
        carMenu.menu();
    }
}
