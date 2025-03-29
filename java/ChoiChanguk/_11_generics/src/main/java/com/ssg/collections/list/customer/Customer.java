package com.ssg.collections.list.customer;

import java.util.Comparator;

public class Customer implements Comparator<Customer> {
    String name;
    int age;
    String gender;
    double point;

    public Customer() {
    }

    @Override
    public String toString() {
        return  name + " " + age+ " "  + gender + " "  + point +"\n";
    }

    @Override
    public int  compare(Customer o1, Customer o2) {
        return o1.getName().compareTo(o2.getName());
    }


    public Customer(String name, int age, String gender, double point) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.point = point;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
}
