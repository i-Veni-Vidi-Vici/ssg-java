package com.sh.app._04.inheritance._02.joined;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 부모클래스
 */
@Entity(name = "Employee0402")
@Table(name = "tbl_employee_0402")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "emp_type") // 자식클래스 타입을 결정하는 컬럼명
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact;
}