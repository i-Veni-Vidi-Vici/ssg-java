package com.sh.inheritance._03.abstraction;

import java.time.LocalDate;

public class Computer extends Product{

    private String cpu;
    private int ram;
    private int storage;
    private String os;

    public Computer() {
        super(); //자동으로 부모생성자를 호출함!
        System.out.println("Conputer 기본생성자 호출!!!");
    }

    public Computer(String code, String branc, String name, int price, LocalDate manufacturingDate, String cpu, int ram, int storage, String os) {
        //부모 생성자임
        super(code, branc, name, price, manufacturingDate);
        System.out.println("Computer 필드 생성자 호출");
        // 부모의 필드 접근제한자가 private이어서 접근이 불가함

//        this.code = code;
//        this.branc= branc;
//        this.name= name;
//        this.price = price;
//        this.manufacturingDate= manufacturingDate;
//        setter 방식 가능 이용하면 private 접근가능 함 근데 이거 안씀
//        this.setCode(code);
//        this.setBranc(branc);
//        this.setName(name);
//        this.setPrice(price);
//        this.setManufacturingDate(manufacturingDate);
//

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
     * - 부모로 붙 물려받은 필드/메소드에 접근할 수 있다.
     * - 자식클래스에서 부모영역에 대한 숨은 참조변수(포인터)
     *  this 는 현재 객체 super는 부모 영역
     *  -override 메소드안에서는 this와 구분된다.
     *  - 그외에는 super와 this가 동일하다. (this.getName = super.getName)
     * @return
     */
    @Override
    public String getInfo(){
        //super super 안붙이면 즉 그냥 getInfo로 하면 자동으로 this 가 생략되어 있음 , 현재객체 get info 계속 호출 됨.
        //그래서 super 키워드 꼭 붙여줘야함
        return "Computer ["+super.getInfo() +cpu + "," + ram + ", " + storage + ", " + os + "]";
    }
}
