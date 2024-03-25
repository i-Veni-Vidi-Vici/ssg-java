package com.sh.level02.normal.student;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int grade;
        int classroom;
        String name;
        double height;
        char gender;
        String gen;

        System.out.print("학년을 입력하세요 : ");
        grade = scan.nextInt();
        System.out.print("반을 입력하세요 : ");
        classroom = scan.nextInt();
        System.out.print("이름을 입력하세요 : ");
        name = scan.next();
        System.out.print("키를 입력하세요 : ");
        height = scan.nextDouble();
        System.out.print("성별을 입력하세요 : ");
        gen = scan.next();
        gender = gen.charAt(0);


        //스캐너로 학생 정보를 모두 입력 받아 모든 필드를 초기화 하는 생성자로 인스턴스 생성 후 모든 필드 정보를 출력하는
        // printInformation() 메소드 호출하여 출력
        StudentVO studentVO = new StudentVO(grade,classroom,name,height,gender);
        studentVO.printInfo(studentVO);

    }
}
