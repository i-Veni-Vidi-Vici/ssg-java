package com.sh.spring.common.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 일반 필드를 자식클래스에게 상속하고자 하는 경우, 추상클래스를 사용해야 한다.(이 경우 인터페이스는 못함)
 * Product클래스의 객체화를 방지한다. (new 연산자를 통한 생성자 호출 불가)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Product {
    private String name;
    private int price;
}
