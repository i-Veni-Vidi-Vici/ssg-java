package com.sh._02.embeddable._02.secondary.table;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class WriterInfo {

    @Column(name = "self_introduction" , table = "tbl_writer_info")
    private String selfIntroduction;

}
