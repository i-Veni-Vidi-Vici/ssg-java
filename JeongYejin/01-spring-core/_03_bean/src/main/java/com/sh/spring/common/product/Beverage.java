package com.sh.spring.common.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true) // super.toString() 내부적으로 호출해서 문자열에 포함
//@AllArgsConstructor // 부모필드에 있는 것까지 만들어주진 않는다
public class Beverage extends Product {
    private int capacity;

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }
}
