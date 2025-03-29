package com.sh.init.block;

/**
 * 인스턴스변수의 초기화 순서
 * 1. 타입별 기본값 대입
 * 2. 명시한 변수 값 대입
 * 3. 초기화블럭 값대입
 * 4. 생성자 값대입
 *
 * 클래스변수의 값 대입 순서
 * 1. 타입별 기본 값
 * 2. 명시한 기본 값 대입
 * 3. static 초기화블록 초기화
 *  - 클래스 변수이므로 생성자 초기화 불가능
 *
 *  기본 값 대입 연산은 한줄의 수행문만 가능하므로 복잡한 연산이 필요한 경우 초기화 블록 사용
 */
public class Product {

    //명시적 기본값 초기화
    private String name="기본값";
    private static String brand ="명시적할당값";

    //인스턴스 초기화 블록
    {
        name="인스턴스초기화값";
    }
    static{
        brand = "static 블록 초기화 값";
    }
    public Product(String name){
        //생성자를 통한 초기화(우선순위 가장 높다. 가장 늦게 값 할당)
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getBrand(){
        return brand;
    }
}
