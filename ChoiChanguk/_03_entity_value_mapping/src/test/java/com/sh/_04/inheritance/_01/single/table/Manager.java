package com.sh._04.inheritance._01.single.table;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("manager") // Manager타입 구분하는 값을 manager로 지정(기본값 : manager)
public class Manager extends Employee{

    private String level;

    public Manager(Long id, String name, String contact, String level) {
        super(id, name, contact);
        this.level = level;
    }
}
