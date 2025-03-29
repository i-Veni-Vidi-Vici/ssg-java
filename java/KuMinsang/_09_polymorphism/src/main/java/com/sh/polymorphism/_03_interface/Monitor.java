package com.sh.polymorphism._03_interface;

public class Monitor implements IProduct{


    @Override
    public void printInfo() {
        System.out.println("이것은 모니터랍니다"+ MAX_NUM +"개 있답니다");
    }

    public void changeColorMode(){
        System.out.println("모니터의 컬러 모드를 변경합니다");
    }
}
