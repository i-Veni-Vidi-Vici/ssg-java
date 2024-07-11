package com.sh.app._01.one2one._02.identifying;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tbl_prson")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
