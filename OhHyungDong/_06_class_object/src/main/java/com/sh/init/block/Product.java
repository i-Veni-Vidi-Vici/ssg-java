package com.sh.init.block;

/**
 * 인스턴스변수의 초기화 순서
 * 1. 타입별 기본값 세팅
 * 2. 명시한 변수 값 대입
 * 3. 초기화 블럭에서 값 대입
 * 4. 생성자에서 값 대입
 *
 * 클래스변수의 값 대입 순서
 * 1. 타입별 기본값 대입
 * 2. 명시한 값 대입
 * 3. static초기화 블럭 값 대입 -> 여러줄 처리해야되면 블럭 많이 사용
 */
public class Product {

    private  static String brand = "동서 식품";
//    brand += "스타벅스"; 클래스 영역에 실행코드 작성 할 수 없음
    private String name = "아메리카노";

    //인스턴스 변수 초기화 블럭
    {
        name = "카페라떼";
    }

    //클래스 변수 초기화 블럭, static변수에서 우선순위가 가장 높음 .
    static{
        brand = "STARBUKS";
    }
    //우선순위가 가장 높다.
    public Product(String name){
        this.name = name;
    }

    public static String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }
}
