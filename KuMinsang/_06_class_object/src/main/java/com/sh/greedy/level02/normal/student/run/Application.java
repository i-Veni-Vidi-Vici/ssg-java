package com.sh.greedy.level02.normal.student.run;

import com.sh.greedy.level02.normal.student.model.vo.StudentVO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("학년 , 반, 이름, 키, 성별 을 차래대로 입력하시오.");
        StudentVO student = new StudentVO(sc.nextInt(), sc.nextInt(), sc.next(),sc.nextDouble(),sc.next().charAt(0) );
        student.printInformation();

    }
}
