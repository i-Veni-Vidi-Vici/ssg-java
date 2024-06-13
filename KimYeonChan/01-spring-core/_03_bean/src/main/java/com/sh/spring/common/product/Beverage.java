package com.sh.spring.common.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Beverage extends Product {
    private int capacity;

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }
}
