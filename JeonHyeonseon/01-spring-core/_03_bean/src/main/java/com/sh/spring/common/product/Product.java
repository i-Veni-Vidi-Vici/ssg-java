package com.sh.spring.common.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 일반 필드를 자식클래스에 상속하고자 하는 경우, 추상클래스를 사용해야 한다.
 *  - 인터페이스 사용불가
 * Product클래스에서 객체화를 방지한다. (new 연산자를 통한 생성자 호출이 불가능하다.)
 *  - 추상메소드는 없지만 new 연산자를 방지하기 위해서 추상클래스를 만든 것이다.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Product {
    private String name;
    private int price;
}
