package com.ssg.test.problem2;

public class StudentDTO {
    private int grade, classroom,kor, eng, math;
    private String name;

    public StudentDTO() {
    }

    public StudentDTO(int grade, int classroom, String name,int kor, int eng, int math) {
        this.grade = grade;
        this.classroom = classroom;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.name = name;
    }

    public String info(){
        return "학년: " + this.grade + " 반: " + this.classroom + " 이름: "+ this.name + " 국어점수: "
                + this.kor + " 영어점수: "+this.eng+" 수학점수: "+ this.math;
    }
}
