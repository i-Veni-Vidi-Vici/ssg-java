package com.sh.app._06.composite.primary.key._02.idclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorClazzId {
    private Long professorId;
    private Long clazzId;
}
