package com.sh.app._04.inheritance._03.table.per.clazz;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "Manager0403")
@Table(name = "tbl_manager_0403")
@Data
@NoArgsConstructor
@ToString(callSuper = true) // Manager(super=Employee(id=2, name=신사임당, contact=010-6789-6789), level=M3)를 보여주게 하는 어노테이션
public class Manager extends Employee {
    private String level;

    // @AllArgsConstructor을 사용하지 않고 직접 만듦 -> 이유가 무엇인지 알아보기
    public Manager(Long id, String name, String contact, String level) {
        super(id, name, contact);
        this.level = level;
    }
}
