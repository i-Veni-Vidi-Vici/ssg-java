package com.ssg.test.ohigiraffers.hw1.run;

import com.ssg.test.ohigiraffers.hw1.model.dto.EmployeeDTO;

public class Application {
    public static void main(String[] args) {
        // 객체배열을 크기 3으로 할당한 뒤 3개의 생성자를 각각 이용하여 객체 생성 후 출력
        EmployeeDTO[] emp = new EmployeeDTO[3];
        emp[0] = new EmployeeDTO();
        emp[1] = new EmployeeDTO(1, "홍길동", 19, 'M', "01022223333", "서울 잠실");
        emp[2] = new EmployeeDTO(2, "강말순", "교육부", "강사", 20, 'F', 1000000, 0.01, "01011112222", "서울 마곡");

        for(int i=0; i<emp.length; i++)
            System.out.println("emp[" + i + "] : " + emp[i].information());
        System.out.println("========================================================================");

        // 3개의 객체 중 값이 없는 필드에 각각 값을 넣은 뒤 출력
        emp[0].setEmpNo(0);
        emp[0].setEmpName("김말똥");
        emp[0].setDept("영업부");
        emp[0].setJob("팀장");
        emp[0].setAge(30);
        emp[0].setGender('M');
        emp[0].setSalary(3000000);
        emp[0].setBonusPoint(0.2);
        emp[0].setPhone("01055559999");
        emp[0].setAddress("전라도 광주");

        emp[1].setDept("기획부");
        emp[1].setJob("부장");
        emp[1].setSalary(4000000);
        emp[1].setBonusPoint(0.3);

        for(int i=0; i<2; i++)
            System.out.println("emp[" + i + "] : " + emp[i].information());
        System.out.println("========================================================================");

        // 직원 각각의 보너스가 적용된 1년 연봉을 계산하여 출력
        // 연봉 = (급여 + (급여 * 보너스포인트)) * 12
        int sumSalary = 0;  // 3명의 직원의 연봉 합계
        
        for(int i=0; i< emp.length; i++) {
            int bonusSalary = (emp[i].getSalary() + (int)(emp[i].getSalary() * emp[i].getBonusPoint())) * 12;
            System.out.println(emp[i].getEmpName() + "의 연봉 : " + bonusSalary + "원");
            sumSalary += bonusSalary;
        }
        System.out.println("========================================================================");

        // 3명의 직원의 연봉 평균을 구하여 출력
        int avgSalary = sumSalary / emp.length;
        System.out.println("직원들의 연봉의 평균 : " + avgSalary + "원");
    }
}
