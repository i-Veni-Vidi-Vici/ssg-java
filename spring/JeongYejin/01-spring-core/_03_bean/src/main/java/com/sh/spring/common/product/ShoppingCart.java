package com.sh.spring.common.product;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShoppingCart {
    private final List<Product> items = new ArrayList<>(); // setter로 못 고치는

    public ShoppingCart() {
        System.out.println("ShoppingCart 객체 생성👼👼👼");
    }

    public void addItem(Product item) {
        this.items.add(item);
    }
}
