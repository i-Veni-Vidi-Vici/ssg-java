package com.sh.app._05.aggregate.association;

import jakarta.persistence.*;
import lombok.*;

/**
 * aggregate.association 은 없는 말이다 ... 강사님이 지어내심
 */
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int capacity; // 정원
}