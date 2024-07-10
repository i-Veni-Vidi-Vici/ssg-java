package com.sh.app._04.ingeritance._03.table.per.clazz;

import jakarta.persistence.*;
import lombok.*;

/**
 * 부모클래스
 */

@Entity(name = "Employee0403")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 자식 클래스당 테이블 하나 전략
@Setter(AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // 아이덴티티 전략은 사용할 수 없다.
    private Long id;
    private String name;
    private String contact;
}
