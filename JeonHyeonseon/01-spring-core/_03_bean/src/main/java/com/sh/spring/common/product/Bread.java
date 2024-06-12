package com.sh.spring.common.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Bread extends Product{
    private LocalDateTime bakedAt;

    // 부모클래스에 있는 필드도 같이 생성된 것.
    public Bread(String name, int price, LocalDateTime bakedAt) {
        super(name, price);
        this.bakedAt = bakedAt;
    }
}
