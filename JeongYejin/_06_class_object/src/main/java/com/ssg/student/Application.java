package com.ssg.student;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentVO studentVO = new StudentVO(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextDouble(), sc.next().charAt(0));
        studentVO.printInformation(studentVO);
    }
}
