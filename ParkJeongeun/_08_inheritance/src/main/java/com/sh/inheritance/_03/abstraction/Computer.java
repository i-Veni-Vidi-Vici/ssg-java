package com.sh.inheritance._03.abstraction;

import java.time.LocalDate;

public class Computer extends Product {
    private String cpu;
    private int ram;
    private int storage;
    private String os;

    public Computer() {
        System.out.println("Computer 기본생성자 호출!");
    }

    public Computer(String code, String brand, String name, int price, LocalDate manufacturingDate, String cpu, int ram, int storage, String os) {
        // 부모생성자로 필드에 접근
        super(code, brand, name, price, manufacturingDate);
        System.out.println("Computer 필드생성자 호출!");

        // 부모클래스에서 필드의 접근제한자가 private이어서 접근 불가
//        this.code = code;
//        this.brand = brand;
//        this.name = name;
//        this.price = price;
//        this.manufacturingDate = manufacturingDate;

//        // -> setter 사용 (이거보단 위에 super 생성자로 사용)
//        this.setCode(code);
//        this.setBrand(brand);
//        this.setName(name);
//        this.setPrice(price);
//        this.setManufacturingDate(manufacturingDate);

        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
    }

    /**
     * super.부모필드/메소드
     * - 부모로부터 물려받은 필드/메소드에 접근 가능
     * - 자식클래스에서 부모영역에 대한 숨은 참조변수(포인터)
     * - override메소드 안에서는 this와 구분됨
     * - 그외에는 super와 this가 동일 (this.getName() = super.getName())
     * @return
     */
    @Override
    public String getInfo(){
        return "Computer[" + super.getInfo() + ", " + cpu + ", " + ram + ", " + storage + ", " + os + "]";
    } // super.getInfo() : 부모클래스의 getInfo 메소드 호출
    // super 안붙이고 그냥 getInfo() 쓰면 이 클래스의 getInfo(이 클래스에서는 메소드) 의미
    // -> getInfo 메소드 안에서 또 그 getInfo 메소드 호출 -> 무한반복

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
