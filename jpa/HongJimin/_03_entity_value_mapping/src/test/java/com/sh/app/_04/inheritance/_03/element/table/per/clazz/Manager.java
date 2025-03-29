package com.sh.app._04.inheritance._03.element.table.per.clazz;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "Manager0403")
@Table(name = "tbl_manager_0403")
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
