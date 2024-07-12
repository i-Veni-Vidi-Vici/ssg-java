package com.sh.app._03.element.collection._02.list._02.question.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PRIVATE)
@Embeddable
public class Choice {
    @Column(name="a")
    private String a;
    @Column(name="b")
    private String b;
}
