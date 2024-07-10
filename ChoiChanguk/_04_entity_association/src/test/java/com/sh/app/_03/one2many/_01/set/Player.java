package com.sh.app._03.one2many._01.set;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tbl_player")
@Setter(AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
