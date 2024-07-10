package com.sh.app._04.inheritance._03.table.per.clazz;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 부모클래스
 */
@Entity(name = "Employee0403")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 자식클래스당 테이블 하나
// @Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Employee {
    @Id
    // (strategy = GenerationType.IDENTITY)는 auto_increment인데, 테이블이 두 개 이상이 될 수 있기 때문에 TABLE로 설정한 것이다.
    @GeneratedValue(strategy = GenerationType.TABLE) // IDENTITY전략은 사용할 수 없다.
    private Long id;
    private String name;
    private String contact;
}
