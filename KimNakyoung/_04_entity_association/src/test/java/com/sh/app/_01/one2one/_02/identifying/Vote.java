package com.sh.app._01.one2one._02.identifying;


import jakarta.persistence.*;
import lombok.*;

/**
 *
 * Vote-Person 1:1식별관계이다.
 * - Vote는 반드시 하나의 Person 객체를 가져야 한다. (null일 수 없다 !)
 * - db관점에서 본다면, fk컬럼을 다시 pk컬럼을 사용한다.
 *
 *
 */

@Entity
@Table(name = "tbl_vote")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class Vote {
    @Id
    @Column(name = "person_id")
    private Long personId; // 반드시 널이 아니여야해서 생성자 직접 만들기

    @OneToOne
    @PrimaryKeyJoinColumn(name = "person_id") // fk칼럼명 지정
    private Person person;
    @Column(name = "candidate_name")
    private String candidateName; // 투표할 회장이름

    public Vote(@NonNull Person person, String candidateName) {
        if(person == null)
            throw new IllegalArgumentException("person객체는 null일수 없다");
        this.person = person;
        this.personId = person.getId();
        this.candidateName = candidateName;
    }
}
