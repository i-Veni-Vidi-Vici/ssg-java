package com.hw1.run;

import com.hw1.model.dto.Employee;
import com.hw1.model.dto.Student;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Student[] stu=new Student[3];

        stu[0]=new Student("홍길동",20,178.2,70.0,1,"정보시스템공학과");
        stu[1]=new Student("김말똥",21,187.3,80.0,2,"경영학과");
        stu[2]=new Student("강개순",23,167.0,45.0,4,"정보통신공학과");

        System.out.printf(" 이름  나이  신장  몸무게 학년    전공\n");

        for(Student students:stu)
       {
           System.out.println(students.information());
       }

       Employee[] empl=new Employee[10];

        //System.out.printf("이름, 나이, 신장, 몸무게, 급여, 부서를 입력해주세요\n");

       int cnt=0;

        System.out.println(" 이름 나이 신장 몸무게 급여 부서");
       while(true)
       {
           Scanner sc=new Scanner(System.in);
           String name=sc.next();
           int age=sc.nextInt();
           double height=sc.nextDouble();
           double weight=sc.nextDouble();
           int salary = sc.nextInt();
           String major=sc.next();

           empl[cnt]=new Employee(name,age,height,weight,salary,major);
           System.out.println(empl[cnt].information());
           cnt++;

           System.out.printf("계속 입력 하십니까 : ");

           char choice=sc.next().charAt(0);
           if (choice != 'y' && choice != 'Y') {
               break ;
           }
       }
        System.out.println(" 이름   나이 신장   몸무게   급여    부서");
       for(int i=0;i<cnt;i++)
       {
           System.out.println(empl[i].information());
       }





    }
}
