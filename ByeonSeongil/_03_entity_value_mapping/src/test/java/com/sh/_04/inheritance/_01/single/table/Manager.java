package com.sh._04.inheritance._01.single.table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("manager") // Manager타입 구분하는 값을 dev로 지정 (기본값: Manager)
@Data
@NoArgsConstructor
public class Manager extends Employee{
    private String level;

    public Manager(Long id, String name, String contact, String level) {
        super(id, name, contact);
        this.level = level;
    }
}
