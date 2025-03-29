package com.sh.inheritance._03.abstraction;

import java.time.LocalDate;

public class Tv extends Product{

    private String resolution; //해상도 fhd, uhd, 4k, 8k
    private int size;

    public Tv(){} //기본 생성자

    public Tv(String code, String brand, String name, int price, LocalDate manufacturingDate, String resolution, int size) {
        super(code, brand, name, price, manufacturingDate); //product의 private 변수들에 접근하는 방식 = super
        System.out.println("📺Tv 생성자 호출!");
        this.resolution = resolution;
        this.size = size;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String getInfo() {
        return "📺Tv [" + super.getInfo() + ", " + resolution + ", " + size + "]";
    }
}



