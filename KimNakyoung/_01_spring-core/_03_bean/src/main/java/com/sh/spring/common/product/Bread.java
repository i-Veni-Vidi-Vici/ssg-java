package com.sh.spring.common.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Bread extends Product{
    public Bread(String name, int price, LocalDateTime bakeAt) {
        super(name, price);
        this.bakeAt = bakeAt;
    }
    private LocalDateTime bakeAt;
}
