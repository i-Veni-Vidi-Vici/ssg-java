package com.ohgiraffers.hw1.run;

import com.ohgiraffers.hw1.model.dto.EmployeeDTO;

public class Application {
    public static void main(String[] args) {
        EmployeeDTO[] emp = new EmployeeDTO[3];


        emp[0] = new EmployeeDTO();
        emp[1] = new EmployeeDTO(1,"홍길동",17,'F',"010","서울 ");
        emp[2] = new EmployeeDTO(2, "강말순", "교육부", "강사", 20, 'F', 1000000,
                                    0.01, "0101234", "부산");
        //3개의 생성자를 사용하여 3명으 ㅣ사원정보를 배열로 생성한 후 출력해보고 값이 없는 필드에 각각 값을 입력해 넣어 출력
        //직원 각각의 보너스가 적용된 연봉을 계산하여 출력하고 총 직원 연봉의 평균을 구하여 출력

        for(int i = 0; i<3; i++){
            System.out.print(emp[i].printdata());
            System.out.println();
        }
        System.out.println("===================================================");
        emp[0].setEmpNo(0);
        emp[0].setEmpName("이순신");
        emp[0].setDept("소프트웨어");
        emp[0].setJob("개발자");
        emp[0].setAge(21);
        emp[0].setGender('M');
        emp[0].setSalary(3000000);
        emp[0].setBonusPoint(0.2);
        emp[0].setPhone("0104567");
        emp[0].setAddress("강원도");
        emp[1].setDept("지도부");
        emp[1].setJob("감독");
        emp[1].setSalary(4000000);
        emp[1].setBonusPoint(0.3);

        for(int i = 0; i<2; i++){
            System.out.print(emp[i].printdata());
            System.out.println();
        }
        System.out.println("===================================================");
        System.out.println("이순신 연봉 : " + emp[0].totalSalary() +"원");
        System.out.println("홍길동 연봉 : " + emp[1].totalSalary() +"원");
        System.out.println("강말순 연봉 : " + emp[2].totalSalary() +"원");
        System.out.println("===================================================");
        System.out.println("직원들의 연봉의 평균 : " + (emp[0].totalSalary() + emp[1].totalSalary() + emp[2].totalSalary())/3 + "원");


    }
}
