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
    @OneToMany(fetch = FetchType.EAGER) // 1개의 surver에 n개의 inquiry
    @JoinColumn(name = "survey_id") // tbl_question.survey_id컬럼(FK)이 tbl_survey.id컬럼(PK)을 참조
    @OrderColumn(name = "inquiry_idx") // List니까 순서가 있어야해서 @OrderColumn이 있어야함
    @Builder.Default
    private List<Inquiry> inquiries = new ArrayList<>(); // Collection은 변경이 불가능한데 new 생성자로 아예 새로 만들게끔해 수정함

    public Survey(Long id, String title, List<Inquiry> inquiries) {
        this.id = id;
        this.title = title;
        this.inquiries = new ArrayList<>(inquiries); // Collection은 변경이 불가능한데 new 생성자로 아예 새로 만들게끔해 수정함
    }

    public void addInquiry(Inquiry inquiry) {
        this.inquiries.add(inquiry);
    }

    public void removeInquiry(Inquiry inquiry) {
        this.inquiries.remove(inquiry);
    }
}
