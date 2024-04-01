package com.sh.inheritance._03._abstraction;

import java.time.LocalDate;

public class Tv extends Product{
    private String resolution; // 해상도 fhd, uhd, 4k, 8k
    private int size;

    public Tv() {
        System.out.println("Tv 기본생성자 호출");
    }
    public Tv(String code, String brand, String name, int price, LocalDate manufacturing, String resolution, int size) {
        super(code, brand, name, price, manufacturing);
        this.resolution = resolution;
        this.size = size;
        System.out.println("Tv 필드생성자 호출");
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
        return "Tv[ " + super.getInfo() + ", " + resolution + ", " + size + "]";
    }
}
