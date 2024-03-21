package com.sh.init.block;

import java.io.PrintStream;

/**
 * <pre>
 * 초기화블럭
 * - 인스턴스 초기화 블럭/ static 초기화 블럭
 * - 필드에 대한 초기화를 담당
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        Product product = new Product("카푸치노");
        System.out.println(product.getName());

        System.out.println(Product.getBrand());

    }
}
