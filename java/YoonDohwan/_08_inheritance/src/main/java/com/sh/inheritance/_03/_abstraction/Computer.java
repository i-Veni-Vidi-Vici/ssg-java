package com.sh.inheritance._03._abstraction;

import java.time.LocalDate;

public class Computer extends Product{

    private String cpu;
    private int ram;
    private int storage;
    private String os;

    public Computer() {
        super();
        System.out.println("Computer 기본생성자 호출!!!");
    }

    public Computer(String code, String brand, String name, int price, LocalDate manufacturingDate, String cpu, int ram, int storage, String os) {
        super(code, brand, name, price, manufacturingDate);
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
     * super. 부모필드/메소드
     * 부모로 부터 ㅂ물려받은 필드/메소드에 접근할 수 있다.
     * 자식클래스에서 부모영역에 대한 숨은 참조변수(포인터)
     * -override메소드안에서는 this와 구분된다.
     * 그 외에는 super와 this가 동일하다.
     * @return
     */
    public String getInfo(){
        return "Computer["+cpu+", "+ ram + ", "+storage+", "+os+"]";
    }


}
