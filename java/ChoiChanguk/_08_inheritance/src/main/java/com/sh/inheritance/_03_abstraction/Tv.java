package com.sh.inheritance._03_abstraction;

import java.time.LocalDate;

public class Tv extends Product{
    private String resolution; //해상도
    private int size;
    public Tv(){
        System.out.println("Tv의 기본 생성자입니다");
    }

    public Tv(String code, String brand, String name, int price, LocalDate manuFacturingDate,
              String resolution, int size) {
        super(code, brand, name, price, manuFacturingDate);//상속 받은 필드니깐 너가 값을 받으면 내가 가져갈께

        System.out.println("Tv의 필드 생성자 입니다");
        this.resolution = resolution;
        this.size = size;
    }

    @Override
    public String getInfo() {
        return "Tv Infor["+"여기는 부모("+super.getInfo()+ "), "+resolution+", "+size+"]";
    }
}
