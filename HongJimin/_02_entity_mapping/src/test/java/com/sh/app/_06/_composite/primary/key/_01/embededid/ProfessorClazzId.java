package com.sh.app._06._composite.primary.key._01.embededid;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @embeddable
 * - @EmbeddedId 또는 @Embedded를 사용해 다른 엔티티의 속성으로 사용될 클래스
 * - public / protected 기본 생성자를 구현해야 한다.
 * - Serializable 인터페인스를 구현해야 한다.
 */
@Embeddable // 다른데 끼워넣을 수 있어! 라는 의미
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorClazzId implements Serializable {
    @Column(name = "professor_id")
    private Long professorId;
    @Column(name = "clazz_id")
    private Long clazzId;
}
