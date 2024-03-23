package com.greedy.level02.normal.student.model;

public class Application {
    public static void main(String[] args) {
        StudentVO student1 = new StudentVO();
        StudentVO student2 = new StudentVO(1,2,"홍길동",175.5,'남');
        student2.printInformation();
    }
}
