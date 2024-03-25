package com.hw1.run.model.dto;

import java.util.Scanner;

public class Employee extends Person
{
    private int salary;
    private String dept;

    public Employee(String name, int age, double height, double weight, int salary, String dept) {
        super(name, age, height, weight);
        this.salary = salary;
        this.dept = dept;
    }

    public void Input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요 : ");
        String name = sc.next();
        System.out.print("나이를 입력하세요 : ");
        int age = sc.nextInt();
        System.out.print("키를 입력하세요 : ");
        double height = sc.nextDouble();
        System.out.print("몸무게를  입력하세요 : ");
        double weight = sc.nextDouble();
        this.setName(name);
        this.setAge(age);
        this.setHeight(height);
        this.setWeight(weight);
        System.out.print("급여를 입력하세요 : ");
        this.salary = sc.nextInt();
        System.out.println("부서를 입력하세요 : ");
        this.dept = sc.next();

    }
    public Employee(){
    }
    public String information(){
        String information= """
        저장된 사원 정보들을 출력합니다. 
        이름      나이    신장    몸무게     급여     부서
        =============================================
        """;
        return information;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
