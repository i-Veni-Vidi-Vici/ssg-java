package com.hw1.run;

public class Employee {
    private int salary; // 급여
    private String dept; // 부서\

    private String name;
    private int age;
    private double height;
    private double weight;

    public Employee() {
    }

    public Employee(int age, double height, double weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String information(){

    }
    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }
}
