package com.ohgiraffers.hw1.run;

import com.ohgiraffers.hw1.model.dto.EmployeeDTO;

public class Application {
    public static void main(String[] args) {
        // 객체배열을 크기 3으로 할당 한 뒤 3개의 생성자를 각각 이용하여 객체 생성 후 출력
        EmployeeDTO[] employeeDTO = new EmployeeDTO[3];
        double annualIncome; // 연봉
        double avgAnnualIncome = 0; // 연봉평균

        employeeDTO[0] = new EmployeeDTO();
        employeeDTO[1] = new EmployeeDTO( 1, "홍길동", null, null, 19, 'M', 0, 0.0, "01022223333", "서울 잠실");
        employeeDTO[2] = new EmployeeDTO( 2, "강말순", "교육부", "강사", 20, 'F', 1000000, 0.01, "01011112222", "서울 마곡");

        for(int i=0;i< employeeDTO.length;i++){
            System.out.println("emp[" + i + "] : " + employeeDTO[i].information());
        }
        System.out.println("=================================================================");

        // 3개의 객체 중 값이 없는 필드에 각각 값을 넣은 뒤 출력
        employeeDTO[0].setEmpName("김말똥");
        employeeDTO[0].setDept("영업부");
        employeeDTO[0].setJob("팀장");
        employeeDTO[0].setAge(30);
        employeeDTO[0].setGender('M');
        employeeDTO[0].setSalary(3000000);
        employeeDTO[0].setBonusPoint(0.2);
        employeeDTO[0].setPhone("01055559999");
        employeeDTO[0].setAddress("전라도 광주");

        employeeDTO[1].setDept("기획부");
        employeeDTO[1].setJob("부장");
        employeeDTO[1].setSalary(4000000);
        employeeDTO[1].setBonusPoint(0.3);

        for(int i=0;i< employeeDTO.length-1;i++){
            System.out.println("emp[" + i + "] : " + employeeDTO[i].information());
        }
        System.out.println("=================================================================");

        // 직원 각각의 보너스가 적용된 1년 연봉을 계산하여 출력
        // 연봉 = (급여 + (급여 * 보너스포인트)) * 12

        for(int i=0;i< employeeDTO.length;i++){
            annualIncome = (employeeDTO[i].getSalary() + (employeeDTO[i].getSalary() * employeeDTO[i].getBonusPoint()))*12;
            avgAnnualIncome += annualIncome;
            System.out.printf("%s의 연봉 : %.0f원\n",employeeDTO[i].getEmpName(),annualIncome);
        }
        System.out.println("=================================================================");

        // 3명의 직원의 연봉 평균을 구하여 출력

        System.out.printf("직원들의 연봉의 평균 : %.0f원",avgAnnualIncome/3);
    }
}
