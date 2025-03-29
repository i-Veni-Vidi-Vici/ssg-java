package com.sh.inheritance._01.simple;

/**
 * <pre>
 * 상속 (inheritance)
 * - 부모클래스의 필드/메소드를 자식클래스에게 물려주는 것
 * - 자식클래스는 선언없이 부모클래스의 필드/메소드를 사용할 수 있음
 * - 메소드를 재작성 할 수 있음 (재작성한 메소드가 우선순위 높음 -> 출력)
 * - 자식클래스는 부모클래스를 확장함 : 물려받은 필드/메소드 외에도 추가로 필드/메소드 작성 가능
 * - public clss 자식클래스 extends 부모클래스 {} <- 부모클래스는 하나만 지정 가능
 * - 손자클래스는 자식클래스를 상속하면 부모클래스도 자동상속함
 * - 모든 클래스의 최상위 클래스는 Object
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // Parent 객체
        Parent parent = new Parent();
        parent.name = "홍길동";
        parent.age = 33;
        parent.introduce(); // 메소드 안에 sout 있음
        System.out.println(parent.info()); // 메소드 안에 sout 없어서 sout 안에 메소드 넣어서 출력
//        parent.game(); // 상속은 단방향 -> 부모클래스는 자식클래스에 접근할 수 없음

        // Child 객체
        Child child = new Child();
        child.name = "홍난파";
        child.age = 22;
        child.introduce();
        System.out.println(child.info());
        child.game();

        // GrandChild 객체
        GrandChild grandChild = new GrandChild();
        grandChild.name = "홍진경";
        grandChild.age = 15;
        grandChild.introduce(); // 재작성 안하면 바로 윗부모클래스의 "자식이다"가 상속됨
        System.out.println(grandChild.info());
        grandChild.game();
    }
}
