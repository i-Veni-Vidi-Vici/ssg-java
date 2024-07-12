package com.sh.app._01.one2one._02.identifying;

// 투표
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}