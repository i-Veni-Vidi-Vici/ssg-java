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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tbl_question_choice", // 연관 테이블명
            joinColumns = @JoinColumn(name = "question_id") // fk컬럼명
    )
    @Column(name = "text") // String이 저장될 컬럼명
    @OrderColumn(name = "idx") // List의 인덱스를 저장할 컬럼명(List 각 항목의 순서 보장을 위해 사용)
    private List<String> choices;

    public void changeChoices(List<String> newChoices) {
        this.choices = newChoices; // 통으로 바꿔주기
    }
}