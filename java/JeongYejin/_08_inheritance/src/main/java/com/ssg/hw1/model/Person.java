package com.ssg.hw1.model;

import java.awt.event.WindowFocusListener;

public class Person {
    private String name;
    private int age;
    private double height;
    private double weight;

    public Person() {
    }

    public Person(int age, double height, double weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String information() {
        String str = "%s  %d   %.1f   %.1f".formatted(this.getName(), this.getAge(), this.getHeight(), this.getWeight());
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
