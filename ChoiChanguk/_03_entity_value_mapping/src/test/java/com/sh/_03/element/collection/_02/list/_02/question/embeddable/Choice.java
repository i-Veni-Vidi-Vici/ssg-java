package com.sh._03.element.collection._02.list._02.question.embeddable;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Setter(AccessLevel.PRIVATE) // ().setter로 접근을 못함 따로 메소드를 만들어야 함
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Choice {

    @Column(name = "a")
    private String a;

    @Column(name = "b")
    private String b;

}
