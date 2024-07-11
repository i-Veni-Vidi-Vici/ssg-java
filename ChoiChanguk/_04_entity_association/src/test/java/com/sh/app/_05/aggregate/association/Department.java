package com.sh.app._05.aggregate.association;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_department")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int capacity;
}
