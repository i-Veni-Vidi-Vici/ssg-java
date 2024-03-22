package com.sh.init.block;

/**
 * <pre>
 * 인스턴스 변수의 초기화 순서
 * 1. 타입별 기본값 대입 -> 0,null 등등
 * 2. 명시한 변수 값대입 -> String name = "기계식 키보드"
 * 3. 초기화 블럭에서 값대입 -> { 변수 = ~}
 * 4. 생성자에서 값 대입
 *
 * 클래스변수의 값대입 순서
 * 1. 타입별 기본값 대입
 * 2. 명시한 값 대입
 * 3. static 초기화블럭 값대입 static { 변수 = ~}
 * </pre>
 */
public class Product {
    private static String brand = "동서식품";

    private String name = "아메리카노";

    //객체를 만들지 않고 접근하기 위해 씀
    public static String getBrand() {
        return brand;
    }

    public static void setBrand(String brand) {
        Product.brand = brand;
    }

     //인스턴수변수 초기화 블럭
     {
         name="카페라떼";
     }

     // static 초기화 블럭
     static {
        // 필드에서는 이렇게 처리를 못하니 블럭을 써서 쓴다
         brand = "스타벅스";
         brand += "메가커피";
         brand += "커피집";
     }

     //생성자를 통한 초기화(우선순위가 가장 높다)
    public Product(String name) {
         this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
