package com.sh.polymorphism._01.casting;

import javax.print.attribute.standard.PrinterMoreInfoManufacturer;

/**
 * 다형성 활용 - 리턴값
 */
public class App4 {
    public static void main(String[] args) {

        App4 app4=new App4();
        Animal animal =app4.gerateAnimal();
        animal.cry();
    }

    public Animal gerateAnimal(){
        return (int)(Math.random()*2)+1==0?
                new Rabbit():new Tiger();
    }


}
