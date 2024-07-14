package com.sh.app._01.one2one._02.identifying;

import jakarta.persistence.*;
import lombok.*;
import net.bytebuddy.implementation.bytecode.Throw;

/**
 * 투표
 * Vote - Person 1:1 식별관계이다
 * - Vote객체는 반드시 하나의 Person객체를 가져야한다
 * (null일 수 없다)
 */

@Entity
@Table(name = "tbl_vote")
@Setter(AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
//@AllArgsConstructor // 이건 안씀 null이 아닌 값이어야 하기 때문에
public class Vote {

    @Id
    @Column(name = "person_id") // pk컬럼 지정
    private Long personId;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "person_id") // fk컬럼명 지정
    private Person person;

    @Column(name = "candidate_name",nullable = false)
    private String candidateName; // 투표한 후보이름

    public Vote(@NonNull Person person, String candidateName) {
        if(person == null)
            throw new IllegalArgumentException("person객체는 null일 수 없습니다");
        this.person = person;
        this.personId=person.getId();
        this.candidateName = candidateName;
    }
}
