package com.sh.dto;

public class MemberDto {
    private  double weight;
    private  double height;
    private boolean enabled;
    private String name;
    private long id;
    private int age;
    private char gender;

    public char getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    /**
     *boolean형에 대한 getter는 관례적으로 is로 시작한다
     */

    public boolean isEnabled() {
        return enabled;
    }

    public double getWeight() {
        return weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
