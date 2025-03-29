package com.ohgiraffers.hw1;


public class Application {
    public static void main(String[] args) {
        EmployeeDTO employees[];
        employees = new EmployeeDTO[3];


        employees[0] = new EmployeeDTO();
        employees[1] = new EmployeeDTO(1, "홍길동", 19, 'M', "01022223333", "서울잠실");
        employees[2] = new EmployeeDTO(2, "강말순", "교육부", "강사", 20, 'F', 1000000, 0.01, "01011112222", "서울 마곡");

        for (int i = 0; i < employees.length; i++) {
            employees[i].info();
        }
        System.out.println("=================================================================");
        EmployeeDTO[] employees2 = new EmployeeDTO[]{
                new EmployeeDTO(0, "김말똥", "영업부", "팀장", 30, 'M', 3000000, 0.2, "01055559999", "전라도 광주"),
                new EmployeeDTO(1, "홍길동", "기획부", "부장", 19, 'M', 4000000, 0.3, "01022223333", "서울잠실")
        };
        for (EmployeeDTO employeeDTO : employees2) {
            employeeDTO.info();
        }
        System.out.println("=================================================================");

        EmployeeDTO[] employees3 = new EmployeeDTO[]{
                new EmployeeDTO("강말순", 100000,0.01),
                new EmployeeDTO("김말똥", 300000,0.2),
                new EmployeeDTO("홍길동", 400000,0.3)
        };
        for (EmployeeDTO employeeDTO : employees3) {
            employeeDTO.hap();
        }
        System.out.println("=================================================================");

        EmployeeDTO[] employees4 = new EmployeeDTO[]{
                new EmployeeDTO(12120000),
                new EmployeeDTO(43200000),
                new EmployeeDTO(62400000)
        };
        int avg = 0;
        for (EmployeeDTO employeeDTO : employees4) {
            avg += employeeDTO.getYearSalary();
        }
        int totalAvg = avg / employees4.length;
        System.out.println("직원들의 연봉의 평균 : " + totalAvg + "원");
    }
}
