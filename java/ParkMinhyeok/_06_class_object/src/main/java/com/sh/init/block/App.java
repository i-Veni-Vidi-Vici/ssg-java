package com.sh.init.block;

public class App {
    public static void main(String[] args) {

        Product product = new Product("플랫화이트");
        System.out.println(product.getName());

        System.out.println(Product.getBrand());
    }
}
