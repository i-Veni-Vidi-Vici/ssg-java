package com.sh.spring.common.product;
// 인터페이스와 추상클래스의 차이
// 둘 다 자식 클래스가 강제로 구현해야 할 메소드가 있을 때
// 굳이 추상클래스로 만드는 경우는 ?

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. 일반 필드를 자식클래스에 상속하고자 하는 경우, 추상클래스를 사용해야 한다.
 * 2. Product 클래스를 객체화를 방지한다 (new 연산자를 통한 생성자 호출 불가)
 */
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public abstract class Product {
    private String name;
    private int price;

    public Product() {
        System.out.println("Product 객체 생성👲👲👲");
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
        System.out.println("Product 객체 생성👲👲👲");
    }
}
