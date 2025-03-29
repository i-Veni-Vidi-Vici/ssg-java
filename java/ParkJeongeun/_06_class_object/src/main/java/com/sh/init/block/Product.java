package com.sh.init.block;

/**
 * <pre>
 * 인스턴스 변수의 초기화 순서
 * 1. 타입별 기본값 세팅
 * 2. 변수 값대입 명시
 * 3. 초기화 블럭 값대입
 * 4. 생성자에서 값대입 (1~4번으로 갈수록 우선 출력)
 *
 * 클래스 변수의 값대입 순서
 * 1. 타입별 기본값 대입
 * 2. 명시한 값 대입
 * 3. static 초기화 블럭 값대입
 * * 객체 만들어서 접근 X 클래스로 접근 -> 생성자 없음
 *
 * 보통 우선순위가 높은 값대입 사용
 * </pre>
 */
public class Product {
    private static String brand = "동서식품";
    // 클래스 영역에 실행코드 작성할 수 없음 -> 블럭에 작성
//    brand += "스타벅스";

    private String name = "아메리카노";

    // 인스턴스 변수 초기화 블럭
    {
        name = "카페라떼";
    }

    static {
        brand = "스타벅스";
        brand += "메가커피";
        brand += "투썸";

    }

    public Product(String name){
        // 생성자를 통한 초기화(우선순위가 가장 높음)
        // 위에 아메리카노, 카페라떼 써도 출력되지 않고 이게 사용됨
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getBrand() {
        return brand;
    }
}
