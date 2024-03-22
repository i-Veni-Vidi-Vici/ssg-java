package com.sh.init.block;

/**
 * 인스턴스 변수의 초기화 순서
 * 1. 타입별 기본값 대입
 * 2. 명시한 변수 값 대입
 * 3. 초기화 블럭에서 값 대입
 * 4. 생성자 값 대입
 *
 * 클래스 변수의 값 대입 순서
 * 1. 타입별 기본값 대입
 * 2. 명시한 값 대입
 * 3. static 초기화 블럭 값대입
 */
public class Product {
    private static String brand = "동서식품";
    private String name = "아메리카노";
    // brand += "스타벅스" // 클래스 영역에 실행코드 작성할 수 없다.
    // 인스턴스 변수 초기화 블럭
    {
        name = "카페라떼";
    }
    static {
        brand = "스타벅스";
    }
    public Product(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getBrand() {
        return brand;
    }
}
