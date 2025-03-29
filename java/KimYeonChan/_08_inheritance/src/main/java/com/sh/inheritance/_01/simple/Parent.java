package com.sh.inheritance._01.simple;

public class Parent {
    String name;
    int age;

    public void introduce() {
        System.out.println("부모");
    }

    public String info() {
        return this.name + ", " + this.age;
    }
}
