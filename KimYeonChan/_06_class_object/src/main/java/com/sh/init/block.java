package com.sh.init;

/**
 * 초기화 블럭
 * - 인스턴스 초기화 블럭 / static 초기화 블럭
 * - 필드에 대한 초기화를 담당.
 */
public class block {
    public static void main(String[] args) {
        Product product = new Product("화이트");
        // 인스턴스 변수 확인
        System.out.println(product.getName());
        // 클래스 변수 확인
        System.out.println(Product.getBrand());
    }
}
