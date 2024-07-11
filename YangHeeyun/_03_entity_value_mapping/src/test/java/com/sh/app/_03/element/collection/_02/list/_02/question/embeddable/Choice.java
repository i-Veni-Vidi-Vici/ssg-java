package com.sh.app._03.element.collection._02.list._02.question.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Choice {
    @Column(name = "a")
    private String a;
    //    @Column(name = "b") // 생략가능
    private String b;
}