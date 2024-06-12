package com.sh.spring.common.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // ToString은 Beverage클래스에 있는 필드만 만들어준다. 따라서 ToString(callSuper=true)를 사용해야 한다.
@NoArgsConstructor
@ToString(callSuper = true) // (부모 메소드에 있는 것을)super.toString() 내부적으로 호출해서 문자열에 포함시키기
//@AllArgsConstructor // 부모생성자에 있는 것까지 만들어주지 않는다. Beverage에 있는 필드만 만들어줌.
public class Beverage extends Product {
    private int capacity; // 용량

    // 따라서 lombok이 만들지 못하는 것은 직접 작성해야 한다.
    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }
}
