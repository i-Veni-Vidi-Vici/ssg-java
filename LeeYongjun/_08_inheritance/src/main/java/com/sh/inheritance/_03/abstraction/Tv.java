package com.sh.inheritance._03.abstraction;

import java.time.LocalDate;

public class Tv extends Product{
    private String resolution; // 해상도
    private int size;

    public Tv() {
        super(); // 자동으로 부모생성자 호출!
        System.out.println("Tv 기본생성자 호출!!!");
    }

    public Tv(String code, String brand, String name, int price, LocalDate manufacturingDate, String resolution, int size) {
        super(code, brand, name, price, manufacturingDate);
        System.out.println("Tv 핃드생성자 호출!!!");
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
    public String getInfo(){
        return "Tv[" + super.getInfo() + ", " + resolution + ", " + size + "]";
    }
}
