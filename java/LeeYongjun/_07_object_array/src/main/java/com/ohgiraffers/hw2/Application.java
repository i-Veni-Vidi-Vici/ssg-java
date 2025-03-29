package com.ohgiraffers.hw2;




import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        StudentDTO students[];
        students = new StudentDTO[10];

        for(StudentDTO studentDTO: students){
            studentDTO.information();
        }
    }
}
