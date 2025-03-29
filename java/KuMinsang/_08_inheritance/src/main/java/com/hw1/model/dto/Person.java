package com.hw1.model.dto;

public class Person {
    protected String name;
    private int age;
    private double height;
    private double weight;

    public Person() {   //기본생성자
    }

    public Person(int age, double height, double weight) {  //매개변수 생성자
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String information(){

        return String.format("%d 살, %.1fcm, %.1fkg, ", age, height, weight);
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
