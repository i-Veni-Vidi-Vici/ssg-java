package com.sh.app._03.element.collection._02.list._02.question.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

@Embeddable // 🙉embed 쌉가넝~
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Choice { // a와 b가 잘 매칭되었는가? 를 보기 이함!!
    @Column(name = "a") // 이럴땐 column 생략해도됨ㅎ
    private String a;
    @Column(name = "b")
    private String b;
}
