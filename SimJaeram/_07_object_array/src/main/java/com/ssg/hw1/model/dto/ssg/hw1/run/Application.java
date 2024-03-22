package com.ssg.hw1.model.dto.ssg.hw1.run;

import com.ssg.hw1.model.dto.EmployeeDTO;

public class Application {
    public static void main(String[] args) {
        long annualIncome = 0;
        double annualIncomeSum = 0.0;
        double annualIncomeAverage = 0.0;

        // 객체배열을 크기 3으로 할당 한 뒤 3개의 생성자를 각각 이용하여 객체 생성 후 출력
        EmployeeDTO[] employeeDTOS = new EmployeeDTO[3];
        employeeDTOS[0] = new EmployeeDTO();
        employeeDTOS[1] = new EmployeeDTO(1, "홍길동", 19, 'M', "01022223333", "서울 잠실");
        employeeDTOS[2] = new EmployeeDTO(2, "강말순", "교육부", "강사", 20, 'F', 1000000, 0.01, "01011112222", "서울 마곡");

        // 출력
        for(int i = 0; i < employeeDTOS.length; i++) {
            System.out.println(employeeDTOS[i].information());
        }
        System.out.println("=================================================================");

        // 3개의 객체 중 값이 없는 필드에 각각 값을 넣은 뒤 출력
        employeeDTOS[0].setEmpNo(0);
        employeeDTOS[0].setEmpName("김말똥");
        employeeDTOS[0].setDept("영업부");
        employeeDTOS[0].setJob("팀장");
        employeeDTOS[0].setAge(30);
        employeeDTOS[0].setGender('M');
        employeeDTOS[0].setSalary(3000000);
        employeeDTOS[0].setBonusPoint(0.2);
        employeeDTOS[0].setPhone("01055559999");
        employeeDTOS[0].setAddress("전라도 광주");

        employeeDTOS[1].setDept("기획부");
        employeeDTOS[1].setJob("기획부");
        employeeDTOS[1].setSalary(4000000);
        employeeDTOS[1].setBonusPoint(0.3);

        System.out.println(employeeDTOS[0].information());
        System.out.println(employeeDTOS[1].information());
        System.out.println("=================================================================");

        // 직원 각각의 보너스가 적용된 1년 연봉을 계산하여 출력
        // 연봉 = (급여 + (급여 * 보너스포인트)) * 12
        for(int i = 0; i < employeeDTOS.length; i++) {
            annualIncome = (long) (employeeDTOS[i].getSalary() + (employeeDTOS[i].getSalary() * employeeDTOS[i].getBonusPoint())) * 12;
            System.out.println(employeeDTOS[i].getEmpName() + "의 연봉 : " + annualIncome + "원");
            annualIncomeSum += annualIncome;
        }
        System.out.println("=================================================================");

        // 3명의 직원의 연봉 평균을 구하여 출력
        annualIncomeAverage = annualIncomeSum / employeeDTOS.length;
        System.out.println("직원들의 연봉의 평균 : %.0f원".formatted(annualIncomeAverage));
    }
}
