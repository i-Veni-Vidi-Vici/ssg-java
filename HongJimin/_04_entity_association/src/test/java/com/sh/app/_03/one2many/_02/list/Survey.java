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
    @OneToMany(fetch = FetchType.EAGER) // 하나의 survey의 다수개의 questions
    @JoinColumn(name = "survey_id") // tbl_question.survey_id 컬럼(FK)이 tbl_survey.id(컬럼)을 참조한다.
    @OrderColumn(name = "inquiry_ixdx")
    @Builder.Default
    private List<Inquiry> inquiries = new ArrayList<>(); // 순서가 중요한 question를 갖고 있움

    public Survey(Long id, String title, List<Inquiry> inquiries) {
        this.id = id;
        this.title = title;
        this.inquiries = inquiries;
    }

    public void addInquiry(Inquiry inquiry) {
        this.inquiries.add(inquiry);
    }

    public void removeInquiry(Inquiry inquiry) {
        this.inquiries.remove(inquiry);
    }
}
