package com.sh._04.inheritance._03.table.per.clazz;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 부모클래스
 */

// 만약 공통적인 부분을 가지는 테이블이 50개씩있는데
// 생각해보니?? 어?? 공통 부분이 더 필요하겠는데??
// 그럼 테이블 전부 돌아다니면서 50개 다 update를 해줘야 한다
@Entity(name = "Employee0403")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 자식클래스당 테이블하나
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String contact;
}
