package com.sh._04.inheritance._01.single.table;


import jakarta.persistence.Cache;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@DiscriminatorValue("dev") // 부모의 타입의 값을 뭐라고 할까요??// 기본값 Developer타입 구분하는 값을  dev로 지정 (기본값 : Developer
// 짝꿍이 있다,
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Developer extends Employee{

    private String lang;

    public Developer(Long id, String name, String contact, String lang) {
        super(id, name, contact);
        this.lang = lang;
    }
}
