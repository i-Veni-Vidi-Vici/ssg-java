package com.sh.spring.common.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true) // 부모 super.toString() 내부적으로 문자열에 포함
public class Beverage extends Product{
    private int capacity;

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }

    public Beverage(int capacity) {
        this.capacity = capacity;
    }
}
