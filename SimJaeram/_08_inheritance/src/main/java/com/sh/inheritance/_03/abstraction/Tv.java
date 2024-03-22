package com.sh.inheritance._03.abstraction;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tv extends Product {
    private String resolution;      // 해상도, fhd, uhd, 4k, 8k
    private int size;

    // 생성자
    public Tv() {
        super();
    }

    public Tv(String code, String brand, String name, int price, LocalDate manufacturingDate,
              String resolution, int size) {
        super(code, brand, name, price, manufacturingDate);
        this.resolution = resolution;
        this.size = size;
    }
    @Override
    public String getInfo() {
        return "Tv[" + super.getInfo();
    }
}
