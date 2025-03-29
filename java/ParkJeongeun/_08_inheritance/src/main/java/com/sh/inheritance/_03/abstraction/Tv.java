package com.sh.inheritance._03.abstraction;

import java.time.LocalDate;

public class Tv extends Product {
    private String resolution; // 해상도 fhd, uhd, 4k, 8k
    private int size;

    public Tv(){
        System.out.println("Tv 기본생성자 호출!");
    }
    public Tv(String code, String brand, String name, int price, LocalDate manufacturingDate, String resolution, int size){
        super(code, brand, name, price, manufacturingDate);
        System.out.println("Tv 필드생성자 호출!");
        this.resolution = resolution;
        this.size = size;
    }

    @Override
    public String getInfo(){
        return "Tv[" + super.getInfo() + ", " + resolution + ", " + size + "]";
    }

    public void setResolution(String resolution){
        this.resolution = resolution;
    }
    public String getResolution(){
        return this.resolution;
    }
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }
}
