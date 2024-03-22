package com.sh.init.block;

/**
 * <pre>
 * 인스턴스변수의 초기화 순서(값대입 순서)
 * 1. 타입별 기본값 대입
 * 2. 명시한 변수 값대입
 * 3. 초기화블럭에서 값대입
 * 4. 생성자 값대입 ❗❗ -> 우선순위가 가장 높아 제일 많이 사용한다.
 *
 * 클래스변수의 값대입 순서
 * 1. 타입별 기본값 대입
 * 2. 명시한 값 대입 ❗❗
 * 3. static 초기화블럭 값대입 ❗❗
 *
 * </pre>
 */
public class Product {
    private static String brand = "동서식품";
//    brand += "스타벅스"; // 클래스영역에 실행코드 작성할 수 없다.

    private String name = "아메리카노";

    // 3. 인스턴스변수 초기화 블럭
    {
        name = "카페라떼";
    }

    // 3. 클래스변수 초기화 블럭
    static {
        brand = "스타벅스";
    }

    public Product(String name) {
        // 4. 생성자를 통한 초기화 (우선순위가 가장 높다)
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getBrand() {   //static메소드로 접근했기때문에 static이다.
        return brand;
    }
}
