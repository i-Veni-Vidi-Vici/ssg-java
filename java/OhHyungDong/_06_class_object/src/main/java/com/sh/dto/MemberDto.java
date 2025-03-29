package com.sh.dto;

public class MemberDto {
    private long id;
    private String name;
    private int age;
    private char gender;
    private double height;
    private double weight;
    private boolean enabled;

    // this non-static 메소드 안에서 현재 객체를 가리키는 숨은 참조 변수
    //설정자 setter : set + 대문자로 시작하는 필드명 , 필드와 동일한 자료형의 매개변수를 가진다. void 리턴 타입을 가진다.
    //읽기 getter : get + 대문자로 시작하는 필드명 ,매개변수는 없고, 필드와 동일한 리턴타입을 가진다.

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    /**
     * boolean형에 대한 getter는 is로 시작한다.
     * @return
     */

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
