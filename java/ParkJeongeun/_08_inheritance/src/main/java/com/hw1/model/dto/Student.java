package com.hw1.model.dto;

public class Student extends Person{
    private int grade;
    private String major;

    public Student(){}

    public Student(String name, int age, double height, double weight, int grade, String major) {
        super(age, height, weight);
        this.name = name;
        this.grade = grade;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + super.getAge() +
                ", height=" + super.getHeight() +
                ", weight=" + super.getWeight() +
                ", grade=" + grade +
                ", major='" + major + '\'' +
                '}';
    }

    public String information(){
        String result = """
                이름    나이   신장    몸무게     학년    전공
                %s    %d   %.1f    %.1f     %d    %s
                """.formatted(name, getAge(), getHeight(), getWeight(), grade, major);
        return result;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
