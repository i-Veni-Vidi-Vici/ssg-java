package com.sh.inheritance._01.simple;

/**
 * 상속(inheritance)
 * -부모클래스의 필드메소드를 자식클래스에게 자산을 물려주는 것.
 * -자식클래스는 선언없이 부모클래스의 필드/메소드를 사용할 수 있다.
 * -메소드를 재작성할 수 있다.
 * -자식클래스는 부모클래스를 확장한다.--> 물려받은 필드 메소드외에도 추가로 필드/메소드 작성이 가능하다.
 * -public class 자식클래스 extends 부모클래스{}
 */
public class App {
    public static void main(String[] args) {
        //Parent객체
        Parent parent = new Parent();
        parent.name="홍길동";
        parent.age=33;
        parent.introduce();
        System.out.println(parent.info());
        //상속은 단방향이다. 부모클래스는 자식클래스에 접근할 수 없다.



        //Child 객체
        Child child = new Child();
        child.name="홍난파";
        child.age=22;
        child.introduce();
        System.out.println(child.info());
        child.game();
        //Grandchild 객체
        GrandChild grandChild = new GrandChild();
        grandChild.name="홍진경";
        grandChild.age=15;
        grandChild.introduce();
        System.out.println(grandChild.info());

    }
}
