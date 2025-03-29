package com.sh.dto;

public class MemberDto {
    private long id;
    private String name;
    private int age;
    private char gender;
    private double height;
    private double weight;
    private  boolean enabled;

    // this non-static메소드안에서 현재 객체를 가리키는 숨은 참조변수
    // setter : set + 대문자로 시작하는 필드명, 필드와 동일한 자료형의 매개변수, void 리턴타입
    // getter : get + 대문자로 시작하는 필드명, 매개변수 없음. 필드와 동일한 리턴타입


    // 그냥 무조건 만들어 안 쓸 수도 있지만 다 만들어
    // 이건 근데 캡슐화 원칙에 위배가 됨 setter가 값 다 바꾸거든
    // 데이터 담고 쓰기위해 씀

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    //age

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }

    // char gender

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getGender(){
        return this.gender;
    }

    //    double height;
    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight(){
        return  this.height;
    }



    //    double weight;
    public void setWeight(double weight){
        this.weight = weight;
    }
    public  double getWeight() {
        return this.weight;

    }

    //    boolean enabled;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     *
     * boolean형에 대한 getter는 관례적으로 is로 시작한다.
     * @return
     */

    public boolean isEnabled(){
        return this.enabled;
    }

}
