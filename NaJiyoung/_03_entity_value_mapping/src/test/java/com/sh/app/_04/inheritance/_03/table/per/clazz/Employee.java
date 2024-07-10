package com.sh.app._04.inheritance._03.table.per.clazz;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 부모클래스
 */
@Entity(name = "Employee0403")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 자식클래스당 테이블하나
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // IDENTITY 전략은 사용할수 없다.
    private Long id;
    private String name;
    private String contact;
}
