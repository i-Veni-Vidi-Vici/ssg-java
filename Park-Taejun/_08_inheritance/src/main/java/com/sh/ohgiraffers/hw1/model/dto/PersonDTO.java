package com.sh.ohgiraffers.hw1.model.dto;

public class PersonDTO {

    protected String name; // protected로 선언하면 클래스의 하위 클래스에서는 접근 가능
    private int age;
    private double height;
    private double weight;

    public PersonDTO(){
        // public PersonDTO () 라인은 생성자를 정의함.
        // 생성자는 객체를 초기화하고 만들 떄 호출되는 특별한 메서드임.
        //이 생성자의 목적은 기본적으로 객체를 생성할 때 필드를 초기화 하는것

    }
    public PersonDTO(int age, double height, double weight){

        this.age = age;
        this.height = height;
        this.weight = weight;
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
    public String information(){
        return "name = " + name +", age = " + age + ", height =" + height + ",weight =" + weight;
    }
}




