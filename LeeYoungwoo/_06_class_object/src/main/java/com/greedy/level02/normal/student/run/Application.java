package com.greedy.level02.normal.student.run;

import com.greedy.level02.normal.student.model.vo.StudentVO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //스캐너로 학생 정보를 모두 입력 받아 모든 필드를 초기화하는 생성자로 인스턴스 생성 후
        //모든 필드 정보를 출력하는 printInformation() 메소드 호출하여 출력
        Scanner sc = new Scanner(System.in);

        System.out.print("> grade 입력 : ");
        int grade = sc.nextInt();
        System.out.print("> classroom 입력 : ");
        int classroom = sc.nextInt();
        System.out.print("> name 입력 : ");
        String name = sc.next();
        System.out.print("> height 입력 : ");
        double height = sc.nextDouble();
        System.out.print("> gender 입력 : ");
        char gender = sc.next().charAt(0);

        StudentVO studentVO = new StudentVO(grade, classroom, name, height, gender);
        studentVO.printInformation();


    }
}
