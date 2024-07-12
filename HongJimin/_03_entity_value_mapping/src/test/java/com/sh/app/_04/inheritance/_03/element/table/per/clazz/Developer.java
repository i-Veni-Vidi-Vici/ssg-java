package com.sh.app._04.inheritance._03.element.table.per.clazz;

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
    private String lang; // 어떤 언어 사용하는 개발자인지

    public Developer(Long id, String name, String contact, String lang) {
        super(id, name, contact); //
        this.lang = lang;
    }
}
