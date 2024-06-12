package com.sh.spring.common.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
//@AllArgsConstructor 이거 안함 이거 하면 부모생성자까지 안넣어서 만들어줘서 안됨
@ToString(callSuper = true) // 부모까지 더해서 toString 만듦. // super.toString() 내부적으로 호출해서 문자열에 포함
public class Beverage extends Product{
    private int capacity;

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }
}
