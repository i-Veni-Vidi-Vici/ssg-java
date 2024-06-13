package com.sh.spring.common.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
//@AllArgsConstructor // 이건 좀 조심, 상속받은 건
@ToString(callSuper = true) // 부모필드까지 toString하게 해주세요
public class Beverage extends Product{
    private int capacity;

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }
}
