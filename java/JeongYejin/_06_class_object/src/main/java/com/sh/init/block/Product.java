package com.sh.init.block;

/**
 * <pre>
 * 인스턴스 변수의 초기화 순서
 * 1. 타입별 기본값 대입
 * 2. 명시한 변수 값대입
 * 3. 초기화블럭 값대입
 * 4. 생성자 값대입
 *
 * 클래스변수의 값대입 순서
 * 1.타입별 기본값 대입
 * 2.명시한 값 대입
 * 3. static 초기화블럭 값대입
 * </pre>
 */
public class Product {
    // 필드 선언문에서는 한 줄 밖에 못씀
    private static String brand = "동서식품";
    public String name = "기계식 키보드";
//    brand += "스타벅스"; 클래스 영역에 실행코드 작성 불가

    // 인스턴스변수 초기화 블럭
    {
        name = "카페라떼";
    }
    static {
        brand = "스타벅스";
        brand += "메가커피";
        brand += "만랩커피";
    }

    public String getName() {
        return name;
    }

    public static String getBrand() {
        return brand;
    } // static 자원에 접근할 수 있는 건 static 메소드가 유일합니다

    public Product(String name) {
        // 생성자를 통한 초기화 (우선순위가 가장 높다)
        this.name = name;
    }
}
