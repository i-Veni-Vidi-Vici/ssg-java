package com.sh.inheritance._03.abstraction;

import com.sh.inheritance._02._extends.Car;

import java.time.LocalDate;

public class Computer extends Product {
//    private String code;
//    private String brand;
//    private String name;
//    private int price;
//    private LocalDate manufacturingDate;
    // 상속받음 Product

    private String cpu;
    private int ram;
    private int storage;
    private String os;

    // 기본생성자
    public Computer() {
        //super(); // 자동으로 부모생성자 호출!
        System.out.println("Computer 기본생성자 호출!!!");
    }

    public Computer(String code, String brand, String name, int price, LocalDate manufacturingDate,
                    String cpu, int ram, int storage, String os) {
        // 부모생성자 직접접근 안될때 !!
        super(code, brand, name, price, manufacturingDate); // super는 밑에 올 수 없음 무조건 먼저 호출!!

        System.out.println("Computer 필드 생성자 호출!");

        //이거 왜 안돼? -> product 클래스에 code,brand,name,price,manufacturingDate 는 private라서 프로젝트 바깥에서는 직접접근이 안됨
        // 부모 필드 접근 제한자가 private여서 접근불가
        // 만약 private가 아니고 protected로 바꾸면 가능 근데 이건 다른사람이 만약에 쓴 코드라면 내가 못 바꾸니까 사용 잘 안함

//        this.code = code;
//        this.brand = brand;
//        this.name = name;
//        this.price = price;
//        this.manufacturingDate = manufacturingDate;

//        // setter방식 가능
//        this.setCode(code);
//        this.setBrand(brand);
//        this.setPrice(price);
//        this.setManufacturingDate(manufacturingDate);

        // 직접접근
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
    }

    //setter getter

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
     *
     * super 부모필드/메소드
     * - 부모로 부터 물려받은 필드/메소드에 접근할 수 있다.
     * - 자식클래스에서 부모영역에 대한 숨은 참조변수(포인터)
     * - override메소드안에서는 this와 구분된다.
     * - 그외에는 super와 this가 동일하다. this.getName() = super.getName())
     *
     *
     *
     * @return
     */

    @Override
    public String getInfo(){
        return "Computer[" + super.getInfo() + ", " + cpu + ", " + ram + ", " + storage + ", " + os + "]";
    }

    // "Computer[" + super.getInfo() + cpu + ", " + ram + ", " + storage + ", " + os + "]";

    // getInfo() 하면 this.getInfo() 임. 여기서 호출하면 여기에 있는 getInfo()를 호출하는거라서 무한호출됨 컴퓨터 꺼짐

}
