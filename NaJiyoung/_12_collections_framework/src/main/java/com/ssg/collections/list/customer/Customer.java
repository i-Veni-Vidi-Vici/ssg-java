package com.ssg.collections.list.customer;

public class Customer {
    private String name;
    private int age;
    private char gender;
    private double point;

    public Customer() {}
    public Customer(String name, int age, char gender, double point) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.point = point;
    }
    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", age=" + age + ", gender=" + gender + ", point=" + point + "]";
    }
}
