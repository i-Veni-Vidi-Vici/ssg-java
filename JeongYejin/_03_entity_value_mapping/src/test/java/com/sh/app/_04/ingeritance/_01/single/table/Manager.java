package com.sh.app._04.ingeritance._01.single.table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("manager") // Manager타입 구분하는 값을 manager로 지정 (기본값: Manager)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Manager extends Employee {
    private String level; // 무슨 언어하는 개발자예요

    public Manager(Long id, String name, String contact, String level) {
        super(id, name, contact);
        this.level = level;
    }
}
