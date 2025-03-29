package com.ssg.constructor;

import java.util.Scanner;

public class App2 {

    public static void main(String[] args) {
        // 스캐너로 학생 정보를 모두 입력 받아 모든 필드를 초기화하는 생성자로 인스턴스 생성 후
        // 모든 필드 정보를 출력하는 printInformation() 메소드 호출하여 출력
        Scanner sc = new Scanner(System.in);
        System.out.print("학년 입력 : ");
        int grade = sc.nextInt();
        System.out.print("반 입력 : ");
        int classroom = sc.nextInt();
        System.out.print("이름 입력 : ");
        String name = sc.next();
        System.out.print("키 입력 : ");
        double height = sc.nextDouble();
        System.out.print("성별 입력 : ");
        char gender = sc.next().charAt(0);

        StudentVO studentVo = new StudentVO(grade, classroom, name, height, gender);
        studentVo.printInformation(studentVo);
    }
}
