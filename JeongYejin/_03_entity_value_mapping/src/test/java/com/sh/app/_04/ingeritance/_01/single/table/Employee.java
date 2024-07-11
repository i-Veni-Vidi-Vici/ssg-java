package com.sh.app._04.ingeritance._01.single.table;

import jakarta.persistence.*;
import lombok.*;

/**
 * 부모클래스
 */

@Entity
@Table(name = "tbl_employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "emp_type") // 행을 구별 - 자식클래스 타입을 결정하는 컬럼명 // @DiscriminatorValue 와 짝꿍
@Setter(AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    private String contact;
}
