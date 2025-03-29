package com.ssg.test.problem1;

public class Application {
    public static void main(String[] args) {
        EmployeeDTO[] employees = new EmployeeDTO[3];
        employees[0] = new EmployeeDTO(1, 20, "홍길동", "01095225458", "서울", '남');
        employees[1] = new EmployeeDTO(2, 23, "김홍현", "01077775458", "경기", '남');
        employees[2] = new EmployeeDTO(3, 28, "김김김", "01098985458", "부산", '여');



        for(int i =0; i< employees.length; i++){
            System.out.println(employees[i].info());
        }
        System.out.println("==============================================================");

        employees[0].setDept("국방부");
        employees[0].setJob("당직사관");
        employees[0].setSalary(1000000);
        employees[0].setBonusPoint(0.1);

        employees[1].setDept("교육부");
        employees[1].setJob("교사");
        employees[1].setSalary(1500000);
        employees[1].setBonusPoint(0.1);

        employees[2].setDept("보건복지부");
        employees[2].setJob("사무원");
        employees[2].setSalary(2000000);
        employees[2].setBonusPoint(0.1);

        for(int i =0; i< employees.length; i++){
            System.out.println(employees[i].info());
        }
        System.out.println("==============================================================");

        System.out.println(employees[0].getEmpName() + "님의 연봉: " + (int)(employees[0].getSalary()*(1+ employees[0].getBonusPoint())*12) + "원");
        System.out.println(employees[1].getEmpName() + "님의 연봉: " + (int)(employees[1].getSalary()*(1+ employees[1].getBonusPoint())*12) + "원");
        System.out.println(employees[2].getEmpName() + "님의 연봉: " + (int)(employees[2].getSalary()*(1+ employees[2].getBonusPoint())*12) + "원");
        System.out.println("==============================================================");




    }
}
