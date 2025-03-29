//package com.sh.polymorphism._02.abstrat._class;
//
//
///**
// * <pre>
// * 추상클래스 | 인터페이스
// * -상속(구현)을 통해 클래스 계층구조를 만들면서, 추상메소드를 통해 구현을 강제화할 수 있는 특징이 있다.
// * -추상 메소드란? 미완성메소드로 몸통이 없다. 자식 클래스에서 반드시 구현해야 한다.
// * -둘다 객체화 할 수 없다. (new 연산자 사용 불가)
// *
// * 추상클래스
// * - abstract class 미완성 클래스 라고도 함
// * - 추상메소드를 통해서 자식 클래스의 기능을 강제구현하게 한다.
// * - 일반 필드/ 메소드를 가질 수 있다. (인터페이스와 다른점)
// * - 0개 이상의 추상메소드를 가지고 있다. ( 추상메소드가 하나라도 있다면, 반드시 추상클래스여야 한다.)
// *
// *
// * </pre>
// */
//
//public class App {
//    public static void main(String[] args) {
////        Product product = new Product();
//
//        Product product1 = new SmartPhone("ss-0123" , "갤럭시 24" , 1_000_000);
//        product1.printInfo();
//        Product product2 = new Keyboard()("abc-3456" , "기계식키보드 ", 100_000);
//        product2.printInfo();
//
//    }
//}
