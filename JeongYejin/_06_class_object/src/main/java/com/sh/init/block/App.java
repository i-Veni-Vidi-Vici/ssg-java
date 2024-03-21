package com.sh.init.block;

/**
 * <pre>
 * 초기화블럭
 * - 인스턴스초기화블럭/static초기화블럭
 * - 필드에 대한 초기화를 담당
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        Product product = new Product("플랫화이트");
        System.out.println(product.getName());
        System.out.println(product.getBrand());
    }
}
