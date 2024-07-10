package com.sh._04.inheritance._03.table.per.clazz;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "Developer0403")
@Table(name = "tbl_developer_0403")
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Developer extends Employee {
    private String lang;

    public Developer(Long id, String name, String contact, String lang) {
        super(id, name, contact);
        this.lang = lang;
    }
}
