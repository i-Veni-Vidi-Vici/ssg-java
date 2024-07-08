package com.sh.app._02.embeddable._02.secondary.table;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WriterInfo {
    @Column(name = "self_introduction", table = "tbl_writer_info") // table 명시하지 않으면 tbl_witer 밑으로 들어간다
    private String selfIntroduction;
}
