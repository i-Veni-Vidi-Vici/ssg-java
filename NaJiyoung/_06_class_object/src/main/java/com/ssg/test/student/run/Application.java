package com.ssg.test.student.run;

import com.ssg.test.student.model.vo.StudentVO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // 스캐너로 학생 정보를 모두 입력 받아 모든 필드를 초기화하는 생성자로 인스턴스 생성 후
        Scanner sc = new Scanner(System.in);
        System.out.print("학년 : ");
        int grade = sc.nextInt();
        System.out.print("반 : ");
        int classroom = sc.nextInt();
        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("키 : ");
        double height = sc.nextDouble();
        System.out.print("성별 : ");
        char gender = sc.next().charAt(0);
        System.out.println();

        StudentVO studentVO = new StudentVO(grade, classroom, name, height, gender);

        // 모든 필드 정보를 출력하는 printInformation() 메소드 호출하여 출력
        studentVO.printInformation();


    }
}
