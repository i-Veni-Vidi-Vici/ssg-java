package com.sh.init.block;

/**
 * <pre>
 *     인스턴스변수의 초기화 순서
 *     1. 타입별 기본 값이 세팅
 *     2. 명시한 변수 값 대입
 *     3. 초기화 블럭에서 값 대입
 *     4. 생성자에서 값 대입
 *
 *     클래스 변수의 값 대입 순서
 *     1. 타입별 기본 값 대입
 *     2. 명시한 값 대입
 *     3. static 초기화 블럭 값 대입
 * </pre>
 */
public class Product {
//    private String name;
//    private String name = "기계식 키보드";    //명시한 기본 값 대입
    private static String brand = "동서식품";
    //인스턴스 변수 초기화 블럭
    static {
//        name = "카페라떼";
        brand = "스벅";
    }


    public static String getBrand() {
        return brand;
    }
/*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(String name) {
        this.name = name;
    }
*/

}
