package com.sh.app._04.inheritance._03.element.table.per.clazz;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  부모 클래스
 */
@Entity(name = "Employee0403")
//@Table(name = "tbl_employee_0403") // 테이블 피료없움
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 자식 클래스당 테이블 하나
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // IDENTITY 전략은 사용할 수 없다. -> 별도의 테이블을 우녕ㅇ함
    private Long id;
    private String name;
    private String contact;
}
