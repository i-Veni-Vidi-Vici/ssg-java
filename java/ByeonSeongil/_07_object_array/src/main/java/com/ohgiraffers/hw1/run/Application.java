package com.ohgiraffers.hw1.run;

import com.ohgiraffers.hw1.model.dto.EmployeeDTO;

public class Application {
    public static void main(String[] args) {
        // 객체배열을 크기 3으로 할당 한 뒤 3개의 생성자를 각각 이용하여 객체 생성 후 출력
        EmployeeDTO[] employeeDTOS = new EmployeeDTO[]{
                new EmployeeDTO(),
                new EmployeeDTO(1, "홍길동", 19, 'M', "01022223333",
                        "서울 잠실"),
                new EmployeeDTO(2, "강말순", "교육부", "강사", 20, 'F',
                        1000000, 0.01, "01011112222", "서울마곡")
        };

        for (EmployeeDTO employeeDTO : employeeDTOS) {
            System.out.println(employeeDTO.information());
        }

        // 3개의 객체 중 값이 없는 필드에 각각 값을 넣은 뒤 출력
        employeeDTOS[0].setAddress("전라도");
        employeeDTOS[0].setAge(30);
        employeeDTOS[0].setEmpNo(0);
        employeeDTOS[0].setEmpName("김말똥");
        employeeDTOS[0].setGender('M');
        employeeDTOS[0].setPhone("01055559999");
        employeeDTOS[0].setDept("영업부");
        employeeDTOS[0].setJob("팀장");
        employeeDTOS[0].setSalary(3000000);
        employeeDTOS[0].setBonusPoint(0.2);

        employeeDTOS[1].setDept("기획부");
        employeeDTOS[1].setJob("부장");
        employeeDTOS[1].setSalary(4000000);
        employeeDTOS[1].setBonusPoint(0.3);

        System.out.println(employeeDTOS[0].information());
        System.out.println(employeeDTOS[1].information());

        int sum =0;
        // 직원 각각의 보너스가 적용된 1년 연봉을 계산하여 출력
        // 연봉 = (급여 + (급여 * 보너스포인트)) * 12
        for (EmployeeDTO employeeDTO : employeeDTOS) {
            int money =(int)((employeeDTO.getSalary() + (employeeDTO.getSalary() * employeeDTO.getBonusPoint())) * 12);
            sum += money;
            System.out.println(employeeDTO.getEmpName() + "의 연봉 : " + money+"원");
        }

        // 3명의 직원의 연봉 평균을 구하여 출력
        System.out.println("직원들의 연봉 평균: "+ (sum/3)+ "원");

    }
}
