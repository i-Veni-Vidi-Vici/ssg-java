package com.sh.app._06.composite.key._02.idclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Embeddable
 * @EmbeddId 또는 @Embedded를 사용해서 다른 엔티티의 속성으로 사용될 클래스
 * - public/protected 기본생성자를 구현해야 한다.
 * - Serializable 인터페이스를 구현해야 한다.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorClazzId  {

    private Long professorId;

    private Long clazzId;

}
