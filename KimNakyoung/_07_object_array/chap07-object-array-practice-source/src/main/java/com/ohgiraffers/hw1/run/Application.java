package com.ohgiraffers.hw1.run;

import com.ohgiraffers.hw1.model.dto.EmployeeDTO;

public class Application {
    public static void main(String[] args) {

        //객체배열을 크기 3으로 할당 한 뒤 3개의 생성자를 각각 이용하여 객체 생성 후 출력

        EmployeeDTO[] employeeDTOS;
        employeeDTOS = new EmployeeDTO[3]; // 객체배열 3으로 할당

        employeeDTOS[0] = new EmployeeDTO();
        employeeDTOS[1] = new EmployeeDTO(1,"홍길동",19,'M',"01022223333","서울 잠실");
        employeeDTOS[2] = new EmployeeDTO(2,"강말순","교육부","강사",20,'F',1000000,0.01,"01011112222","서울 마곡");


        for (int i = 0; i < employeeDTOS.length; i++) {
            System.out.print("emp["+ i + "] : " );
            employeeDTOS[i].information();
        }

        System.out.println("----------------------------------------------------");

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

        employeeDTOS[1].setDept("영업부");
        employeeDTOS[1].setJob("부장");
        employeeDTOS[1].setSalary(4000000);
        employeeDTOS[1].setBonusPoint(0.3);

        for (int i = 0; i < employeeDTOS.length-1; i++) {
            System.out.print("emp["+ i + "] : " );
            employeeDTOS[i].information();
        }

        System.out.println("-----------------------------------");
        int salary = 0;
        double bonus = 0;
        int totalSalary =0;
        int sumSalary = 0;



        for (int i = 0; i < employeeDTOS.length; i++) {
            System.out.print(employeeDTOS[i].getEmpName()+"의 연봉 : ");
            salary = employeeDTOS[i].getSalary();
            bonus = employeeDTOS[i].getBonusPoint();


            totalSalary = (int)((salary + (salary * bonus)) * 12); // 정수로 출력하기 위해
            sumSalary += totalSalary;

            System.out.println(totalSalary + "원");
//            System.out.println(totalSalary); // 자릿수가 너무 많아서 출력이 제대로 안됨(double로 받을 때)

        }System.out.println("-------------------------------------");
        int avgSalary = (sumSalary / employeeDTOS.length);

        System.out.println("직원들의 연봉의 평균 : "+ avgSalary + "원") ;






        // 직원 각각의 보너스가 적용된 1년 연봉을 계산하여 출력
        // 연봉 = (급여 + (급여 * 보너스포인트)) * 12

        // 3명의 직원의 연봉 평균을 구하여 출력





    }
}
