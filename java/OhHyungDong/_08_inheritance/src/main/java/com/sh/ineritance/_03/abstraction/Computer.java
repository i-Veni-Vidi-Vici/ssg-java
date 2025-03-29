package com.sh.ineritance._03.abstraction;

import java.time.LocalDate;

public class Computer extends Product
{

    private String cpu;
    private int ram;
    private int stoarge;
    private String os;


    public Computer()
    {
        System.out.println("컴퓨터 기본 생성자 호출 ");
    }

    public Computer(String code, String brand, String name, int price, LocalDate manufacturingDate,
                    String cpu, int ram, int stoarge, String os) {
        //직접 접근이 안될때 부모 생성자를 호출하여 우회하여 접근 가능
        super(code, brand, name, price, manufacturingDate);
        //부모 필드 접근 제한자 private이어서 접근 불가
        System.out.println("컴퓨터 필드 생성자 호출 ");

        //setter방식 가능
//        this.setCode(code);
//        this.setBrand(brand);
//        this.setName(name);
//        this.setPrice(price);
//        this.setManufacturingDate(manufacturingDate);

        this.cpu = cpu;
        this.ram = ram;
        this.stoarge = stoarge;
        this.os = os;
    }

    /**
     * super.부모 필드 / 메소드
     * - 부모로부터 물려 받은 필드/메소드에 접근 할 수 있다.
     * - 자식 클래스에서 부모 영역에 대한 숨은 참조변수(포인터)
     * - this : 현재 객체, super : 부모
     * - override 메소드 안에서는 This와 구분된다.
     * - 그 외에는 super와 this가 동일하다. => this.getName() = super.getName()
     *
     *
     * @return
     */
    @Override
    public String getInfo(){
        return "Computer["+ super.getInfo() + "," + cpu + "," + ram + "," + stoarge +"," + os;
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

    public int getStoarge() {
        return stoarge;
    }

    public void setStoarge(int stoarge) {
        this.stoarge = stoarge;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
