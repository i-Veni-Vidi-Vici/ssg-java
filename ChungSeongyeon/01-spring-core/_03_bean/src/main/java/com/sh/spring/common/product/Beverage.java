package com.sh.spring.common.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true) // super.toString() 내부적으로 호출해서 문자열에 포함
public class Beverage extends Product {
    private int capacity;

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }
}
