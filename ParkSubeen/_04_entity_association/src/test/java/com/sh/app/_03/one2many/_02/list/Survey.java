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
//@AllArgsConstructor
@Builder
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_id") // tbl_question.survey_id컬럼(FK)이 tbl_survey.id컬럼(PK)를 참조
    @OrderColumn(name = "inquiry_idx")
    @Builder.Default
    private List<Inquiry> inquiries = new ArrayList<>();

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
