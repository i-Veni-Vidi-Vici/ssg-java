package com.ohgiraffers.hw1.run;

import com.ohgiraffers.hw1.model.dto.EmployeeDTO;

/**
 * 3개의 생성자를 사용하여 3명의 사원 정보를 배열로 생성한 후 출력 해보고
 * 값이 없는 필드에 각각 값을 입력해 넣어 출력
 * 직원 각각의 보너스가 적용된 연봉을 계산하여 출력하고
 * 총 직원 연봉의 평균을 구하여 출력
 */
public class Application {
    public static void main(String[] args) {
        // 객체배열을 크기 3으로 할당 한 뒤 3개의 생성자를 각각 이용하여 객체 생성 후 출력
        EmployeeDTO[] emp = new EmployeeDTO[3];
        emp[0] = new EmployeeDTO();
        emp[1] = new EmployeeDTO(10, "박철수", 50, '남', "010888999", "서울 종로구 동대문");
        emp[2] = new EmployeeDTO(10, "김밥천국", "주방", "조리", 15, '남', 60000, 10.0, "01052528484","김밥시 덕복기구 오뎅동" );

        for(int i =0; i<emp.length; i++ ){
            System.out.println("emp["+i+"] : " + emp[i].information());
        }
        System.out.println("=======================================");

        // 3개의 객체 중 값이 없는 필드에 각각 값을 넣은 뒤 출력
        emp[0].setEmpNo(30);
        emp[0].setEmpName("오이시");
        emp[0].setDept("카운터");
        emp[0].setJob("계산팀장");
        emp[0].setAge(11);
        emp[0].setGender('여');
        emp[0].setSalary(5000000);
        emp[0].setBonusPoint(0.1);
        emp[0].setPhone("01078785412");
        emp[0].setAddress("제주시 제주면 제주동");

        emp[1].setDept("유흥부");
        emp[1].setJob("대리");
        emp[1].setSalary(10000);
        emp[1].setBonusPoint(8.0);

        for(int i =0; i<emp.length-1; i++ ){
            System.out.println("emp["+i+"] : " + emp[i].information());
        }
        System.out.println("=======================================");

        // 직원 각각의 보너스가 적용된 1년 연봉을 계산하여 출력
        // 연봉 = (급여 + (급여 * 보너스포인트)) * 12
        for (EmployeeDTO employeeDTO : emp) {
            System.out.printf("%s의 연봉 : %.1f\n",employeeDTO.getEmpName() , ((employeeDTO.getSalary()+employeeDTO.getSalary() * employeeDTO.getBonusPoint())*12) );
//            System.out.println(employeeDTO.getEmpName() + "의 연봉 : " + ((employeeDTO.getSalary()+employeeDTO.getSalary() * employeeDTO.getBonusPoint())*12) + "원");
        }
        System.out.println("=======================================");
        double avgsal=0;
        for (EmployeeDTO employeeDTO : emp) {
            avgsal += ((employeeDTO.getSalary()+employeeDTO.getSalary() * employeeDTO.getBonusPoint())*12);
        }
        System.out.printf("평균 연봉 : %.1f 원", avgsal/emp.length);
        // 3명의 직원의 연봉 평균을 구하여 출력
    }
}
