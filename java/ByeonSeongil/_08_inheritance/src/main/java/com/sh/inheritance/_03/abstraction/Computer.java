package com.sh.inheritance._03.abstraction;

import java.time.LocalDateTime;

public class Computer extends Product {

    private String cpu;
    private  int ram;
    private  int storage;
    private String os;

    public Computer() {
        super(); // 자동으로 부모생성자 호출
        System.out.println("Computer 기본생성자 호출!!!");
    }

    public Computer(String code, String brand, String name, int price, LocalDateTime manufacturingDate,
                    String cpu, int ram, int storage, String os) {

        super(code, brand, name, price, manufacturingDate);
        System.out.println("Computer 필드생성자 호출!");

        // 부모 필드 접근제한자 private 이어서 접근불가
//        this.code  =code;


        // 사용안함
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
     * super. 부모필드/메서드
     * - 부모로부터 물려받은 필드/메서드에 접근할 수 있음
     * - 자식클래스에서 부모영역에 대한 숨은 참조변수(포인터)
     * - override메서드 안에서는 this와 구분됨
     * - 그외에는 super와 this가 동일함 .(this.getName() == super.getName())
     * @return
     */
    @Override
    public String getInfo() {
        System.out.println(super.code + code);
        return "Computer[" + super.getInfo() +", " + cpu + ", " + ram + ", " + storage + ", " + os + "]";
    }



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
