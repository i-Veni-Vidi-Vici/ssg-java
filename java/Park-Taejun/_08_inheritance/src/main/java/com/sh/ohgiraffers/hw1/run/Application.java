package com.sh.ohgiraffers.hw1.run;

import com.sh.ohgiraffers.hw1.model.dto.EmployeeDTO;
import com.sh.ohgiraffers.hw1.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        StudentDTO[] stu = new StudentDTO[3];

        stu[0] = new StudentDTO("홍길동", 20, 178.2, 70, 1, "정보시스템공학과");
        stu[1] = new StudentDTO("김말똥", 21, 187.3, 80, 2, "경영학과");
        stu[2] = new StudentDTO("강개순", 23, 167.0, 45, 4, "정보통신공학과");

        for (StudentDTO s : stu) {// 배열 stu에 있는 StudentDTO 객체들을 반복처리하는 루프
            // 향상된 FOR루프 또는 for-each루프라고도 불림,
            System.out.println(s.information());
        }

        Scanner scanner = new Scanner(System.in);

        EmployeeDTO emp[] = new EmployeeDTO[10];
        int count = 0;

        while (true){
            System.out.println("이름 : ");
            String name = scanner.nextLine();
            System.out.println("나이 :");
            int age = scanner.nextInt();
            System.out.println("키 : ");
            double height = scanner.nextDouble();
            System.out.println("몸무게 : ");
            double weight = scanner.nextDouble();
            System.out.println("급여 : ");
            int salary = scanner.nextInt();
            scanner.nextLine();

            System.out.println("부서 : ");
            String dept = scanner.nextLine();

            emp[count] = new EmployeeDTO(name, age, height, weight, salary, dept);
            count++;

            System.out.println("게속 입력  ? (y/n) : ");
            char ch = scanner.nextLine().toUpperCase().charAt(0);

            if(ch == 'N'){
                break;
            }
        }
            for (int i= 0; i <count; i++){
                System.out.println(emp[i].information());
            }
    }
}
