package com.sh.inheritance._03.abstraction;

import java.time.LocalDate;

public class Computer  extends Product{

    private String cpu;
    private int ram;
    private int storage;
    private String os;

    public Computer() {
        super(); // 자동으로 부모 생성자 호출
        System.out.println("💻Computer 기본 생성자 호출!");
    }


    public Computer(String code, String brand, String name, int price, LocalDate manufacturingDate, String cpu, int ram, int storage, String os) {
        // 부모 생성자
        super(code, brand, name, price, manufacturingDate);

        System.out.println("💻Computer 필드 생성자 호출!");

        //부모 필드 접근 제한자 private 접근 불가
//        this.code =code;
//        등등


        //setter 방식 가능
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

    /**
     * super. 부무 필드 /메소드
     * - 부모로부터 물려 받은 필드/메소드에 접근할 수 있다.
     * - 자식 클래스에서 부모 영역에 대한 숨은 참조변수(포인터)
     * - override메소드 안에서는 this와 구분된다.
     * - 그 외에는 super와 this가 동일하다.(this.getName() = super.getName())
     *
 =      * @return
     */

    public String getInfo() {
        return "💻Computer [" +super.getInfo() + ", " + cpu + ", "  + ram + ", " + storage + ", " + os + "]";
    }
}
