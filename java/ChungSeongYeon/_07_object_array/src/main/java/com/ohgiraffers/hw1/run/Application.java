package com.ohgiraffers.hw1.run;

import com.ohgiraffers.hw1.model.dto.EmployeeDTO;

public class Application {
    public static void main(String[] args){
        // 객체배열을 크기 3으로 할당 한 뒤 3개의 생성자를 각각 이용하여 객체 생성 후 출력
        EmployeeDTO[] emp = new EmployeeDTO[]{
                new EmployeeDTO(),
                new EmployeeDTO(1, "홍길동", 19, 'M', "01022223333", "서울 잠실"),
                new EmployeeDTO(2, "강말순", "교육부", "강사", 20, 'F', 1000000,
                        0.01, "01011112222", "서울 마곡")
        };

        for(EmployeeDTO employeeDTO : emp){
            System.out.println(employeeDTO.information());
        }
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

        System.out.println("emp[0] : " + emp[0].information());
        System.out.println("emp[1] : " + emp[1].information());

        System.out.println("================================================================");

        // 직원 각각의 보너스가 적용된 1년 연봉을 계산하여 출력
        //	    연봉 = (급여 + (급여 * 보너스포인트)) * 12
        int sum = 0;

        for(int i=0; i<emp.length; i++) {
            int sumSalary = (int)(emp[i].getSalary() + (emp[i].getSalary() * emp[i].getBonusPoint())) * 12;
            System.out.println(emp[i].getEmpName() + "의 연봉 : " + sumSalary + "원");

            sum += sumSalary;
        }

        System.out.println("================================================================");

        // 세 직원의 연봉 평균을 구하여 출력
        //    위의 3번에서 sum 변수 새로 추가해서 값 더하도록 적용
        System.out.println("직원들의 연봉의 평균 : " + sum / emp.length + "원");

    }
}

// 실행 결과 화면
//emp[0] : 0, null, null, null, 0, , 0, 0.0, null, null
//emp[1] : 1, 홍길동, null, null, 19, M, 0, 0.0, 01022223333, 서울 잠실
//emp[2] : 2, 강말순, 교육부, 강사, 20, F, 1000000, 0.01, 01011112222, 서울 마곡
//=================================================================
//emp[0] : 0, 김말똥, 영업부, 팀장, 30, M, 3000000, 0.2, 01055559999, 전라도 광주
//emp[1] : 1, 홍길동, 기획부, 부장, 19, M, 4000000, 0.3, 01022223333, 서울 잠실
//================================================================
//김말똥의 연봉 : 43200000원
//홍길동의 연봉 : 62400000원
//강말순의 연봉 : 12120000원
//================================================================
//직원들의 연봉의 평균 : 39240000원
