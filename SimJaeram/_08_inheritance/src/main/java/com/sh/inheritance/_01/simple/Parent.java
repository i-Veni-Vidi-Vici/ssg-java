package com.sh.inheritance._01.simple;

public class Parent {
    public String name;
    public int age;

    public void introduce() {
        System.out.println("애비다~~~~~~");
    }

    public String info() {
        return this.name + ", " + this.age;
    }

}
