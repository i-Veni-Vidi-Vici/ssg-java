package com.ohgiraffer.hw1;

public class App {
    public static void main(String[] args) {
        EmployeeDTO[] emp = new EmployeeDTO[]{
                new EmployeeDTO(),
                new EmployeeDTO(1, "홍길동", 19, 'M', "01022223333", "서울 잠실"),
                new EmployeeDTO(2, "강말순", "교육부", "강사", 20, 'F', 1000000, 0.01, "01011112222", "서울 마곡")
        };

        EmployeeDTO employeeDTO = new EmployeeDTO();
        System.out.println("emp[0] : " + emp[0].information());
        System.out.println("emp[1] : " + emp[1].information());
        System.out.println("emp[2] : " + emp[2].information());
        System.out.println("=======================================================================");

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
        System.out.println("=======================================================================");

        System.out.println("김말똥의 연봉 : " + emp[0].anualSalary() + "원");
        System.out.println("홍길동의 연봉 : " + emp[1].anualSalary() + "원");
        System.out.println("강말순의 연봉 : " + emp[2].anualSalary() + "원");
        System.out.println("=======================================================================");

        System.out.println("직원들의 연봉 평균 : " + (emp[0].anualSalary() + emp[1].anualSalary() + emp[2].anualSalary()) / 3 + "원");
    }
}
