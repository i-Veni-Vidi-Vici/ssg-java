package com.sh.inheritance._03_abstraction;

import java.time.LocalDate;

public class Computer extends Product{

    private String cpu;
    private int ram;
    private int storage;
    private String os;

    public Computer() {
        super();// 자동으로 부모생성자 호출// 숨어져있다
        System.out.println("Computer 기본생성자 호출");
    }

    public Computer(String code, String brand, String name, int price,
                    LocalDate manuFacturingDate, String cpu, int ram, int storage, String os) {
        //부모생성자
        super(code, brand, name, price, manuFacturingDate);
        System.out.println("컴퓨터의 필드 생성자 호출");
//        부모 필드 접근제한자 private이어서 접근불가
//        this.code=code;
//        this.brand=brand;

//        setter방식 가능
//        가능은 하나 잘 안씀
//        this.setCode(code);
//        this.setBrand(brand);

        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
    }

    /**
     * super.부모필드/메소드
     *  - 부모로 부터 물려받은 필드/메소드에 접근 할 수 있다.
     *  - 자식클래스에서 부모영역에 대한 포인터(숨은 변수참조)
     *  - Override메소드 안에서는 this와 구별된다 ex) this.getName() = super.getName()
     * @return
     */
    @Override
    public String getInfo() {
        //여기서 super.getinfo()->그냥 getinfo로 하면 자기 class에 있는 메소드가 호출된다
        // Override이기 때문에 super(부모) this(자기자신)이랑 구분된다
        return "Computer["+super.getInfo()+", " +cpu+", "+ram+", "+storage+", "+os+"]";
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
