package com.sh.app._03.element.collection._02.list._01.question;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Question")
@Table(name = "tbl_question")
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

//    @ElementCollection(fetch = FetchType.LAZY) // 필요할 때 조회되는 것. 지연로딩(1대N 관계일 때 많이 사용된다)
    @ElementCollection(fetch = FetchType.EAGER) // 조인쿼리로 가져온다. db에 한 번만 갔다온다.
    @CollectionTable(
            name = "tbl_question_choice",
            joinColumns = @JoinColumn(name = "question_id") // fk컬러명 지정 question_id
    )

    @Column(name = "text") // String이 저장될 컬럼명
    @OrderColumn(name = "idx") // List의 인덱스를 저장할 컬럼명(순서가 바뀌면 안되기 때문)
    private List<String> choices;

    // set을 사용할 수 없기 때문에 새롭게 메소드를 만들어서 사용한다.
    public void changeChoices(List<String> newChoices) {
        this.choices = newChoices;
    }
}
