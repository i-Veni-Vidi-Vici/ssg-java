package com.sh.app._04.inheritance._01.single.table;

import jakarta.persistence.*;
import lombok.*;

/**
 *  부모 클래스
 */
@Entity
@Table(name = "tbl_employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "emp_type") // 자식 클래스 타입을 결정하는 컬럼명 -> 🙉tbl_employee안에 debeloper, manager행이 쌓임 이거를 구분하기 위함
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
