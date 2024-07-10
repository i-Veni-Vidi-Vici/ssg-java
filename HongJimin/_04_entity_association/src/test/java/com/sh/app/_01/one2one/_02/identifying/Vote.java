package com.sh.app._01.one2one._02.identifying;

import jakarta.persistence.*;
import lombok.*;

/**
 * Vote - Person 1:1식별 관계
 * - Vote는 반드시 하나의 Person 객체를 가져야 한다.(null일 수 없다.)
 * - DB 관점에서 본다면, fk컬럼을 다시 pk컬럼으로 사요한다.
 * - Vote가 Person을 바라봐서 순서를 지켜야 함@
 */
@Entity
@Table(name = "tbl_vote")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
//@AllArgsConstructor 얘는 안 쓸 예정
public class Vote {
    @Id
    @Column(name = "person_id") // pk 컬럼 지정
    private Long personId; // person을 Id로 쓸 수 없기 때문

    @OneToOne // 일대일 연관관계
    @PrimaryKeyJoinColumn(name = "person_id") //fk 컬럼명 지정
    private Person person;
    @Column(name = "candidate_name", nullable = false)
    private String candidateName; // 투표한 회장 이름

    public Vote(@NonNull Person person, String candidateName) {
        if(person == null)
            throw new IllegalArgumentException("person객체는 null일 수 없습니다.");
        this.person = person;
        this.personId = person.getId();
        this.candidateName = candidateName;
    }
}
