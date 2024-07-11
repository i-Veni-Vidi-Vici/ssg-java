package com.sh.app._04.inheritance._01.single.table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("dev") // Developer타입 구분하는 값을 dev로 지정 (기본값: Developer)
@Data
@NoArgsConstructor
@ToString(callSuper = true) // Developer(super=Employee(id=1, name=홍길동, contact=010-1234-1234), lang=JAVA) 보여주게 하는 어노테이션
public class Developer extends Employee{
    private String lang; // 무슨 언어 개발자예요

    // @AllArgsConstructor을 사용하지 않고 직접 만듦 -> 이유가 무엇인지 알아보기
    public Developer(Long id, String name, String contact, String lang) {
        super(id, name, contact);
        this.lang = lang;
    }
}
