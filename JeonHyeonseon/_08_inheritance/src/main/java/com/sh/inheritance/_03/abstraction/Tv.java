package com.sh.inheritance._03.abstraction;

import java.time.LocalDate;

public class Tv extends Product{
//    private String code;
//    private String brand;
//    private String name;
//    private int price;
//    private LocalDate manufacturingDate;

    private String resolution; // 해상도 fhd, uhd, 4k. 8k 등등
    private int size;

    // 기본생성자
    public Tv(){
        super();
        System.out.println("Tv 기본생성자 호출");
    }

    // 필드생성자
    public Tv(String code, String brand, String name, int price, LocalDate manufacturingDate, String resolution, int size) {
        super(code, brand, name, price, manufacturingDate); // 나는 직접 접근을 못하니까 product생성자 너가 대신 해줘 라는 의미
        System.out.println("Tv 필드생성자 호출");

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
        return "Tv[" + super.getInfo() + resolution + ", " + size + "]";
    }
}
