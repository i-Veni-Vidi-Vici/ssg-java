package com.ssg.oop.calc.member.model.vo;
import com.ssg.oop.calc.member.model.vo.Buyable;
public abstract class Member implements Buyable{
    private String name;
    private String grade;
    private double point;

    public Member() {
    }

    public Member(String name, String grade, double point) {
        this.name = name;
        this.grade = grade;
        this.point = point;
    }
    public abstract double getEjapoint();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public int buy(int price) {
        double rate = 0;
        if(getGrade() == "Silver"){
            rate = 0.02;
        }
        else if(getGrade() == "Gold"){
            rate = 0.05;
        }
        else if(getGrade() == "Vip"){
            rate = 0.1;
        }
        else if(getGrade() == "Vvip"){
            rate = 0.15;
        }
        else rate = 0.3;

        return (int)(price- (price * rate));
    }
}
