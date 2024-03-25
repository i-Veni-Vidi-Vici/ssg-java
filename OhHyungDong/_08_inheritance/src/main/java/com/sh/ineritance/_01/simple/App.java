package com.sh.ineritance._01.simple;

/**
 * <pre>
 *  상속(inheritance)
 *  - 부모클래스의 필드/메소드 자산을 자식클래스에게 물려주는 것
 *  - 자식 클래스는 선언없이 부모클래스의 필드/메소드를 사용할 수 있다.
 *  - 메소드를 재작성 할 수 있다.
 *  - 모든 클래스의 최상위 클래스는 Object
 *
 *  - 자식 클래스는 부모 클래스를 확장한다 -> 물려받은 필드/메소드 외에도 추가로 필드/메소드 작성이 가능하다.
 *  - public class 자식클래스 extends 부모 클래스
 *
 *
 * </pre>
 *
 */
public class App {
    public static void main(String[] args) {
        //Parent객체
        Parent parent = new Parent();
        parent.name = "홍길동";
        parent.age = 33;
        parent.introduce();

        System.out.println(parent.info());

        //Child 객체
        Child child = new Child();
        child.name = "홍난파" ;
        child.age = 22;
        child.introduce();
        System.out.println(child.info());

        //grandcchildrorcp
        GrandChild grandChild = new GrandChild();
        grandChild.name = "홍동동";
        grandChild.age = 15;
        grandChild.introduce();
        System.out.println(grandChild.info());
    }
}
