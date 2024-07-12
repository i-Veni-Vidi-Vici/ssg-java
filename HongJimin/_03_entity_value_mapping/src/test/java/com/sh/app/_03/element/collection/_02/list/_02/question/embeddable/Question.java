package com.sh.app._03.element.collection._02.list._02.question.embeddable;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Question0202") // 이 이름은 중복되면 안됨!
@Table(name = "tbl_question_0202")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text; // 문제 텍스트

    @ElementCollection(fetch = FetchType.EAGER) // ✨ 기본이 fetchtype.Lazy(지연로딩) 설정이 되어있는 상태 -> 이럴 경우, select문이 두번 나뉘어서 나감, EAGER인 경우, join커리를 써서 한번에 쿼리를날림 / 1 : N 쿼리는 지연로딩이 기본!)
    @CollectionTable( //✨ 위아래 어노테이션 무조건 필요함!✨
            name = "tbl_question_choice_0202",
            joinColumns = @JoinColumn(name = "question_id") // ✨fk 컬럼명을 지정한 것!
    )
//    @Column(name = "text") // 없어도됨
    @OrderColumn(name = "idx") // ✨List의 인덱스를 저장할 컬럼명
    private List<Choice> choices;

    public void changeChoices(List<Choice> newChoices) {
        this.choices = newChoices;
    }
}
