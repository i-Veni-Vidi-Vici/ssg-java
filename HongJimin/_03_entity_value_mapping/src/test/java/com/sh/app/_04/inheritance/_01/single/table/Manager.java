package com.sh.app._04.inheritance._01.single.table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "Manager0402")
@DiscriminatorValue("manager") // 🙉Manager 타입 구분하는 값을 manager로 지정(기본값 = Manager - class 이름!)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Manager extends Employee {
    private String level; // 어떤 언어 사용하는 개바자인지

    public Manager(Long id, String name, String contact, String level) {
        super(id, name, contact); //
        this.level = level;
    }
}
