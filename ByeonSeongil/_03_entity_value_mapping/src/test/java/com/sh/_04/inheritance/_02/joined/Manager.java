package com.sh._04.inheritance._02.joined;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "Manager0402")
@Table(name = "tbl_manager_0402")
@DiscriminatorValue("manager") // Manager타입 구분하는 값을 dev로 지정 (기본값: Manager)
@Data
@NoArgsConstructor
public class Manager extends Employee {
    private String level;

    public Manager(Long id, String name, String contact, String level) {
        super(id, name, contact);
        this.level = level;
    }
}
