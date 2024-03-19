package com.sh.dto;

public class MemberDto {
    // 필드 작성하면 그 필드를 쓰든 안쓰든 무조건 setter, getter 만듦
    // 여기서 기본값을 작성할 수도 있음 -> 위배됨
    private long id;
    private String name;
    private int age;
    private char gender;
    private double height;
    private double weight;
    private boolean enabled;

    // this non-static 메소드 안에서 현재 객체를 가리키는 숨은 참조변수
    // 설정자 setter : set + 대문자로 시작하는 필드명, 필드와 동일한 자료형의 매개변수, void 리턴타입을 가짐
    // 접근자 getter : get + 대문자로 시작하는 필드명, 매개변수 없음, 필드와 동일한 리턴타입 가짐
    // setter, getter : 각 필드를 제어할 수 있음

    // 외부로 받은 값을 설정
    public void setId(long id){
        this.id = id;
    }
    // setter를 읽기위한 getter
    public long getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    public void setGender(char gender){
        this.gender = gender;
    }
    public char getGender(){
        return this.gender;
    }

    public void setHeight(double height){
        this.height = height;
    }
    public double getHeight(){
        return this.height;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }
    public double getWeight(){
        return this.weight;
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }

    // boolean형에 대한 getter는 관계적으로 is로 시작 (getEnabled X)
    public boolean isEnabled(){
        return this.enabled;
    }
}
