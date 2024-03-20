package com.sh.dto;

public class MemberDto {
    private long id;
    private String name;
    private int age;
    private char gender;
    private double height;
    private  double weight;
    private  boolean enabled;

    // this non - static 메서드안에서 현재객체를 가리키는 숨은 참조변수
    // setter : set + 대문자로 시작하는 필드명, 필드와 동일한 자료형의 매개변수, void 리턴타입
    // getter : get + 대문자로 시작하는 필드명, 매개변수 없음, 필드와 동일한 리턴타입

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

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
// boolean getter만 is로 시작
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
