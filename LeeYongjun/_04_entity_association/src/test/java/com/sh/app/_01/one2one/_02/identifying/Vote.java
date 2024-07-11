package com.sh.app._01.one2one._02.identifying;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;

/**
 * Vote - Person 1:1 식별관계이다.
 * - Vote객체는 반드시 하나의 Person 객체를 가져야 한다.(null일 수 없다.)
 * - db관점에서 본다면, fk컬럼을 다시 pk컬럼을 사용한다.
 */
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class Vote {
    @Id
    @Column(name = "person_id")

    @OneToOne
    @PrimaryKeyJoinColumn(name = "person_id") // fk컬럼명 지정
    private Long personId;
    private Person person;
    private String candidateName; // 투표한 회장이름

    public Vote(@NonNull Person person, String candidateName) {
        if(person == null)
            throw new IllegalArgumentException("person객체는 null일 수 없습니다.");
        this.person = person;
        this.personId = person.getId();
        this.candidateName = candidateName;
    }
}
