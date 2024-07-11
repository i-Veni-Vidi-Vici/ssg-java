package com.sh.app._03.element.collection._02.list._02.question.embeddable;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity(name = "Question0202")
@Table(name = "tbl_question0202")
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String text;

    @ElementCollection
    @CollectionTable(
            name="tbl_question_choice_0202",
            joinColumns = @JoinColumn(name="question_id")  //FK컬럼명
    )
    @OrderColumn(name = "idx")  //list의 index를 저장할 컬럼명
    private List<Choice> choices;

    public void changeChoices(List<Choice> newChoices) {
        this.choices = newChoices;
    }
}
