package com.sh.polymorphism._02._abstract._class;


/**
 * 추상클래스 / 인터페이스
 *  - 상속(구현)을 통해 클래스 계층구조를 만들면서, 추상메소드를 통해 구현을 강제화 할 수 있다.
 *  - 추상메소드: 미완성 메소드로 몸통(정의)이 없다. 자식클래스에서 반드시 구현해야한다.
 *  - 둘 다 객체화 할 수 없다.(new연산자 사용 불가)
 *
 *  추상클래스
 *  - abstract class
 *  - 추상메소드를 통해 자식클래스의 기능을 강제구현하게 한다.
 *  - 일반 필드/메소드를 가질 수 있다.(인터페이스와 차이점)
 *  - 0개 이상의 추상메소드를 가지고 있다.(추상메소드가 하나라도 있다면, 반드시 추상클래스여야 한다.)
 *
 */
public class App {
    public static void main(String[] args) {
        //Product product = new Product(); 추상클래스 Product의 객체는 생성 불가

        Product product1 = new SmartPhone("1", "갤럭시", 1200000, "SKT");
        product1.printInfo();
        Product product2 = new Keyboard("1234", "기계식 키보드", 100000,"한/영");
        product2.printInfo();
    }
}
