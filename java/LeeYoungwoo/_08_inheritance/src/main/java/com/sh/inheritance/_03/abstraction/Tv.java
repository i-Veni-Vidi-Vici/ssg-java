package com.sh.inheritance._03.abstraction;

import java.time.LocalDate;

public class Tv extends Product {
    // tv만의 특성 필드
    private String resolution; // 해상도
    private int size;

    // 생성자
    public Tv() {
        System.out.println("Tv 기본생성자 출력!");
    }

    public Tv(String code, String brand, String name, int price, LocalDate manufacturingDate,
              String resolution, int size) {
        super(code, brand, name, price, manufacturingDate);
        this.resolution = resolution;
        this.size = size;
        System.out.println("Tv 필드생성자 출력!");
    }

    // getter/setter
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

    public String getInfo() {
        return "Tv[" + super.getInfo() + ", " + resolution + ", " + size + "]";
    }
}
