package com.sh.ineritance._03.abstraction;

import java.time.LocalDate;

public class Tv extends Product {

    private String resolution; //해상도 fhd, uhd, 4k 8k
    private int size;

    public Tv() {
        super();
    }

    public Tv(String code, String brand, String name, int price, LocalDate manufacturingDate
             , String resolution, int size)
    {
        super(code, brand, name, price, manufacturingDate);
        System.out.println("티비 생성자 호출");

        this.resolution = resolution;
        this.size = size;
    }

    @Override
    public String getInfo(){
        return "Computer["+ super.getInfo() + "," + resolution + "," + size ;
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
}
