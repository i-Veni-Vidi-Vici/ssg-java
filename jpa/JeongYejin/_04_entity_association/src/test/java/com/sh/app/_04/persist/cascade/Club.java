package com.sh.app._04.persist.cascade;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST) // Club이 영속할 때, Student도 영속처리를
    @JoinColumn(name = "club_id")
    private Set<Student> students;

}
