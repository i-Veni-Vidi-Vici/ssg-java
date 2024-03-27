package com.ohgiraffers.hw1;

import com.sh._01.object.array.Car;

public class Application {
    public static void main(String[] args) {

        EmployeeDTO[] emps1 = new EmployeeDTO[3];

        emps1[0] = new EmployeeDTO();
        emps1[1] = new EmployeeDTO(1,"홍길동", 19,'M', "01022223333","서울 잠실");
        emps1[2] = new EmployeeDTO(2, "강말순", "교육부", "강사", 20 ,'F', 1000000, 0.01, "01011112222","서울 마곡");
        for(int i=0;i< emps1.length;i++){
            emps1[i].information();
        }
        EmployeeDTO[] emps2 = new EmployeeDTO[]
                {
                        new EmployeeDTO(0,"김말똥", "영업부", "팀장", 30 ,'M', 3000000, 0.01, "01055559999", "전라도 광주"),
                        new EmployeeDTO(1,"홍길동", "기획부", "부장", 19, 'M', 4000000, 0.3, "01022223333", "서울 잠실")
                };

        for(int i=0;i< emps2.length;i++){
            emps2[i].information();
        }
        for(EmployeeDTO employeeDTO:emps1){
            employeeDTO.money();
        }

        for(EmployeeDTO employeeDTO:emps2){
            employeeDTO.money();


        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        System.out.println(employeeDTO.avg());


    }
}
