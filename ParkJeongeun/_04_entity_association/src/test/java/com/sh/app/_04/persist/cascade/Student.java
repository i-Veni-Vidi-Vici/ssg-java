package com.sh.app._04.persist.cascade;

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
}