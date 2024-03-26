package com.sh.polymorphism._02._abstracct._class;

public class SmartPhone extends Product{

    private String carrier;

    //기본생성자
    public SmartPhone() {
    }

    //파라미터 생성자
    public SmartPhone(String code, String name, int price, String carrier) {
        super(code, name, price);
        this.carrier =carrier;
    }

    /**
     *
     * 추상메소드를 구현하지 않으면 컴파일오류 발생
     */

    @Override
    public void printInfo(){
        System.out.println("[" + getCode() + "]" + "(" + carrier + ")" + getName() + "-" + getPrice() + "원");

    } // 이거 안 쓰면 컴파일 오류남  // 추상메소드 구현
}
