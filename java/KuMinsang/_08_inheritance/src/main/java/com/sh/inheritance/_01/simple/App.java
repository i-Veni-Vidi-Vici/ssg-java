package com.sh.inheritance._01.simple;

public class App {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.name = "홍길동";
        parent.age = 33;
        parent.introduce();
        System.out.println(parent.info());
//        parent.game(); 부모 클래스는 자식 클래스의 구현을 이용할수 없다


        Child child = new Child();
        child.name = "홍난파";
        child.age = 22;
        child.introduce();
        System.out.println(child.info());
        child.game();

        GrandChild grandchild = new GrandChild();
        grandchild.introduce();
        grandchild.game();
    }


}
