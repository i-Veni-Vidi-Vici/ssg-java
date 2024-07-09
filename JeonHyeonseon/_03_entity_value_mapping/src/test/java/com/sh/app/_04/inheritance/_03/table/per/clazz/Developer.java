package com.sh.app._04.inheritance._03.table.per.clazz;

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
@ToString(callSuper = true) // Developer(super=Employee(id=1, name=홍길동, contact=010-1234-1234), lang=JAVA) 보여주게 하는 어노테이션
public class Developer extends Employee {
    private String lang; // 무슨 언어 개발자예요

    // @AllArgsConstructor을 사용하지 않고 직접 만듦 -> 이유가 무엇인지 알아보기
    public Developer(Long id, String name, String contact, String lang) {
        super(id, name, contact);
        this.lang = lang;
    }
}
