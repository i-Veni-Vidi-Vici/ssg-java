package com.sh.app._02.survey;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "tbl_survey")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private Age age;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tbl_hobbies",
            joinColumns = @JoinColumn(name = "survey_id")
    )
    @Column(name = "hobby", nullable = false)
    private Set<String> hobbies;
}
