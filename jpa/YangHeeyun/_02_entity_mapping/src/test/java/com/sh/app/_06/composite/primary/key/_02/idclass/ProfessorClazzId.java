package com.sh.app._06.composite.primary.key._02.idclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// @Embeddable이 아닌 일반 클래스여도 상관없다
public class ProfessorClazzId {
    private Long professorId;
    private Long clazzId;
}