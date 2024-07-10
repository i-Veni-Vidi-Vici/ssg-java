package com.sh._04.inheritance._03.table.per.clazz;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "Manager0403")
@Table(name = "tbl_manager_0403")
@Data
@NoArgsConstructor
public class Manager extends Employee {
    private String level;

    public Manager(Long id, String name, String contact, String level) {
        super(id, name, contact);
        this.level = level;
    }
}
