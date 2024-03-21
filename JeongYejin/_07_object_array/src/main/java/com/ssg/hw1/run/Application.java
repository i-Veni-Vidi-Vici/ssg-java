//package com.ssg.hw1.run;
//
//import com.ssg.hw1.model.dto.EmployeeDTO;
//
//public class Application {
//    public static void main(String[] args) {
//        EmployeeDTO[] emp = new EmployeeDTO[3];
//        emp[0] = new EmployeeDTO();
//        emp[1] = new EmployeeDTO(1, "홍길동", 19, 'M', "01022223333", "서울 잠실");
//        emp[2] = new EmployeeDTO(2, "강말순", "교육부", "강사", 20, 'F', 1000000, 0.01, "01011112222", "서울 마곡");
//
//        emp[0].information();
//        emp[1].information();
//        emp[2].information();
//        System.out.println("==========================================================");
//        emp[0].setEmpName("김말똥");
//        emp[0].setDept("영업부");
//        emp[0].setJob("팀장");
//        emp[0].setAge(30);
//        emp[0].setGender('M');
//        emp[0].setSalary(3000000);
//        emp[0].setBonusPoint(0.2);
//        emp[0].setPhone("01055559999");
//        emp[0].setAddress("전라도 광주");
//        emp[1].setDept("기획부");
//        emp[1].setJob("부장");
//        emp[1].setSalary(4000000);
//        emp[1].setBonusPoint(0.3);
//
//        emp[0].information();
//        emp[1].information();
//        System.out.println("==========================================================");
//
//        int salarySum = 0;
//        for (EmployeeDTO e : emp) {
//            double salary = (e.getSalary() + (e.getSalary()*e.getBonusPoint()))*12;
//            System.out.println(e.getEmpName() + "의 연봉 : " + (int)salary + "원");
//            salarySum += (int)salary;
//        }
//        System.out.println("==========================================================");
//        System.out.println("직원들의 연봉의 평균 : " + salarySum/3 + "원");
//    }
//
//}
