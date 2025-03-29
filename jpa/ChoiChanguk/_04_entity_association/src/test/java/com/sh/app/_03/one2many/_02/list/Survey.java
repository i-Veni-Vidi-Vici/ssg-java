package com.sh.app._03.one2many._02.list;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Order;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
//@AllArgsConstructor // list.of로 넘어올 수 있어서 안쓴다
@Entity
@Table(name = "tbl_survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;


    @OneToMany
    @JoinColumn(name = "survey_id") // tbl_question.survey_id컬럼(FK)이 tbl_survey.id컬럽(PK)을 참조한다
    @OrderColumn(name = "question_idx")
    @Builder.Default
    private List<Question> questions=new ArrayList<>(); // 다수개의 순서가 중요한 question// 변경이 가능하게 할 때 new ArrayList해준다

    //이놈이 변경가능하게 하기 위한 생성자이다
    public Survey(Long id, String title, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }

    public void addQuestion(Question question)
    {
        this.questions=questions;
    }

    public void removeQeustion(Question question)
    {
        this.questions.remove(question);
    }
}
