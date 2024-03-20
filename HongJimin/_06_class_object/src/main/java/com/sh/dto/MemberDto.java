package com.sh.dto;

public class MemberDto { //외부 접근 X
    private long id;
    private String name;
    private int age;
    private char gender;
    private double height;
    private double weight;
    private boolean enabled;

    //this non-static 메소드 안에서 현재 객체를 가리키는 숨은 참조변수
    //Setter : set + 대문자로 시작하는 필드명, 필드와 동일한 자료형의 매개변수, void 리턴타입을 가짐
    //Getter : get + 대문자로 시작하는 필드명, 매개변수는 없음. 필드와 동일한 리턴타입을 받음

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

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    public char getGender() {
        return this.gender;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() { //boolean만 get이 is로 표현됨!
        return enabled;
    }


}


