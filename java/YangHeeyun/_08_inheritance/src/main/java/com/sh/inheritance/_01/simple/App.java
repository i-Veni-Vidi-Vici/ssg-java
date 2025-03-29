package com.sh.inheritance._01.simple;

/**
 * <pre>
 *  상속 (inheritance)
 *  - 부모클래스의 필드/메소드를 자식클래스에게 물려주는 것.
 *  - 자식클래스는 선언없이 부모클래스의 필드/메소드를 사용할 수 있다.
 *  - 매소드를 재작성할 수 있다.
 *  - 단일상속만 가능하다.(한번에 하나의 클래스만 상속할 수 있다)
 *  - 모든 클래스의 최상위클래스는 Object이다.(나중에 배울 내용)
 *
 *  - 자식클래스는 부모클래스를 확장한다 -> 물려받은 필드/메소드 외에도 추가로 필드/메소드 작성이 가능하다.
 *  - public class 자식클래스 extends 부모클래스 {}
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // Parent 객체
        Parent parent =  new Parent();
        parent.name = "홍길동";
        parent.age = 33;
        parent.introduce(); // 애비다~~
        System.out.println(parent.info()); //리턴값이므로 출력은 직접 해야한다.
//        parent.game // 상속은 단방향으로 부모클래스는 자식클래스에 접근할 수 없다.

        //Child 객체
        Child child = new Child();
        child.name="홍난파";
        child.age = 22;
        child.introduce(); // 애비다~~~ -> 자식입니다~~~
        System.out.println(child.info());
        child.game();

        // GrandChild 객체
        GrandChild grandChild = new GrandChild();
        grandChild.name ="홍진경";
        grandChild.age=15;
        grandChild.introduce(); // 자식입니다~~~ -> 손자입니다~~~
        System.out.println(grandChild.info());
        grandChild.game();
    }
}
