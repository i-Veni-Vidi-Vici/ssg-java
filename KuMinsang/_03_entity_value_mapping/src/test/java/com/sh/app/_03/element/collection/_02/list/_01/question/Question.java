package com.sh.app._03.element.collection._02.list._01.question;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Question")
@Table(name = "tbl_question")
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
            name="tbl_question_choice",
            joinColumns = @JoinColumn(name="question_id")  //FK컬럼명
    )
    @Column(name="text")
    @OrderColumn(name = "idx")  //list의 index를 저장할 컬럼명
    private List<String> choice;

    public void changeChoices(List<String> newChoice) {
        this.choice = newChoice;
    }
}
