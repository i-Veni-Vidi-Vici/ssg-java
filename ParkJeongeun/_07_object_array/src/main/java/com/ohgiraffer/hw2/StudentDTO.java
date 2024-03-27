package com.ohgiraffer.hw2;

public class StudentDTO {
    private int grade;
    private int classroom;
    private String name;
    private int kor;
    private int eng;
    private int math;

    public StudentDTO(){}
    public StudentDTO(int grade, int classroom, String name, int kor, int eng, int math){
        this.grade = grade;
        this.classroom = classroom;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

//    void String information(){
//        String result = """
//                학년  반   이름  국어점수    영어점수    수학점수
//                 %d  %d   %s     %d         %d         %d
//                 %d  %d   %s     %d         %d         %d
//                 %d  %d   %s     %d         %d         %d
//                """;
//        return result;
//    }


}
