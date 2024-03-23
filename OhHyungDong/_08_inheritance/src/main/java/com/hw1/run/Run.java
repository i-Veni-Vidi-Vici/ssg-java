package com.hw1.run;

import com.hw1.run.model.dto.Employee;
import com.hw1.run.model.dto.Student;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //학생 정보 등록
        Student s = new Student();
        Student[] stu = new Student[3];
        stu[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
        stu[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
        stu[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");

        // 사원정보 등록
        int index = 0;
        Employee[] emp = new Employee[10];


        //학생 정보 입력 및 출력
        String str = s.information();
        System.out.print(str);
        for(Student student : stu)
        {
            System.out.printf("%s  %d\t %.1f\t %.1f\t %d\t %s\t ",
                                student.getName(), student.getAge(), student.getHeight(),
                                student.getWeight(),student.getGrade(),student.getMajor());
            System.out.println();
        }

        //사원 정보 입력 및 출력
            String string = """
             =======================================
             y. 사원들의 정보 입력
             n. 입력된 사원 정보 확인
             x. 종료
             입력 :""";
        while(true){
            System.out.println(string);
            char ch1 = scanner.next().charAt(0);
            switch (ch1){
                case 'Y':
                case 'y':
                    if(index < 10){
                        emp[index] = new Employee();
                        emp[index].Input();
                        index++;
                    }
                    else{
                        System.out.println("사원 정보가 가득 차 있습니다.");
                    }
                    break;
                case 'N':
                case 'n':
                    boolean b = false;
                    for(Employee employee : emp)
                    {
                        if(employee != null) {
                            b = true;
                            String e =employee.information();
                            System.out.print(e);
                            System.out.printf("%s  %d\t %.1f\t %.1f\t %d\t %s\t ",
                                    employee.getName(), employee.getAge(), employee.getHeight(),
                                    employee.getWeight(), employee.getSalary(), employee.getDept());
                            System.out.println();
                            break;
                        }
                        else System.out.println("저장된 회원정보가 없습니다.");

                    }
                case 'x': continue;
                default:
                    System.out.println("문자를 다시 입력해주세요. ");
                    break;
            }

        }

    }
}
