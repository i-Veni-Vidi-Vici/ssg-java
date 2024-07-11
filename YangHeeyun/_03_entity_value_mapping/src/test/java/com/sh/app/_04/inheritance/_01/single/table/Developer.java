package com.sh.app._04.inheritance._01.single.table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("dev") // Developer타입 구분하는 값을 dev로 지정 (기본값: Developer). 자식클래스 타입을 dev로 지정
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Developer extends Employee {
    private String lang;

    // @AllArgsConstructor 사용 시 String lang만 생겨서 직접 적어줘야 한다.
    public Developer(Long id, String name, String contact, String lang) {
        super(id, name, contact);
        this.lang = lang;
    }
}