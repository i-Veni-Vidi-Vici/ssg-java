package com.ssg.hw1.run;

import com.ssg.hw1.model.dto.Student;

import java.sql.Struct;

public class Run {
    public static void main(String[] args) {
        Student[] students = new Student[3];

        students[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
        students[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
        students[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");


        System.out.println("""
                =================================================
                    이름    나이    신장    몸무게   학년    전공
                -------------------------------------------------
                """);
        for (Student student : students) {
            System.out.println(student.information());
        }
//        for (int i = 0; i < students.length; i++) {
//            System.out.println(student);
//        }

    }
}
