package com.ssg.test.classObject.problem2;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("학년을 입력하세요: ");
        int grade = Integer.parseInt(scanner.nextLine());
        System.out.print("반를 입력하세요: ");
        int classroom = Integer.parseInt(scanner.nextLine());
        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.print("키를 입력하세요: ");
        double height = scanner.nextDouble();
        System.out.print("성별을 입력하세요: ");
        char gender = scanner.next().charAt(0);
        StudentVo student =  new StudentVo(grade, classroom, name, height, gender);
        student.printInformation();
    }
}
