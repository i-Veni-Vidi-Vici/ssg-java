package com.sh.inheritance._03.abstraction;

import java.time.LocalDate;

public class Computer extends Product {
    private String cpu;
    private int ram;
    private int storage;
    private String os;

    public Computer() {
        //super();가 생략되어 있다
        System.out.println("computer 기본 생성자 호출");
    }


    public Computer(String code, String brand, String name, int price, LocalDate manufacturingDate,
                    String cpu, int ram, int storage, String os) {
        super(code, brand, name, price, manufacturingDate); //부모 클래스의 생성자를 호출, 필드가 같은 생성자를 찾아서 실행한다
        //부모의 필드 접근자가 private 이므로 접근 불가 => super를 사용하거나 protected로 접근제한자를 바꾸어 줘야한다
        //setter도 가능
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
    }

    /**
     * 부모 클래스 멤버 변수는 이미 부모 클래스에서 선언 되어 있음
     * 자식 getter setter만 작성
     * @return
     */
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
     * super.부모필드/메소드
     * -부모로부터 물려 받은 필드 / 메소드에 접근할수 있다.
     * - 자식클래스에서 부모영역에 대한 숨은 참조변수(포인터)
     * - override 메소드 안에서는 this 와 구분된다
     * - 그외에는 super와 this가 동일하다 (this.getname / super.getname)
     *
     * @return
     */

    @Override
    public String getInfo(){
        //return "computer["+getCode()+", " + getBrand()+ ", "+cpu+", "+ram+", "+storage+", "+os+"]";
        //code와 brand를 접근하기 위해 getCode와 getBrand를 사용했다
        return "computer["+super.getInfo()+", "+cpu+", "+ram+", "+storage+", "+os+"]";
        //부모 클래스의 getInfo를 호출하여 해결
    }
}
