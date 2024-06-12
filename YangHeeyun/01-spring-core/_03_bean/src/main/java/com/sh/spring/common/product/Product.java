package com.sh.spring.common.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
자식클래스가 강제로 구현할 메소드가 필요한 경우 interface나 extends를 하면 되는데,
Interface가 못하는 일반 필드를 자식클래스에 상속하고자 하는 경우, 추상클래스 사용해야 한다.

Product클래스의 객체화를 방지한다. (new 연산자를 통한 생성자 호출이 불가능하게 막음)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Product {
    private String name;
    private int price;
}
