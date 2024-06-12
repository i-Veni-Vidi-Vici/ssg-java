package com.sh.spring.common.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
public class Bread extends Product{
    private LocalDateTime bakedAt; // 언제 만들어졋는가

    public Bread(String name, int price, LocalDateTime bakedAt) {
        super(name, price);
        this.bakedAt = bakedAt;
    }
}
