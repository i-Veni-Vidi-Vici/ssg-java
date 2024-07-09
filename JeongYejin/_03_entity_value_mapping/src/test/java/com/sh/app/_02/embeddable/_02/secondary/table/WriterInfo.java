package com.sh.app._02.embeddable._02.secondary.table;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WriterInfo implements Serializable {
    // EmbeddedId(끌고와서 식별자로 쓰는 경우)만 Serializable 필수 나머지는 해도 되고 안해도 되고
    @Column(name = "self_introduction", table = "tbl_writer_info")
    private String selfIntroduction;
}
