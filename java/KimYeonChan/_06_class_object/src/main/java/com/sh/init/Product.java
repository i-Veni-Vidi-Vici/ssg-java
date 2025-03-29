package com.sh.init;

/**
 * 인스턴스 변수의 초기화 순서
 * 1. 타입별 기본값 대입
 * 2. 명시한 변수값 대입
 * 3. 초기화 블럭 값대입
 * 4. 생성자에서 값 대입
 * 클래스 변수의 초기화 순서
 * 1. 타입별 기본값 대입
 * 2. 명시한 값 대입
 * 3. static 초기화 블럭 값 대입
 */
public class Product {
    private static String brand = "동서식품";
    // 클래스 영역에 실행 코드를 작성할 수 없다.
    static {
        brand = "오뚜기";
        brand += "메가커피";
        brand += "팔도";
    }
    private String name = "기계식 키보드";
    // 인스턴스변수 초기화 블럭
    {
        name = "카페라떼";
    }

    public Product(String name) {
        this.name = name;
    }

    public static String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }
}
