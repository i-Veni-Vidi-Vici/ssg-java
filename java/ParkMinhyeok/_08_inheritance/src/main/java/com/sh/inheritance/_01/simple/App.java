package com.sh.inheritance._01.simple;

public class App {
    public static void main(String[] args) {
        // Parent 객체
        Parent parent = new Parent();
        parent.name = "홍길동";
        parent.age = 33;
        parent.introduce();
        System.out.println(parent.info());

        // Child
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
        grandChild.introduce();
        System.out.println(grandChild.info());
        grandChild.game();

    }
}
