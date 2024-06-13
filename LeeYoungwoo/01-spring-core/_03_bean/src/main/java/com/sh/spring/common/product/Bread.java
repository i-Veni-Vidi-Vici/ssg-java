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

    public Bread(String name, int price, LocalDateTime bakedAt) {
        super(name, price);
        this.bakedAt = bakedAt;
    }
}
