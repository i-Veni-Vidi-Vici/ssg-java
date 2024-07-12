package com.sh.app._02.survey;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tbl_survey")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SecondaryTable(
        name = "tbl_free_time",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "_id")
)
public class Survey {
    @Id
    private String email;
    private Gender gender;
    private Age age;
    @Column(name = "freetime")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tbl_freetime",
            joinColumns = @JoinColumn(name = "freetime_id") // fk컬럼명
    )
    @Column(name = "text") // String이 저장될 컬럼명
    @OrderColumn(name = "idx") // List의 인덱스를 저장할 컬럼명
    private List<FreeTime> freetime;
}
