package com.sh.spring.common.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
상속할때 Lombok @AllArgsConstructor하면 생성자 Beverage(int)만 만들어줘서 셀프로 만들어주기
*/
@Data
@NoArgsConstructor
@ToString(callSuper = true) // super.toString() 내부적으로 호출해서 문자열에 포함. 기본값 false
public class Beverage extends Product{
    private int capacity;

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }
}
