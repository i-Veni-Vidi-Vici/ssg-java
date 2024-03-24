package com.hw1.model.dto;

public class Person {
    public String name;
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


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String informaition() {
        return null;
    }

    public void setAge(int age)
    {
        this.age=age;
    }
    public int getAge()
    {
        return this.age;
    }
    public void setHeight(double height)
    {
        this.height=height;
    }
    public double getHeight()
    {
        return this.height;
    }
}
