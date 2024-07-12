package com.sh.app._04.persist.cascade;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "tbl_club")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST) // 부모인 Club이 영속(persist)할때, 자식인 Student도 영속처리
    @JoinColumn(name = "club_id")
    private Set<Student> students;
}
