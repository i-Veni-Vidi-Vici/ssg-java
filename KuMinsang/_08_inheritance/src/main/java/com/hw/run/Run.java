package com.hw.run;

import com.hw1.model.dto.Employee;
import com.hw1.model.dto.Student;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 3명의 학생 정보를 기록할 수 있게 객체 배열 할당
        Student[] student = new Student[3];
        // 위의 사용데이터 참고하여 3명의 학생 정보 초기화
        student[0] = new Student("홍길동", 20, 178.2,70.0, 1, "정보시스템공학과");
        student[1] = new Student("김말똥", 21, 187.3,80.0, 2, "경영학과");
        student[2] = new Student("강개순", 23, 167.0,45.0, 4, "경영학과");
        // 위의 학생 정보 모두 출력 --> 향상된 for문 이용해서
        for (Student stu : student){
            System.out.println(stu.information());
        }
        // 최대 10명의 사원 정보를 기록할 수 있게 배열을 할당
        Employee[] employee = new Employee[10];
        // 사원들의 정보를 키보드로 계속 입력 받고 --> while(true) 무한 반복문을 통해
        int index = 0;
        employee[index++] = new Employee("박보검", 26, 180.3, 72.0, 100000000, "영업부");
        employee[index++] = new Employee("강동원", 38, 182.0, 76.0, 200000000, "기획부");

        while(true){
            System.out.println("사원정보를 입력하세요");
            employee[index] = new Employee();
            System.out.print("\n 이름: ");
            employee[index].setName(sc.next());
            System.out.print("\n 나이: ");
            employee[index].setAge(sc.nextInt());
            System.out.print("\n 신장: ");
            employee[index].setHeight(sc.nextDouble());
            System.out.print("\n 체중: ");
            employee[index].setWeight(sc.nextDouble());
            System.out.print("\n 월급: ");
            employee[index].setSalary(sc.nextInt());
            System.out.print("\n 부서: ");
            employee[index].setDept(sc.next());
            index++;

            // 계속 추가할 것인지 물어보고, 대소문자 상관없이 ‘y’이면 계속 객체 추가
            System.out.print("\n 계속 하시겠습니까?");
            int flag =sc.next().charAt(0);
            if((flag!='y')&&flag!='Y')
                break;
        }

        for(Employee emp : employee){
            if(emp == null)
                break;
            System.out.println(emp.information());
        }


        // 한 명씩 추가 될 때마다 카운트함
        // 2명 정도의 사원 정보를 입력 받아 객체 배열에 저장
        // 현재 기록된 사원들의 정보를 모두 출력


    }
}
