package com.ssg.oop.emp.model.vo;

import java.util.Scanner;

public class Employee {
    private int empNo;
    private String empName;
    private String dept;
    private String job;
    private int age;
    private char gender;
    private int salary;
    private double bonusPoint;
    private String phone;
    private String address;

    Scanner sc = new Scanner(System.in);

    public void empInput() {
        System.out.print("사번: ");
        this.empNo = sc.nextInt();
        System.out.print("이름: ");
        this.empName = sc.next();
        System.out.print("소속부서: ");
        this.dept = sc.next();
        System.out.print("직급: ");
        this.job = sc.next();
        System.out.print("나이: ");
        this.age = sc.nextInt();
        System.out.print("성별: ");
        this.gender = sc.next().charAt(0);
        System.out.print("급여: ");
        this.salary = sc.nextInt();
        System.out.print("보너스포인트: ");
        this.bonusPoint = sc.nextDouble();
        System.out.print("핸드폰: ");
        this.phone = sc.next();
        sc.nextLine();
        System.out.print("주소: ");
        this.address = sc.nextLine();
    }

    public void modifyEmp() {
        String menu = """
        ******* 사원 정보 수정 메뉴 **********
        1. 사번 변경
        2. 이름 변경
        3. 부서 변경
        4. 직급 변경
        5. 나이 변경
        6. 성별 변경
        7. 급여 변경
        8. 보너스포인트 변경
        9. 핸드폰 번호 변경
        10. 주소 변경
        0. 이전메뉴로 이동
        *************************************
        선택하세요 => """;

        int choice = 0;

        while(true) {
            System.out.print(menu);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("사번을 변경하세요. : ");
                    this.empNo = sc.nextInt();
                    break;
                case 2:
                    System.out.print("이름을 변경하세요. : ");
                    this.empName = sc.next();
                    break;
                case 3:
                    System.out.print("부서를 변경하세요. : ");
                    this.dept = sc.next();
                    break;
                case 4:
                    System.out.print("직급을 변경하세요. : ");
                    this.job = sc.next();
                    break;
                case 5:
                    System.out.print("나이를 변경하세요. : ");
                    this.age = sc.nextInt();
                    break;
                case 6:
                    System.out.print("성별을 변경하세요. : ");
                    this.gender = sc.next().charAt(0);
                    break;
                case 7:
                    System.out.print("급여를 변경하세요. : ");
                    this.salary = sc.nextInt();
                    break;
                case 8:
                    System.out.print("보너스포인트를 변경하세요. : ");
                    this.bonusPoint = sc.nextDouble();
                    break;
                case 9:
                    System.out.print("핸드폰 번호를 변경하세요. : ");
                    this.phone = sc.next();
                    break;
                case 10:
                    sc.nextLine();
                    System.out.print("주소를 변경하세요. : ");
                    this.address = sc.nextLine();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
                    break;
            }
            System.out.println("사원 정보를 수정하였습니다.");
        }
    }

    public void empOutput() {
        System.out.printf("사번: %d, 이름: %s, 소속부서: %s, 직급: %s, 나이: %d, 성별: %s, 급여: %d, 보너스포인트: %.1f, 핸드폰: %s, 주소: %s\n\n",
                this.empNo, this.empName, this.dept, this.job, this.age, this.gender, this.salary, this.bonusPoint, this.phone, this.address);
    }

    public void setEmpNo(int empNo) {this.empNo = empNo;}
    public int getEmpNo() {return this.empNo = empNo;}
    public void setEmpName(String empName) {this.empName = empName;}
    public String getEmpName() {return this.empName = empName;}
    public void setDept(String dept) {this.dept = dept;}
    public String getDept() {return this.dept = dept;}
    public void setJob(String job) {this.job = job;}
    public String getJob() {return this.job = job;}
    public void setAge(int age) {this.age = age;}
    public int getAge() {return this.age = age;}
    public void setGender(char gender) {this.gender = gender;}
    public char getGender() {return this.gender = gender;}
    public void setSalary(int salary) {this.salary = salary;}
    public int getSalary() {return this.salary = salary;}
    public void setBonusPoint(double bonusPoint) {this.bonusPoint = bonusPoint;}
    public double getBonusPoint() {return this.bonusPoint = bonusPoint;}
    public void setPhone(String phone) {this.phone = phone;}
    public String getPhone() {return this.phone = phone;}
    public void setAddress(String address) {this.address = address;}
    public String getAddress() {return this.address = address;}
}
