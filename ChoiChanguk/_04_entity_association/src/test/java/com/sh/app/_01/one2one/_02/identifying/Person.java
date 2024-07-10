package com.sh.app._01.one2one._02.identifying;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tbl_person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class Person {
    // 투표같은 거 할 때

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 테이블에 위임한다
    private Long id;
    private String name;
}
