package com.sh.inheritance._01.simple;

/**
 * 상속
 *- 부모클래스의 필드/메소드를 자식클래스에게 물려주는 것
 * - 자식클래스는 선언없이 부모클래스의 필드/메소드를 사용할 수 있따.
 * -메소드를 재작성할 수 있다.
 * -자식클래스는 부모클래스를 확장한다 -> 물려받은 필드/메소드외에도 추가로 필드/메소드 작성이 가능하다.
 * public class 자식클래스 extends 부모클래스 {}
 * 모든 클래스의 최상위 클래스는 Object이다.
 *
 * 부모보다 자식클래스에 할 수 있는게 더 많아질 수 있음.
 * 상속은 단일 상속만 가능함.
 */
public class App {
    public static void main(String[] args) {
        // Parent 객체
        Parent parent = new Parent(); // 부모객체 생성
        parent.name = "홍길동";
        parent.age = 33;
        parent.introduce(); //자연스러움
        System.out.println(parent.info());
        //상속은 단방향이라서 parent에서 .game 찾으려해도 안나옴. 부모클래스는 자식클래스에 접근할 수 없음

        // Childe 객체
        Child child = new Child();
        child.name = "홍난파";
        child.age = 22;
        child.introduce(); // 오버라이드에서 자식입니다로 바꿈
        System.out.println(child.info());
        child.game();

        //GrandChilde 객체
        GrandChild grandChild = new GrandChild();
        grandChild.name = "홍진경";
        grandChild.age = 15;
        grandChild.introduce();     //바로 윗부모로 부터 물려 받음
        grandChild.game();
        System.out.println(grandChild.info());

    }
}
