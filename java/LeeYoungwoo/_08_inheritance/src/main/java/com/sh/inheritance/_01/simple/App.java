package com.sh.inheritance._01.simple;

import java.util.GregorianCalendar;

/**
 * <pre>
 * 상속 (inheritance)
 * - 부모클래스의 필드/메소드를 자식에게 물려주는 것
 * - 자식클래스는 선언없이 부모클래스에 필드/메소드를 사용할 수 있다.
 * - 메소드를 재작성할 수 있다.
 * - 단일상속만 가능하다.
 * - 모든 클래스의 최상위 클래스는 Object이다. (부모클래스에서 extends로 상속받은게 없어도 자동으로 object를 상속받은것이 생략되어있다.)
 * - 자식클래스는 부모클래스를 확장한다. -> 물려받은 필드/메소드 외에도 추가로 필드/메소드 작성이 가능하다.
 * - public class 자식클래스 extends 부모클래스 {}
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // Parent 객체
        Parent parent = new Parent();
        parent.name = "홍길동";
        parent.age = 27;
        parent.introduce();
        System.out.println(parent.info());
//        parent.game(); // 상속은 단방향, 부모클래스는 자식클래스에 접근할 수 없다.
        System.out.println();

        // Child 객체
        Child child = new Child();
        child.name = "배고파";
        child.age = 26;
        child.introduce(); // 애비다~~~~~ ---> 자식입니다~~~~
        System.out.println(child.info());
        child.game();
        System.out.println();

        // GrandChild 객체
        GrandChild grandChild = new GrandChild();
        grandChild.name = "뭐먹지";
        grandChild.age = 25;
        grandChild.introduce(); // 자식입니다~~~~ ---> 손자입니다~~~~
        System.out.println(grandChild.info());
        grandChild.game();
    }
}
