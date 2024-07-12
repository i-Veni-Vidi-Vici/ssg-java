package com.sh.app._04.inheritance._02.joined;

import jakarta.persistence.*;
import lombok.*;

/**
 *  부모 클래스
 */
@Entity(name = "Employee0402")
@Table(name = "tbl_employee_0402")
@Inheritance(strategy = InheritanceType.JOINED) // 최선을 다해 자바 상속구조 따라함
@DiscriminatorColumn(name = "emp_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id를 auto-increment 처리함
    private Long id;
    private String name;
    private String contact;
}
