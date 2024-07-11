package com.sh.app._03.one2many._02.list;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_survey")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
//    @OneToMany(fetch = FetchType.LAZY) // one의 survey에 many의 question. FetchType설정하는 어노테이션
    @OneToMany(fetch = FetchType.EAGER) // one의 survey에 many의 question. FetchType설정하는 어노테이션
    @JoinColumn(name = "survey_id") // tbl_question.survey_id컬럼(FK)이 tbl_survey.id컬럼(PK)을 참조한다.
    @OrderColumn(name = "inquiry_idx")
    @Builder.Default
    // 변경가능하게 하기 위해서 new ArrayList<>() 사용
    private List<Inquiry> inquiries = new ArrayList<>(); // question 순서가 중요하기 때문에 List로 작성

    // @AllArgsConstructor 대신 직접 사용 -> 변경 가능한 질문을 사용할 수 있도록 생성자 직접 작성
    public Survey(Long id, String title, List<Inquiry> inquiries) {
        this.id = id;
        this.title = title;
        this.inquiries = new ArrayList<>(inquiries);
    }

    public void addInquiry(Inquiry inquiry) {
        this.inquiries.add(inquiry);
    }
    public void removeInquiry(Inquiry inquiry) {
        this.inquiries.remove(inquiry);
    }
}
