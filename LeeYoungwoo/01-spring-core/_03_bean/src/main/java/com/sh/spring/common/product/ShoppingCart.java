package com.sh.spring.common.product;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShoppingCart {
    private final List<Product> items = new ArrayList<>();

    public ShoppingCart() {
        System.out.println("ShoppingCart 객체가 생성되었습니다...");
    }

    public void addItem(Product item) {
        this.items.add(item);
    }

}
