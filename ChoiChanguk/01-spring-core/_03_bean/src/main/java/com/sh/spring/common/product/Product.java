package com.sh.spring.common.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * abstract(추상 클래스) 쓰는 경우
 * - 일반 필드를 자식클래스에게 상속하고자 하는 경우
 * - Product의 객체화를 막을 수 있다
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Product {
    private String name;
    private int price;
}
