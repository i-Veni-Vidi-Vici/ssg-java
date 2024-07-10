package com.sh.app._04.persist.cascade;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name = "tbl_club")
@Setter(AccessLevel.PACKAGE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(cascade = CascadeType.PERSIST)// club이 영속할 때(persist) student도 영속처리를 같이 한다 // 일단은 등록만 같이 하는걸로 하자
    @JoinColumn(name = "club_id") // 얘는 이것만 적으면 됨
    private Set<Student> students;
}
