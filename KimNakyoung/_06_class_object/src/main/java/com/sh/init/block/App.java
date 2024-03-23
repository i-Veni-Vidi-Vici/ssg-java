package com.sh.init.block;

/**
 *
 * <pre>
 *  초기화 블럭
 *  - 인스턴스초기화 블런/static 초기화 블럭
 *  - 필드에 대한 초기화를 담당
 *
 * </pre>
 *
 */
public class App {
    public static void main(String[] args) {

//        Product product = new Product(); // 기본생성자
        // 인스턴스 변수 확인
        Product product = new Product("플랫화이트"); // 필드생성자
        System.out.println(product.getName());

        // 클래스 변수 확인
        System.out.println(Product.getBrand()); // static 클래스라서 객체 안만들어도 접근 가능
    }

}
