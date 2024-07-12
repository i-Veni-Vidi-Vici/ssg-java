package com.sh.app._04.inheritance._01.single.table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("dev") // 🙉Developer 타입 구분하는 값을 dev로 지정(기본값 = Developer - class 이름!)
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
