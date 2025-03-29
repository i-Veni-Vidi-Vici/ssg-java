package com.sh.app._03.element.collection._02.list._02.question.embeddable;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;


@Embeddable // 임베더블 이라는건 임베드 할 수 있는거에요 가져다 쓰세요 ! 라는 뜻
@Data
@Setter(AccessLevel.PRIVATE) // 세터는 프라이빗으로 만들어라 Vo는
@NoArgsConstructor
@AllArgsConstructor
public class Choice {
    @Column(name = "a")
    private String a;
    @Column(name = "b")
    private String b;
}
