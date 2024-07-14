package com.sh._04.inheritance._01.single.table;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// test 실행을 해보면, 쿼리문에 전부다 들어가있다 = 전부 때려박았다

// 자식 db가 많아지면 null값이 생각보다 많아진다
// 대신 단순하다
@Entity
@Table(name = "tbl_employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "emp_type") // 자식 클래스 타입을 결정하는 컬럼명
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
