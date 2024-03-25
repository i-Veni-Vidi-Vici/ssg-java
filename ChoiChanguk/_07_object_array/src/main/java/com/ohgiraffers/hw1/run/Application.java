package com.ohgiraffers.hw1.run;

import com.ohgiraffers.hw1.model.dto.EmployeeDTO;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        EmployeeDTO[] employeeDTOS=new EmployeeDTO[3];
        double income;
        double avgIncome=0;

        employeeDTOS[0]=new EmployeeDTO();
        employeeDTOS[1]=new EmployeeDTO(1,"홍길동",19,'F',"01022223333","서울 마곡");
        employeeDTOS[2]=new EmployeeDTO(2, "강말순","기획부","부장",19,'M',1000000,0.01,"01022223333","서울 잠실");

        for(int i=0;i<employeeDTOS.length;i++)
        {
            System.out.println(employeeDTOS[i].information());
        }

        System.out.println("------------------------------------------------");

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
        employeeDTOS[1].setJob("부장");
        employeeDTOS[1].setSalary(4000000);
        employeeDTOS[1].setBonusPoint(0.3);

        for(int i=0;i<employeeDTOS.length-1;i++)
        {
            System.out.println(employeeDTOS[i].information());
        }

        System.out.println("------------------------------------------------");

        for(int i=0;i<employeeDTOS.length;i++)
        {
            income=(employeeDTOS[i].getSalary()+(employeeDTOS[i].getSalary()*employeeDTOS[i].getBonusPoint()))*12;
            avgIncome+=income;
            System.out.printf("%s의 연봉 : %.0f원\n",employeeDTOS[i].getEmpName(),income);
        }

        System.out.println("------------------------------------------------");
        System.out.printf("직원들의 연봉의 평균 : %.0f원",avgIncome/3.0);

    }
}
