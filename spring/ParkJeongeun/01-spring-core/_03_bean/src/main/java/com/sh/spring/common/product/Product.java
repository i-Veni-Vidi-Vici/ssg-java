package com.sh.spring.common.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 추상클래스 : 일반 필드를 자식클래스에게 상속하고자 하는 경우
 * Product 클래스의 객체화 방지(new 연산자를 통한 생성자 호출 불가)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Product {
    private String name;
    private int price;
}