package com.sh.inheritance._03._abstraction;

import java.time.LocalDate;

public class Tv extends Product {

    private String resolution;
    private int size;
    public Tv(){
        super();

    }
    public Tv(String code, String brand, String name, int price, LocalDate manufacturingDate,String resolution, int size){
        super(code,brand,name,price,manufacturingDate);
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
   /* public String getInfo(){

    }*/
}
