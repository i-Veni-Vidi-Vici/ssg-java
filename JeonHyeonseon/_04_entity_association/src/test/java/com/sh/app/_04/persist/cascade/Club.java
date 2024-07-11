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
    // club따라서 student도 영속처리 되겠끔 작성된 코드
    @OneToMany(cascade = CascadeType.PERSIST) // Club이 영속(persist)할 때, Student도 영속처리한다.
    @JoinColumn(name = "club_id")
    private Set<Student> students;
}
