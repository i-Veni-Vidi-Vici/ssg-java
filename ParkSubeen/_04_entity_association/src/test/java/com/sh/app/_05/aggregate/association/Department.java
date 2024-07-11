package com.sh.app._05.aggregate.association;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_department")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int capacity; // 정원
}
