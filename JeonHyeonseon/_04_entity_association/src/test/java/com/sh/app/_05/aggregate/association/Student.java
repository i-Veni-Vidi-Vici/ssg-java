package com.sh.app._05.aggregate.association;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_student")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JoinColumn(name = "department_id")
    private Long departmentId; // 애그리게이트 경계 넘어서 있기 때문에 객체지향으로 작성하지 않는다.
    @Embedded
    private Address address;
}
