package com.sh.dto;

public class MemberDto {
    private long id;
    private String name;
    private int age;
    private char gender;
    private double height;

    private double weight;
    private boolean enabled;


    // this non-static메소드 안에서 현재객체를 가리키는 숨은 참조변수
    // 설정자 setter : set + 대문자로 시작하는 필드명, 필드와 동일한 자료형의 매개변수를 가지고,
    //void 리턴타입
    // 읽어오는 용도 getter : get + 대문자로 시작하는 필드면, 매개변수 없음. 필드와 동일한 리턴타입
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }
    public void setName(String name) {
        this.name = name; // 외부토부터 받음
    }
    public String getName() {
        return this.name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setGender(char gender) {
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
    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }
    public boolean getEnabled() {
        return this.enabled;
    }
}
