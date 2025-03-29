package com.sh.inheritance._03.abstraction;

import java.time.LocalDate;

// TV만의 무언가 덧대서 특수화 했다.
public class Tv extends Product{
//    private String code;
//    private String brand;
//
//    private String name;
//    private int price;
//    private LocalDate manufacturingDate;

    private String resolution; // 해상도 fnd,uhd, 4K, 8K
    private  int size;

    // 기본생성자
    public Tv(){
        super();

    }

    public Tv(String code, String brand, String name, int price, LocalDate manufacturingDate,
              String resolution,int size){
        super(code,brand,name,price,manufacturingDate); // 상속받은거 직접접근 못 하니까

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
        return "Tv : [" + super.getInfo() + " ," + resolution + " ," + size + "]" ;
    }
}
