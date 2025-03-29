package com.sh.init.block;

/**
 * <pre>
 * 인스턴스 변수의 초기화 순서
 * 1. 타입별 기본값 대입
 * 2. 명시한 변수 값대입
 * 3. 초기화 블럭에서 값대입
 * 4. 생성자 값대입
 *
 * 클래스 변수의 값대입 순서
 * 1. 타입별 기본값 대입
 * 2. 명시한 값 대입
 * 3. static 초기화블럭 값대입
 *
 * </pre>
 */

public class Product {
    private static String brand = "동서식품";
//    brand += "스타벅스"; // 클래스 영역에 소스코드 불가능.
    private String name = "Americano";

    // 인스턴스 변수 초기화 블럭
    {
        name = "Cafe Latte";
    }

    // 클래스 변수 초기화 블럭
    static {
        brand = "StarBucks";
        brand += "메가커피";
        brand += "빽다방";
    }

    public Product(String name){
        // 생성자를 통한 초기화 (우선순위가 가장 높다.)
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static String getBrand() {
        return brand;
    }

}
